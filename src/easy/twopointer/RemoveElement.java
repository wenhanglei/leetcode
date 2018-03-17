package easy.twopointer;
/**
 * Given an array and a value, remove all instances 
 * of that value in-place and return the new length.
 * Do not allocate extra space for another array, 
 * you must do this by modifying the input array 
 * in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't 
 * matter what you leave beyond the new length.
 * @author wenhanglei
 */
public class RemoveElement {
	/*
	 * 思路：
	 * 双指针
	 */
	public int removeElement(int[] nums, int val) {
		//边界检查
		if(nums == null && nums.length == 0) return 0;
		//头指针尾指针
		int head = 0, tail = nums.length-1;
		while(head <= tail){
			//如果尾指针的值等于需要删除的值则尾指针向左移动
			while(tail >= 0 && nums[tail] == val)
				tail--;
			//如果头指针的值不等于需要删除的值则头指针向右移动
			while(head < nums.length && nums[head] != val)
				head++;
			if(head < tail){
				int temp = nums[head];
				nums[head] = nums[tail];
				nums[tail] = temp;
			}
		}
        return head;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {1, 3};
		RemoveElement sol = new RemoveElement();
		int res = sol.removeElement(arr, 3);
		System.out.println(res);
	}
}
