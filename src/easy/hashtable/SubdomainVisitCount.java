package easy.hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/**
 * A website domain like "discuss.leetcode.com" consists of various subdomains.
 * At the top level, we have "com", at the next level, we have "leetcode.com",
 * and at the lowest level, "discuss.leetcode.com". When we visit a domain like
 * "discuss.leetcode.com", we will also visit the parent domains "leetcode.com"
 * and "com" implicitly.
 * 
 * @author wenhanglei
 */
public class SubdomainVisitCount {
	/*
	 * 思路：使用map统计并保存数据即可
	 */
	public List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < cpdomains.length; i++){
			String[] str = cpdomains[i].split(" ");
			int cnt = Integer.parseInt(str[0]);
			String domain = str[1];
			int idx = domain.indexOf('.');
			while(idx != -1){
				map.put(domain, map.containsKey(domain)?map.get(domain)+cnt:cnt);
				domain = domain.substring(idx+1);
				idx = domain.indexOf('.');
			}
			map.put(domain, map.containsKey(domain)?map.get(domain)+cnt:cnt);
		}
		List<String> list = new LinkedList<>();
		for(Entry<String, Integer> ent : map.entrySet()){
			String s = ent.getValue().toString() + " " + ent.getKey();
			list.add(s);
		}
		return list;
	}
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		SubdomainVisitCount sol = new SubdomainVisitCount();
		List<String> list = sol.subdomainVisits(cpdomains);
		System.out.println(list);
	}
}
