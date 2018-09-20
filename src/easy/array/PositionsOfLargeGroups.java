package easy.array;

import java.util.LinkedList;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of
 * the same character.
 * 
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx",
 * "z" and "yy".
 * 
 * Call a group large if it has 3 or more characters. We would like the starting
 * and ending positions of every large group.
 * 
 * The final answer should be in lexicographic order.
 * 
 * @author wenhanglei
 */
public class PositionsOfLargeGroups {
	/*
	 * 思路：遍历统计保存即可
	 */
	public List<List<Integer>> largeGroupPositions(String S) {
		//边界检查
		if(S == null) return null;
		List<List<Integer>> ret = new LinkedList<>();
		char c = S.charAt(0);
		int begin = 0, end = 0;
		while(end < S.length()){
			if(S.charAt(end) != S.charAt(begin)){
				if(end - begin > 2){
					List<Integer> list = new LinkedList<>();
					list.add(begin);
					list.add(end-1);
					ret.add(list);
				}
				begin = end;
			}
			end++;
		}
		if(end - begin > 2){
			List<Integer> list = new LinkedList<>();
			list.add(begin);
			list.add(end-1);
			ret.add(list);
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PositionsOfLargeGroups sol = new PositionsOfLargeGroups();
		List<List<Integer>> ret = sol.largeGroupPositions("aaa");
		System.out.println(ret);
	}
}
