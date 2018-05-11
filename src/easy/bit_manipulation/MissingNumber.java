package easy.bit_manipulation;
/**
 * Given an array containing n distinct numbers taken from 
 * 0, 1, 2, ..., n, find the one that is missing from the array.
 * @author wenhanglei
 */
public class MissingNumber {
	/*
	 * 思路：
	 * 一个数和它本身异或结果为零
	 */
	public int missingNumber(int[] nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			sum = sum^nums[i]^(i+1);
		}
        return sum;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {4, 1, 0, 5, 3};
		MissingNumber sol = new MissingNumber();
		int ret = sol.missingNumber(arr);
		System.out.println(ret);
	}
}
