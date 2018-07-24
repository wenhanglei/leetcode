package easy.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array with even length, where different numbers in this
 * array represent different kinds of candies. Each number means one candy of
 * the corresponding kind. You need to distribute these candies equally in
 * number to brother and sister. Return the maximum number of kinds of candies
 * the sister could gain.
 * 
 * @author wenhanglei
 */
public class DistributeCandies {
	/*
	 * 思路：
	 * 统计总的不相同数字
	 */
	public int distributeCandies(int[] candies) {
		//边界检查
		if(candies == null || candies.length == 0) return 0;
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < candies.length; i++){
			set.add(candies[i]);
		}
		return Math.min(candies.length/2, set.size());
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		DistributeCandies sol = new DistributeCandies();
		int ret = sol.distributeCandies(new int[]{1,1,2,2,3,3});
		System.out.println(ret);
	}
}
