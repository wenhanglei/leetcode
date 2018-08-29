package easy.array;

/**
 * Given an array of integers nums, write a method that returns the "pivot"
 * index of this array.
 * 
 * We define the pivot index as the index where the sum of the numbers to the
 * left of the index is equal to the sum of the numbers to the right of the
 * index.
 * 
 * If no such index exists, we should return -1. If there are multiple pivot
 * indexes, you should return the left-most pivot index.
 * 
 * @author wenhanglei
 */
public class FindPivotIndex {
	/*
	 * 思路：先向右遍历累加，在向左遍历累减
	 */
	public int pivotIndex(int[] nums) {
		//边界检查
		if(nums == null || nums.length < 3) return -1;
		int[] cnt = new int[nums.length];
		int sum = nums[nums.length-1];
		for(int i = nums.length-1; i >= 0; i--){
			if(i == nums.length-1) cnt[i] = 0;
			else {
				cnt[i] = sum;
				sum += nums[i];
			}
		}
		sum = nums[0];
		for(int i = 0; i < nums.length; i++){
			if(i == 0) cnt[i] -= 0;
			else{
				cnt[i] -= sum;
				sum += nums[i];
			}
			if(cnt[i] == 0) return i;
		}
		return -1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		FindPivotIndex sol = new FindPivotIndex();
		int ret = sol.pivotIndex(new int[]{-1, -1, -1, -1, -1, 0});
		System.out.println(ret);
	}
}
