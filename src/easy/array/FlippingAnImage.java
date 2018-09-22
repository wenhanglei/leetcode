package easy.array;

import java.util.Arrays;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert
 * it, and return the resulting image.
 * 
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * 
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced
 * by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * 
 * @author wenhanglei
 */
public class FlippingAnImage {
	/*
	 * 思路：先对矩阵进行水平翻转再对每个值求它的逆
	 */
	public int[][] flipAndInvertImage(int[][] A) {
		//先对每个横坐标翻转
		for(int i = 0; i < A.length; i++){
			flipAndInvertArray(A[i]);
		}
		return A;
	}
	
	private void flipAndInvertArray(int[] arr){
		for(int i = 0, j = arr.length-1; i < j; i++, j--){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		for(int i = 0; i < arr.length; i++){
			arr[i] = 1-arr[i];
		}
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		FlippingAnImage sol = new FlippingAnImage();
	}
}
