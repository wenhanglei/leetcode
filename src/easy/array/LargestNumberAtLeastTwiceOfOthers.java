package easy.array;

/**
 * In a given integer array nums, there is always exactly one largest element.
 * 
 * Find whether the largest element in the array is at least twice as much as
 * every other number in the array.
 * 
 * If it is, return the index of the largest element, otherwise return -1.
 * 
 * @author wenhanglei
 */
public class LargestNumberAtLeastTwiceOfOthers {
	/*
	 * 思路：遍历即可
	 */
	public int dominantIndex(int[] nums) {
		//边界检查
		if(nums == null) return -1;
		int maxIdx = 0;
		boolean isValid = true;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] > nums[maxIdx]){
				if(nums[maxIdx] > nums[i]/2) isValid = false;
				else isValid = true;
				maxIdx = i;
			}else if(nums[i] > nums[maxIdx]/2){
				isValid= false;
			}
		}
		if(isValid) return maxIdx;
		else return -1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LargestNumberAtLeastTwiceOfOthers sol = new LargestNumberAtLeastTwiceOfOthers();
		int ret = sol.dominantIndex(new int[]{1});
		System.out.println(ret);
	}
}
