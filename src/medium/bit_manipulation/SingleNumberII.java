package medium.bit_manipulation;

/**
 * Given a non-empty array of integers, every element appears three times except
 * for one, which appears exactly once. Find that single one.
 * 
 * @author wenhanglei
 */
public class SingleNumberII {
	/*
	 * 思路：这个真没思路
	 */
	public int singleNumber(int[] nums) {
		int a = 0, b = 0;
		for(int i = 0; i < nums.length; i++){
			a = (a ^ nums[i]) & ~b;
			b = (b ^ nums[i]) & ~a;
		}
		return a;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
