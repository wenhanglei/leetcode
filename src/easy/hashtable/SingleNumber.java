package easy.hashtable;
/**
 * Given an array of integers, every element appears 
 * twice except for one. Find that single one.
 * @author wenhanglei
 */
public class SingleNumber {
	/*
	 * 思路：
	 * 相同的数字异或为0
	 */
	public int singleNumber(int[] nums) {
		//结果变量
		int res = 0;
		for(int i = 0; i < nums.length; i++){
			res ^= nums[i];
		}
		return res;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
	}
}
