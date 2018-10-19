package medium.array;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * @author wenhanglei
 */
public class ContainerWithMostWater {
	/*
	 * 思路：双指针遍历检查即可
	 */
	public int maxArea(int[] height) {
		int i = 0, j = height.length-1;
		int ret = (j-i)*Math.min(height[i], height[j]);
		while(i < j){
			if(height[i] <= height[j]) i++;
			else j--;
			int area = (j-i)*Math.min(height[i], height[j]);
			if(area > ret) ret = area;
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ContainerWithMostWater sol = new ContainerWithMostWater();
		int[] arr1 = {2,3,4,5,18,17,6}; //结果17
		int[] arr2 = {1,8,6,2,5,4,8,3,7}; //结果49
		int ret = sol.maxArea(arr1);
		System.out.println(ret);
	}
}
