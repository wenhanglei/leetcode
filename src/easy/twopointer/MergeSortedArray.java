package easy.twopointer;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, 
 * merge nums2 into nums1 as one sorted array.
 * @author wenhanglei
 */
public class MergeSortedArray {
	/*
	 * 思路：
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j = n-1;
		for(int index = m+n-1; index >= 0; index--){
			if(i == -1) {
				nums1[index] = nums2[j--];
				continue;
			}
			if(j == -1) break;
			if(nums1[i] > nums2[j])
				nums1[index] = nums1[i--];
			else
				nums1[index] = nums2[j--];
		}
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums1 = new int[10];
		int[] nums2 = new int[4];
		nums1[0] = 2;
		nums1[1] = 5;
		nums1[2] = 8;
		int m = 3;
		nums2[0] = 1;
		nums2[1] = 3;
		nums2[2] = 4;
		nums2[3] = 7;
		int n = 4;
		MergeSortedArray sol = new MergeSortedArray();
		sol.merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
}
