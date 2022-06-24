package medium.array;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and
 * nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 * @author ephemeral
 * @date 2022/6/24 17:05
 */
public class IncreasingTripletSubsequence {

    /**
     * 最粗暴的方法，三层循环
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if(nums != null && nums.length < 3) {
            return false;
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    for(int k = j+1; k < nums.length; k++) {
                        if(nums[k] > nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{5,4,3,2,1};
        int[] nums3 = new int[]{2,1,5,0,4,6};
        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();
        boolean ret1 = solution.increasingTriplet(nums1);
        boolean ret2 = solution.increasingTriplet(nums2);
        boolean ret3 = solution.increasingTriplet(nums3);
        System.out.println(ret1);
        System.out.println(ret2);
        System.out.println(ret3);
    }

}
