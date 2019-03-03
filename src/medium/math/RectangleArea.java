package medium.math;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane. Each
 * rectangle is defined by its bottom left corner and top right corner as shown
 * in the figure.
 * 
 * @author wenhanglei
 */
public class RectangleArea {
	/*
	 * 思路：计算两个矩阵共同占用的面积
	 */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int area1 = (C - A)*(D - B);
		int area2 = (G - E)*(H - F);
		
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int bottom = Math.max(B, F);
		int top = Math.min(D, H);
		if(C < E || G < A || F > D || B > H) return area1 + area2;
		else{
			int area3 = (right - left)*(top - bottom);
			return area1+area2-area3;
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
