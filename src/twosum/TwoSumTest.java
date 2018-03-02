package twosum;

import java.util.Arrays;

import org.junit.Test;

public class TwoSumTest {
	@Test
	public void TestTwoSum(){
		int[] nums = {3, 3};
		TwoSum sol = new TwoSum();
		int[] twoSum = sol.twoSum(nums, 6);
		System.out.println(Arrays.toString(twoSum));
	}
}
