package easy.math;

/**
 * We define the Perfect Number is a positive integer that is equal to the sum
 * of all its positive divisors except itself. Now, given an integer n, write a
 * function that returns true when it is a perfect number and false when it is
 * not.
 * 
 * @author wenhanglei
 */
public class PerfectNumber {
	/*
	 * 思路：
	 */
	public boolean checkPerfectNumber(int num) {
		//边界检查
		if(num == 1) return false;
		int sum = 1;
		for(int i = 2; i < num/i; i++){
			int j = num/i;
			if(i*j == num){
				sum += i+j;
			}
		}
		return sum == num;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PerfectNumber sol = new PerfectNumber();
		boolean ret = sol.checkPerfectNumber(28);
		System.out.println(ret);
	}
}
