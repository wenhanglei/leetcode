package easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of 
 * Pascal's triangle.Given numRows, 
 * generate the first numRows of Pascal's triangle.
 * @author wenhanglei
 */
public class PascalTriangle {
	/*
	 * 思路：
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		if(numRows == 0) return res;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		res.add(list);
		for(int i = 1; i < numRows; i++){
			list = new ArrayList<>();
			list.add(1);
			List<Integer> preList = res.get(i-1);
			for(int j = 0; j < preList.size()-1; j++){
				list.add(preList.get(j) + preList.get(j+1));
			}
			list.add(1);
			res.add(list);
		}
        return res;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PascalTriangle sol = new PascalTriangle();
		List<List<Integer>> res = sol.generate(5);
		System.out.println(res);
	}
}
