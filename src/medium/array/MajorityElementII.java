package medium.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * @author wenhanglei
 */
public class MajorityElementII {
	/*
	 * 思路：摩尔投票算法，使用两个计数器保存两个候选码
	 */
	public List<Integer> majorityElement(int[] nums) {
		//边界检查
		List<Integer> list = new LinkedList<>();
		if(nums == null || nums.length == 0) return list;
		
		Integer candidateOne = null;
		Integer candidateTwo = null;
		int countOne = 0;
		int countTwo = 0;
		//第一次遍历找到可能的结果
		for(int i = 0; i < nums.length; i++){
			if(candidateOne != null && candidateTwo != null){
				if(nums[i] == candidateOne) countOne++;
				else if(nums[i] == candidateTwo) countTwo++;
				else{
					countOne--;
					countTwo--;
					if(countOne == 0) candidateOne = null;
					if(countTwo == 0) candidateTwo = null;
				}
			}else if(candidateOne == null && candidateTwo == null){
				candidateOne = nums[i];
				countOne++;
			}else if(candidateOne == null){
				if(nums[i] == candidateTwo) countTwo++;
				else {
					candidateOne = nums[i];
					countOne++;
				}
			}else if(candidateTwo == null){
				if(nums[i] == candidateOne) countOne++;
				else{
					candidateTwo = nums[i];
					countTwo++;
				}
			}
		}
		
		

		if(candidateOne != null){
			int num = 0;
			for(int i = 0; i < nums.length; i++){
				if(nums[i] == candidateOne) num++;
			}
			if(3*num > nums.length) list.add(candidateOne);
		}
		
		if(candidateTwo != null){
			int num = 0;
			for(int i = 0; i < nums.length; i++){
				if(nums[i] == candidateTwo) num++;
			}
			if(3*num > nums.length) list.add(candidateTwo);
		}
		
		return list;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MajorityElementII sol = new MajorityElementII();
		int[] nums = {-1,1,1,1,2,1};
		List<Integer> ret = sol.majorityElement(nums);
		System.out.println(ret);
	}
}
