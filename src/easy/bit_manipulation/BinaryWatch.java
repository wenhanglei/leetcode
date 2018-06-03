package easy.bit_manipulation;

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
	 * 回溯法
	 */
	public List<String> readBinaryWatch(int num) {
		List<String> ret = new LinkedList<>();
		//边界检查
		if(num > 10) return ret;
		byte hour = 0, minutes = 0;
		help(hour, minutes, num, ret);
        return ret;
    }
	
	private boolean help(byte h, byte m, int num, List<String> list){
		//8, 4, 2, 1
		//32, 16, 8, 4, 2, 1
		help(h|1, m, num-1, list);
		help(h|(1<<1), m, num-1, list);
		help(h|(1<<2), m, num-1, list);
		help(h|(1<<3), m, num-1, list);
		
		help(h, m|1, num-1, list);
		help(h, m|(1<<1), num-1, list);
		help(h, m|(1<<2), num-1, list);
		help(h, m|(1<<2), num-1, list);
		help(h, m|(1<<3), num-1, list);
		help(h, m|(1<<4), num-1, list);
		help(h, m|(1<<5), num-1, list);
		return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		BinaryWatch sol = new BinaryWatch();
		List<String> ret = sol.readBinaryWatch(2);
		System.out.println(ret);
	}
}
