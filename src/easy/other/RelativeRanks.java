package easy.other;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Given scores of N athletes, find their relative ranks and the people with the
 * top three highest scores, who will be awarded medals: "Gold Medal",
 * "Silver Medal" and "Bronze Medal".
 * 
 * @author wenhanglei
 */
public class RelativeRanks {
	/*
	 * 思路：
	 */
	public String[] findRelativeRanks(int[] nums) {
		if (nums == null)
			return null;
		String[] ret = new String[nums.length];
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], i);
		setMedal(ret, map);
		return ret;
	}

	private void setMedal(String[] mems, TreeMap<Integer, Integer> map) {
		String[] medals = { "Gold Medal", "Silver Medal", "Bronze Medal" };
		int rank = 0;
		while (!map.isEmpty())
			mems[map.pollLastEntry().getValue()] = rank < 3 ? medals[rank++]
					: ++rank + "";
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		RelativeRanks sol = new RelativeRanks();
		int[] nums = { 5, 4, 3, 2, 1 };
		String[] ret = sol.findRelativeRanks(nums);
		System.out.println(Arrays.toString(ret));
	}
}
