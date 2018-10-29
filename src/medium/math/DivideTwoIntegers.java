package medium.math;

/**
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * @author wenhanglei
 */
public class DivideTwoIntegers {
	/*
	 * 思路：不使用除法、乘法、求模运算做整数的除法
	 */
	public int divide(int dividend, int divisor) {
		int sign = 1;
		if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			sign = -1;
		long ldividend = Math.abs((long)dividend);
		long ldivisor = Math.abs((long)divisor);
		if(divisor == 0) return Integer.MIN_VALUE;
		if(ldividend == 0 || ldividend < divisor) return 0;
		long lans = ldivide(ldividend, ldivisor);
		if(lans > Integer.MAX_VALUE) {
			return (sign > 0)?Integer.MAX_VALUE:Integer.MIN_VALUE;
		}else{
			return sign * (int)lans;
		}
	}
	
	private long ldivide(long ldividend, long ldivisor){
		//判断被除数是否小于除数作为递归的结束条件
		if(ldividend < ldivisor) return 0;
		//不断对除数乘2找到最接近的点
		long sum = ldivisor;
		int multiple = 1;
		while((sum+sum) < ldividend){
			sum += sum;
			multiple += multiple;
		}
		return multiple + ldivide(ldividend-sum, ldivisor);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		DivideTwoIntegers sol = new DivideTwoIntegers();
		int ret = sol.divide(7, -3);
		System.out.println(ret);
	}
}
