package medium.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import utils.ArrayUtil;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below. For example, given the
 * following triangle
 * 
 * @author wenhanglei
 */
public class Triangle {
	/*
	 * 思路:保存每一个阶段所有可能的结果，在最后一个阶段找到最小值即为答案
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int m = triangle.size();
		int[] ret = new int[m];
		
		for(int i = 0; i < m; i++){
			List<Integer> list = triangle.get(i);
			int preNum = ret[0];
			for(int j = 0; j <= i; j++){
				if(j == 0){
					ret[j] = list.get(j) + ret[0];
				}else if(j == list.size()-1){
					ret[j] = list.get(j) + preNum;
				}else{
					int temp = ret[j];
					ret[j] = list.get(j) + Math.min(preNum, ret[j]);
					preNum = temp;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < m; i++) min = Math.min(ret[i], min);
		return min;
	}
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Triangle sol = new Triangle();
		List<List<Integer>> triangle = new LinkedList<>();
		triangle.add(ArrayUtil.getList(new int[]{2}));
		triangle.add(ArrayUtil.getList(new int[]{3, 4}));
		triangle.add(ArrayUtil.getList(new int[]{6, 5, 7}));
		triangle.add(ArrayUtil.getList(new int[]{4, 1, 8, 3}));
		int ret = sol.minimumTotal(triangle);
		System.out.println(ret);
	}
}
