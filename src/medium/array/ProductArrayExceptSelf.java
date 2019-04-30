package medium.array;

import java.util.Arrays;

/**
 * @Author: wenhanglei
 * @Date: 2019/4/28
 * @Time: 11:41
 * @Info:Given an array nums of n integers where n > 1,  return an
 * array output such that output[i] is equal to the product of all
 * the elements of nums except nums[i].
 */
public class ProductArrayExceptSelf {

    //思路：
    public int[] productExceptSelf(int[] nums) {
        //边界检查
        if(nums == null || nums.length == 0) { return null; }
        int len = nums.length;
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        for(int i = 0; i < len; i++){
            arr1[i] = i == 0 ? 1: arr1[i-1]*nums[i-1];
            arr2[len-i-1] = i == 0 ? 1 : arr2[len-i]*nums[len-i];
        }
        int[] ret = new int[len];
        for(int i = 0; i < len; i++){
            ret[i] = arr1[i] * arr2[i];
        }
        return ret;
    }

    //测试函数
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4};
        ProductArrayExceptSelf sol = new ProductArrayExceptSelf();
        int[] ret = sol.productExceptSelf(nums);
        System.out.println(Arrays.toString(ret));
    }
}
