package easy.array;
/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * @author wenhanglei
 */
public class MaxConsecutiveOnes {
	/*
	 * 思路：
	 * 遍历数组即可
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		//边界判断
		if(nums == null) return -1;
		int count = 0;                     //记录当前连续1的个数
		int ret = 0;                       //结果变量
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 1){
				count++;
				if(count > ret) ret = count;
			}else count = 0;
		}
        return ret;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MaxConsecutiveOnes sol = new MaxConsecutiveOnes();
		int[] nums = {1, 0, 1, 1, 0, 1};
		int ret = sol.findMaxConsecutiveOnes(nums);
		System.out.println(ret);
	}
}
