package easy.binary_search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 * @author wenhanglei
 */
public class IntersectionOfTwoArraysII {
	/*
	 * 思路：
	 * 将两个数组排序
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new LinkedList<>();
        int i=0, j=0;
        while(i < nums1.length && j < nums2.length){
        	if(nums1[i] == nums2[j]){
        		list.add(nums1[i]);
        		j++;
        		i++;
        	}else if(nums1[i] > nums2[j]){
        		j++;
        	}else if(nums1[i] < nums2[j]){
        		i++;
        	}
        }
        int[] ret = new int[list.size()];
        for(i = 0; i < list.size(); i++){
        	ret[i] = list.get(i);
        }
        return ret;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		IntersectionOfTwoArraysII sol = new IntersectionOfTwoArraysII();
		int[] ret = sol.intersect(nums1, nums2);
		System.out.println(Arrays.toString(ret));
	}
}
