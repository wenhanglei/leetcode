package easy.math;

import java.util.Arrays;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Given a non-negative integer represented as a non-empty 
 * array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading 
 * zero, except the number 0 itself.
 * The digits are stored such that the most significant 
 * digit is at the head of the list.
 * @author wenhanglei
 */
public class PlusOne {
	/*
	 * 思路：
	 * 加法器
	 */
	public int[] plusOne(int[] digits) {
		int s = 1;
		for(int i = digits.length-1; i >= 0; i--){
			int temp = (digits[i]+s)%10;
			s = (digits[i]+s)/10;
			digits[i] = temp;
		}
		if(s == 1){
			int[] arr = new int[digits.length+1];
			arr[0] = 1;
			for(int i = 0; i < digits.length; i++){
				arr[i+1] = digits[i];
			}
			return arr;
		}
        return digits;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {9};
		PlusOne sol = new PlusOne();
		int[] res = sol.plusOne(arr);
		System.out.println(Arrays.toString(res));
	}
}
