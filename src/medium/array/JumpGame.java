package medium.array;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * @author wenhanglei
 */
public class JumpGame {
	/*
	 * 思路：方案一：递归遍历但是时间复杂度太高
	 * 方案二：使用boolean数组作为确定为失败的标记，用以阻止重复遍历
	 * 方案三：只遍历能到达尾下标的路径，查找其源头是否是第一个下标
	 */
	
	public boolean canJump(int[] nums) {
		int lo = nums.length-1;         //the lowest index can reach the last index
		for(int i = lo; i >= 0; i--)
			if(nums[i] >= lo-i) lo = i;
		return lo == 0;
	}
	
//	public boolean canJump(int[] nums) {
//		boolean[] marked  = new boolean[nums.length];
//		return help(nums, 0, marked);
//	}
	
//	private boolean help(int[] nums, int idx, boolean[] marked){
//		if(marked[idx]) return false;
//		if(idx == nums.length-1) return true;
//		for(int i = nums[idx]; i > 0; i--){
//			if(idx+i > nums.length-1) continue;
//			if(help(nums, idx+i, marked)) return true;
//		}
//		marked[idx] = true;
//		return false;
//	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		JumpGame sol = new JumpGame();
		boolean ret = sol.canJump(nums);
		System.out.println(ret);
	}
}
