package medium.bit_manipulation;

import java.util.Arrays;

/**
 * @author: wenhanglei
 * @date: 2019/6/19
 * @time: 11:02
 * @info: Given an array of numbers nums, in which exactly two elements appear only once and all the
 * other elements appear exactly twice. Find the two elements that appear only once.
 */
public class SingleNumberIII {

  //思路：
  //先找到两个不同数的异或的结果
  //在根据结果中为1的位将数组分成两个组，各组的异或结果分别为两个结果值
  public int[] singleNumber(int[] nums) {
    //边界检查
    if (nums == null || nums.length == 0) {
      return null;
    }

    int xor = nums[0];
    for (int i = 1; i < nums.length; i++) {
      xor ^= nums[i];
    }

    //找到xor中为1的最低位
    xor = xor & (-xor);
    int[] ret = new int[2];
    for (int i = 0; i < nums.length; i++) {
      if ((nums[i] & xor) == 0) {
        ret[0] ^= nums[i];
      } else {
        ret[1] ^= nums[i];
      }
    }

    return ret;
  }


  //测试函数
  public static void main(String[] args) {
    SingleNumberIII sol = new SingleNumberIII();
    int[] nums = {1, 2, 1, 3, 2, 5};

    int[] ret = sol.singleNumber(nums);
    System.out.println(Arrays.toString(ret));
  }

}
