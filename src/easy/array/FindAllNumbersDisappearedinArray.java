package easy.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Find all the elements of [1, n] inclusive that 
 * do not appear in this array.
 * @author wenhanglei
 */
public class FindAllNumbersDisappearedinArray {
	/*
	 * 思路：
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ret = new LinkedList<>();
		//遍历整个数组将数字对应下标的值变为负数
		for(int i = 0; i < nums.length; i++){
			int val = Math.abs(nums[i])-1;
			if(nums[val] > 0)
				nums[val] = -nums[val];
		}
		//再次遍历变动后的数组，不是负数的下标则是结果
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > 0) ret.add(i+1);
		}
		return ret;
    }
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		FindAllNumbersDisappearedinArray sol = new FindAllNumbersDisappearedinArray();
		int[] arr = {4,3,2,7,8,2,3,1};
		List<Integer> ret = sol.findDisappearedNumbers(arr);
		System.out.println(ret);
	}
}
