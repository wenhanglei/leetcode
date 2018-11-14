package medium.math;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * 
 * @author wenhanglei
 */
public class Powxn {
	/*
	 * 思路：遍历即可
	 */
	public double myPow(double x, int n) {
		//边界检查
		if(n == 0) return 1;
		if(n < 0){
			x = 1/x;
			n = -n;
		}
		return n%2==0?myPow(x*x, n>>>1):x*myPow(x*x, n>>>1);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Powxn sol = new Powxn();
		double ret = sol.myPow(2, -2147483648);
		System.out.println(ret);
	}
}
