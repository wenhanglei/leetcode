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
//	public List<String> readBinaryWatch(int num) {
//		List<String> ret = new LinkedList<>();
//		if(num > 10) return ret;                    //边界检查
//		byte hour = 0, minutes = 0;
//        return ret;
//    }
	
	//方案二
	public List<String> readBinaryWatch(int num) {
		List<String> ret = new LinkedList<>();
		if(num > 10) return ret;                    //边界检查
		for(int h = 0; h < 12; h++){
			for(int m = 0; m < 60; m++){
				if(Integer.bitCount(h*64 + m)==num)
					ret.add(""+h+":"+((m<10)?"0"+m:m));
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		BinaryWatch sol = new BinaryWatch();
		List<String> ret = sol.readBinaryWatch(1);
		System.out.println(ret);
	}
}
