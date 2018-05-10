package easy.math;
/**
 * Write a program to check whether a given number is an ugly number.
 * @author wenhanglei
 */
public class UglyNumber {
	/*
	 * 思路：
	 * 动态规划
	 */
	public boolean isUgly(int num) {
		if(num == 1) return true;
		if(num <= 0) return false;
		else if(num%2 == 0){
			if(isUgly(num/2)) return true;
		}else if(num%3 == 0){
			if(isUgly(num/3)) return true;
		}else if(num%5 == 0){
			if(isUgly(num/5)) return true;
		}return false;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		UglyNumber sol = new UglyNumber();
		boolean res = sol.isUgly(7);
		System.out.println(res);
	}
}
