package easy.binary_search;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * @author wenhanglei
 */
public class IntersectionOfTwoArrays {
	/*
	 * 思路：
	 * 使用两个set保存交集
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        if(nums1.length < nums2.length){
        	for(int i = 0; i < nums1.length; i++){
        		set.add(nums1[i]);
        	}
        	for(int i = 0; i < nums2.length; i++){
        		if(set.contains(nums2[i]))
        			inter.add(nums2[i]);
        	}
        }else{
        	for(int i = 0; i < nums2.length; i++){
        		set.add(nums2[i]);
        	}
        	for(int i = 0; i < nums1.length; i++){
        		if(set.contains(nums1[i]))
        			inter.add(nums1[i]);
        	}
        }
        
        int[] ret = new int[inter.size()];
        int j = 0;
        for(int i : inter){
        	ret[j++] = i;
        }
        return ret;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
