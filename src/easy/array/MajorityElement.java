package easy.array;

import java.util.HashMap;

/**
 * Given an array of size n, find the majority 
 * element. The majority element is 
 * the element that appears more than ⌊ n/2 ⌋ times.
 * @author wenhanglei
 */
public class MajorityElement {
	/*
	 * 思路：
	 * 使用map计数
	 */
	public int majorityElement(int[] nums) {
		if (nums == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
        	if(map.get(nums[i]) == null){
        		map.put(nums[i], 1);
        	}else{
        		map.put(nums[i], map.get(nums[i])+1);
        	}
        }
        for(Integer i : map.keySet()){
        	if(map.get(i) > nums.length/2)
        		return i;
        }
        return 0;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		MajorityElement sol = new MajorityElement();
		int res = sol.majorityElement(nums);
		System.out.println(res);
	}
}
