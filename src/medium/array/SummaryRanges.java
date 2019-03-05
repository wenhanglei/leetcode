package medium.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * @author wenhanglei
 */
public class SummaryRanges {
	/*
	 * 思路：遍历检查即可
	 */
	public List<String> summaryRanges(int[] nums) {
		//边界检查
		List<String> ret = new LinkedList<>();
		if(nums == null || nums.length == 0) return ret;
		int pre = nums[0];
		for(int i = 1; i <= nums.length; i++){
			while(i < nums.length && nums[i]-1 == nums[i-1]) i++;
			if(nums[i-1] != pre){
				ret.add(pre + "->" + nums[i-1]);
			}else ret.add(pre + "");
			if(i == nums.length) break;
			pre = nums[i];
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SummaryRanges sol = new SummaryRanges();
		int[] nums = {0,2,3,4,6,8,9};
		List<String> ret = sol.summaryRanges(nums);
		System.out.println(ret);
	}
}
