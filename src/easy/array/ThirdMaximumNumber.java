package easy.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the 
 * third maximum number in this array. If it does not 
 * exist, return the maximum number. The time complexity 
 * must be in O(n).
 * @author wenhanglei
 */
public class ThirdMaximumNumber {
	/*
	 * 思路：
	 * 方案一：使用长度为3的小根堆
	 */
	public int thirdMax(int[] nums) {
		//创建长度为3的小根堆
		PriorityQueue<Integer> pq = new PriorityQueue<>(3);
		for(int i = 0; i < nums.length; i++){
			if(pq.size() < 3){
				if(!pq.contains(nums[i]))
					pq.offer(nums[i]);
			}else{
				if(!pq.contains(nums[i]) && pq.peek() < nums[i])
					pq.offer(nums[i]);
				if(pq.size() == 4)
					pq.poll();
			}
		}
		if(pq.size() < 3) while(pq.size()!=1) pq.poll();
        return pq.poll();
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ThirdMaximumNumber sol = new ThirdMaximumNumber();
		int[] arr = {1, 2, 2, 5, 3, 5};
		int ret = sol.thirdMax(arr);
		System.out.println(ret);
	}
}
