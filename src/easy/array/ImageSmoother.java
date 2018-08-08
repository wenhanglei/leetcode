package easy.array;

import java.util.Arrays;

/**
 * Given a 2D integer matrix M representing the gray scale of an image, you need
 * to design a smoother to make the gray scale of each cell becomes the average
 * gray scale (rounding down) of all the 8 surrounding cells and itself. If a
 * cell has less than 8 surrounding cells, then use as many as you can.
 * 
 * @author wenhanglei
 */
public class ImageSmoother {
	/*
	 * 思路：
	 */
	public int[][] imageSmoother(int[][] M) {
		int row = M.length, col = M[0].length;
		int[][] ret = new int[row][col];
		for(int i = 0; i < row*col; i++){
			ret[i/col][i%col] = index(M, i);
		}
		return ret;
	}
	
	private int index(int[][] M, int i){
		int r = i/M[0].length;
		int c = i%M[0].length;
		int product = M[r][c];
		if(M.length == 1 && M[0].length == 1) return product;
		else if(M.length == 1){
			if(c == 0){
				product += M[r][c+1];
				return product/2;
			}else if(c == M[0].length-1){
				product += M[r][c-1];
				return product/2;
			}else{
				product += M[r][c+1];
				product += M[r][c-1];
				return product/3;
			}
		}else if(M[0].length == 1){
			if(r == 0){
				product += M[r+1][c];
				return product/2;
			}else if(r == M.length-1){
				product += M[r-1][c];
				return product/2;
			}else{
				product += M[r+1][c];
				product += M[r-1][c];
				return product/3;
			}
		}
		else{
			if(r == 0){
				product += M[r+1][c];
				if(c == 0){
					product += M[r+1][c+1];
					product += M[r][c+1];
					return product/4;
				}else if(c == M[0].length-1){
					product += M[r+1][c-1];
					product += M[r][c-1];
					return product/4;
				}else{
					product += M[r+1][c+1];
					product += M[r][c+1];
					product += M[r+1][c-1];
					product += M[r][c-1];
					return product/6;
				}
			}else if(r == M.length-1){
				product += M[r-1][c];
				if(c == 0){
					product += M[r-1][c+1];
					product += M[r][c+1];
					return product/4;
				}else if(c == M[0].length-1){
					product += M[r-1][c-1];
					product += M[r][c-1];
					return product/4;
				}else{
					product += M[r-1][c+1];
					product += M[r][c+1];
					product += M[r-1][c-1];
					product += M[r][c-1];
					return product/6;
				}
			}else{
				if(c == 0){
					product += M[r-1][c];
					product += M[r+1][c];
					product += M[r-1][c+1];
					product += M[r+1][c+1];
					product += M[r][c+1];
					return product/6;
				}else if(c == M[0].length-1){
					product += M[r-1][c];
					product += M[r+1][c];
					product += M[r-1][c-1];
					product += M[r+1][c-1];
					product += M[r][c-1];
					return product/6;
				}else{
					product += M[r-1][c];
					product += M[r+1][c];
					product += M[r-1][c-1];
					product += M[r+1][c+1];
					product += M[r][c+1];
					product += M[r][c-1];
					product += M[r+1][c-1];
					product += M[r-1][c+1];
					return product/9;
				}
			}
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ImageSmoother sol = new ImageSmoother();
		int[][] arr = {
				{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1}
		};
		int[][] ret = sol.imageSmoother(arr);
	}
}
