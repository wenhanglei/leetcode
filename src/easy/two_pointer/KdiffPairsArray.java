package easy.two_pointer;

import java.util.Arrays;

/**
 * Given an array of integers and an integer k, you need to find the number of
 * unique k-diff pairs in the array. Here a k-diff pair is defined as an integer
 * pair (i, j), where i and j are both numbers in the array and their absolute
 * difference is k.
 * 
 * @author wenhanglei
 */
public class KdiffPairsArray {
	/*
	 * 思路：
	 * 双指针可解决
	 */
	public int findPairs(int[] nums, int k) {
		//边界检查
		if(nums == null || nums.length == 1) return 0;
		if(k < 0) return 0;
		//对nums排序
		Arrays.sort(nums);
		//结果变量
		int ret = 0;
		
		if(k == 0){
			int i = 0;
			while(i < nums.length-1){
				int temp = i;
				while(i < nums.length-1 && nums[i+1] == nums[i]) i++;
				if(i != temp) ret++;
				i++;
			}
			return ret;
		}
		
		for(int i = 1; i < nums.length; i++){
			if(i == nums.length-1 || nums[i-1] != nums[i])
				if(Arrays.binarySearch(nums, nums[i-1]+k) >= 0) ret++;
		}
		
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		KdiffPairsArray sol = new KdiffPairsArray();
		int[] nums = {1, 1, 1, 1, 1};
		int ret = sol.findPairs(nums, 0);
		System.out.println(ret);
	}
}
