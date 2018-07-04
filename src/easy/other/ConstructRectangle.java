package easy.other;

import java.util.Arrays;

/**
 * You need to output the length L and the width W of 
 * the web page you designed in sequence.
 * @author wenhanglei
 */
public class ConstructRectangle {
	/*
	 * 思路：
	 * 简单的遍历即可
	 */
	public int[] constructRectangle(int area) {
		//边界判断
		int[] ret = new int[2];
		if(area == 0) return ret;
		int upbound = (int) Math.sqrt(area);
		for(int l = upbound; l >= 0; l--){
			int w = area/l;
			if(w*l == area){
				ret[0] = w;
				ret[1] = l;
				break;
			}
		}
        return ret;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ConstructRectangle sol = new ConstructRectangle();
		int[] ret = sol.constructRectangle(4);
		System.out.println(Arrays.toString(ret));
	}
}
