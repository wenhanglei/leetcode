package easy.other;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Your KthLargest class will have a constructor which accepts an integer k and
 * an integer array nums, which contains initial elements from the stream. For
 * each call to the method KthLargest.add, return the element representing the
 * kth largest element in the stream.
 * 
 * @author wenhanglei
 *
 */
public class KthLargestElementInStream {
	
	private int k;
	private PriorityQueue<Integer> minQueue;
	
	/*
	 * 思路：小根堆
	 */
	public KthLargestElementInStream(int k, int[] nums) {
		this.k = k;
		minQueue = new PriorityQueue<>(k);
		for(int i = 0; i < nums.length; i++){
			if(minQueue.size() == k) {
				if(minQueue.peek()<nums[i]) {
					minQueue.offer(nums[i]);
					minQueue.poll();
				}
			}else minQueue.offer(nums[i]);
		}
	}

	public int add(int val) {
		if(minQueue.size() < k) minQueue.offer(val);
		else if(minQueue.peek() < val){
			minQueue.offer(val);
			minQueue.poll();
		}
		return minQueue.peek();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int k = 3;
		int[] arr = {4, 5, 8, 2};
		KthLargestElementInStream kthLargest = new KthLargestElementInStream(3, arr);
		kthLargest.add(3);   // returns 4
		kthLargest.add(5);   // returns 5
		kthLargest.add(10);  // returns 5
		kthLargest.add(9);   // returns 8
		kthLargest.add(4);   // returns 8
	}
}
