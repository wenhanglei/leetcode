package easy.math;

/**
 * You have a list of points in the plane. Return the area of the largest
 * triangle that can be formed by any 3 of the points.
 * 
 * @author wenhanglei
 */
public class LargestTriangleArea {
	/*
	 * 思路：简单朴素的遍历求解即可
	 */
	public double largestTriangleArea(int[][] points) {
		double ret = 0.0;
		for(int[] p : points){
			for(int[] i: points){
				for(int[] j: points){
					ret = Math.max(ret, 0.5 * Math.abs(i[0] * j[1] + j[0] * p[1] + p[0] * i[1]- j[0] * i[1] - p[0] * j[1] - i[0] * p[1]));
				}
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LargestTriangleArea sol = new LargestTriangleArea();
		int[][] points = {
			{1,0},{0,0},{0,1}
		};
		double ret = sol.largestTriangleArea(points);
		System.out.println(ret);
	}
}
