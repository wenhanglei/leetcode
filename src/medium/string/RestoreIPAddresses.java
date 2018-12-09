package medium.string;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * @author wenhanglei
 */
public class RestoreIPAddresses {
	/*
	 * 思路：使用回溯法递归遍历+各种条件判断筛选结果
	 */
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new LinkedList<>();
		helper(list, s, "", 0, 4);
		return list;
	}
	
	private void helper(List<String> list, String s, String ip, int idx, int count){
		if(count == 1){
			if(s.length() == idx || s.length()-idx > 3) return;
			int num = Integer.parseInt(s.substring(idx));
			if(s.charAt(idx) == '0' && s.length()-idx != 1) return;
			if(0 <= num && num <= 255) list.add(ip+s.substring(idx));
			return;
		}
		if(s.length() >= idx+3){
			int num = Integer.parseInt(s.substring(idx, idx+3));
			if(100 <= num && num <= 255) {
				helper(list, s, ip+s.substring(idx, idx+3)+".", idx+3, count-1);
			}
		}
		if(s.length() >= idx+2){
			int num = Integer.parseInt(s.substring(idx, idx+2));
			if(10 <= num && num <= 99){
				helper(list, s, ip+s.substring(idx, idx+2)+".", idx+2, count-1);
			}
		}
		if(s.length() != idx){
			helper(list, s, ip+s.charAt(idx)+".", idx+1, count-1);
		}
	}

	public static void main(String[] args) {
		RestoreIPAddresses sol = new RestoreIPAddresses();
//		List<String> ret = sol.restoreIpAddresses("25525511135");
//		List<String> ret = sol.restoreIpAddresses("1111");
//		List<String> ret = sol.restoreIpAddresses("0000");
//		List<String> ret = sol.restoreIpAddresses("010010");
		List<String> ret = sol.restoreIpAddresses("00000");
		System.out.println(ret);
	}
}
