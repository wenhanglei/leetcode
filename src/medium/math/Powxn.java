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
		double ret = x;
		boolean flag = true;
		if(n < 0) {
			flag = false;
			n = -n;
		}
		for(int i = 1; i < n; i++){
			ret *= x;
		}
		return flag?ret:1/ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Powxn sol = new Powxn();
		double ret = sol.myPow(2, -2);
		System.out.println(ret);
	}
}
