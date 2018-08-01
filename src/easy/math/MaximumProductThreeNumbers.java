package easy.math;


/**
 * Given an integer array, find three numbers whose product is maximum and
 * output the maximum product.
 * 
 * @author wenhanglei
 */
public class MaximumProductThreeNumbers {
	/*
	 * 思路：排序找到最大的三个数 和最小的两个数
	 */
	public int maximumProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1, min1 = Integer.MAX_VALUE, min2 = min1;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] >= max1){
				max3 = max2;
				max2 = max1;
				max1 = nums[i];
			}else{
				if(nums[i] >= max2){
					max3 = max2;
					max2 = nums[i];
				}else{
					max3 = Math.max(nums[i], max3);
				}
			}
			if(nums[i] <= min1){
				min2 = min1;
				min1 = nums[i];
			}else{
				min2 = Math.min(nums[i], min2);
			}
		}
		return Math.max(max1*max2*max3, max1*min1*min2);
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MaximumProductThreeNumbers sol = new MaximumProductThreeNumbers();
		int ret = sol.maximumProduct(new int[] { -4, -3, -2, -1, 60});
		System.out.println(ret);
	}
}
