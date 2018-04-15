package easy.math;
/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * @author wenhanglei
 */
public class FactorialTrailingZeroes {
	/*
	 * 思路：
	 * 看是否能被5除尽
	 */
	public int trailingZeroes(int n) {
		int count = 0; 
		while(n != 0) {
			int temp = n/5;
			count += temp;
			n = temp;
		}
        return count;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
