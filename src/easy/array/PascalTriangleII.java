package easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * @author wenhanglei
 */
public class PascalTriangleII {
	/*
	 * 思路：
	 */
	public List<Integer> getRow(int rowIndex) {
		//前一列保存的帕斯卡列
		List<Integer> res = new ArrayList<>();
		res.add(1);
		for(int i = 0; i < rowIndex; i++){
			List<Integer> temp = new ArrayList<>();
			temp.add(1);
			for(int j = 0; j < res.size()-1; j++){
				temp.add(res.get(j) + res.get(j+1));
			}
			temp.add(1);
			res = temp;
		}
        return res;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PascalTriangleII sol = new PascalTriangleII();
		List<Integer> res = sol.getRow(3);
		System.out.println(res);
	}
}
