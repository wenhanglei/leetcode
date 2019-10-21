package medium.bit_manipulation;

import java.util.Arrays;

/**
 * @author: wenhanglei
 * @date: 2019/6/19
 * @time: 11:02
 * @info: Given an array of numbers nums, in which exactly two
 *      elements appear only once and all the other elements appear
 *      exactly twice. Find the two elements that appear only once.
 */
public class SingleNumberIII {

    //思路：
    //
    public int[] singleNumber(int[] nums) {

        //边界检查
        if(nums == null || nums.length == 0) {
            return null;
        }

        //获取两个不同值的异或后的结果
        int xor = nums[0];
        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }

        int[] ret = new int[2];

        ret[0] = xor;
        ret[1] = xor-(xor & -xor);
        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0) {
                ret[0] ^= nums[i];
            }else {
                ret[1] ^= nums[i];
            }
        }

        return ret;

    }

    public int singleNum(int[] nums){
        //边界检查
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("参数传递错误");
        }

        int ret = 0;
        for(int i = 0; i < nums.length; i++){
            ret = ret^nums[i];
        }
        return ret;
    }

    //测试函数
    public static void main(String[] args){
        SingleNumberIII sol = new SingleNumberIII();
        int[] nums = {1, 2, 1, 3, 2, 4};
//        int ret = sol.singleNum(nums);
//        System.out.println(ret);

        int[] ret = sol.singleNumber(nums);
        System.out.println(Arrays.toString(ret));
    }

}
