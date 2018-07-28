package easy.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
 * have a list of favorite restaurants represented by strings. You need to help
 * them find out their common interest with the least list index sum. If there
 * is a choice tie between answers, output all of them with no order
 * requirement. You could assume there always exists an answer.
 * 
 * @author wenhanglei
 */
public class MinimumIndexSumTwoLists {
	/*
	 * 思路：
	 * 使用hashmap
	 */
	public String[] findRestaurant(String[] list1, String[] list2) {
		//因为答案肯定存在所以不需要边界检查
		HashMap<String, Integer> map1 = new HashMap<>();
		TreeMap<Integer, List<String>> map2 = new TreeMap<>();
		for(int i = 0; i < list1.length; i++)
			map1.put(list1[i], i);
		for(int i = 0; i < list2.length; i++){
			if(map1.containsKey(list2[i])){
				int index = map1.get(list2[i]) + i;
				if(map2.containsKey(index))
					map2.get(index).add(list2[i]);
				else{
					List li = new LinkedList<String>();
					li.add(list2[i]);
					map2.put(index, li);
				}
			}
		}
		List<String> ret = map2.firstEntry().getValue();
		String[] r = new String[ret.size()];
		int i = 0;
		for(String s : ret){
			r[i++] = s;
		}
		return r;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		MinimumIndexSumTwoLists sol = new MinimumIndexSumTwoLists();
		String[] ret = sol.findRestaurant(list1, list2);
		System.out.println(Arrays.toString(ret));
	}
}
