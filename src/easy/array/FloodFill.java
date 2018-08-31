package easy.array;

/**
 * An image is represented by a 2-D array of integers, each integer representing
 * the pixel value of the image (from 0 to 65535).
 * 
 * Given a coordinate (sr, sc) representing the starting pixel (row and column)
 * of the flood fill, and a pixel value newColor, "flood fill" the image.
 * 
 * To perform a "flood fill", consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color as the starting pixel), and so on. Replace the
 * color of all of the aforementioned pixels with the newColor.
 * 
 * At the end, return the modified image.
 * 
 * @author wenhanglei
 */
public class FloodFill {
	/*
	 * 思路：深度优先遍历即可
	 */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		//边界检查
		if(!checkValid(image, sr, sc) || image[sr][sc] == newColor) return image;
		help(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}
	
	private void help(int[][] arr, int x, int y, int val, int preVal){
		if(!checkValid(arr, x, y)) return;
		if(arr[x][y] == preVal){
			arr[x][y] = val;
			help(arr, x+1, y, val, preVal);
			help(arr, x-1, y, val, preVal);
			help(arr, x, y+1, val, preVal);
			help(arr, x, y-1, val, preVal);
		}
	}
	
	private boolean checkValid(int[][] arr, int x, int y){
		int rows = arr.length;
		int cols = arr[0].length;
		if(0 <= x && x < rows && 0 <= y && y < cols) return true;
		else return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		FloodFill sol = new FloodFill();
		int[][] image = {
				{1, 1, 1},
				{1, 1, 0},
				{1, 0, 1}
		};
		
		sol.floodFill(image, 1, 1, 2);
	}
}
