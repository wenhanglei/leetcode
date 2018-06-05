package easy.bit_manipulation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the 
 * hours (0-11), and the 6 LEDs on the bottom represent 
 * the minutes (0-59).
 * @author wenhanglei
 */
public class BinaryWatch {
	/*
	 * 思路：
	 * 方案一：回溯法
	 * 方案二： 遍历所有值，保存合法值
	 */
	public List<String> readBinaryWatch(int num) {
		List<String> ret = new LinkedList<>();
		if(num > 10) return ret;                    //边界检查
		int[] num1 = {1, 2, 4, 8};
		int[] num2 = {1, 2, 4, 8, 16, 32};
		for(int i = 0; i <= num; i++){
			List<Integer> l1 = getNumList(num1, i);
			List<Integer> l2 = getNumList(num2, num-i);
			for(int j : l1){
				if(j >= 12) continue;
				for(int k : l2){
					if(k >= 60) continue;
					ret.add(""+j+":"+((k<10)?"0"+k:k));
				}
			}
		}
        return ret;
    }
	
	private List<Integer> getNumList(int[] num, int i){
		List<Integer> ret = new LinkedList<>();
		help(num, 0, 0, i, ret);
		return ret;
	}
	
	private void help(int[] num, int n, int sum, int i, List<Integer> list){
		if(i==0){
			list.add(sum);
			return;
		}
		for(int j = n; j < num.length; j++){
			help(num, j+1, sum+num[j], i-1, list);
		}
	}
	
	//方案二
//	public List<String> readBinaryWatch(int num) {
//		List<String> ret = new LinkedList<>();
//		if(num > 10) return ret;                    //边界检查
//		for(int h = 0; h < 12; h++){
//			for(int m = 0; m < 60; m++){
//				if(Integer.bitCount(h*64 + m)==num)
//					ret.add(""+h+":"+((m<10)?"0"+m:m));
//			}
//		}
//		return ret;
//	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		BinaryWatch sol = new BinaryWatch();
		List<String> ret = sol.readBinaryWatch(2);
		System.out.println(ret);
	}
}
