package easy.hashtable;
/**
 * Write an algorithm to determine if a number is "happy".
 * @author wenhanglei
 */
public class HappyNumber {
	/*
	 * 思路：
	 */
	public boolean isHappy(int n) {
		if(n < 10){
			if(n == 1 || n == 7) return true;
			else return false;
		}
		int squareSum = 0;
		int remain = 0;
		while(n != 0){
			remain = n % 10;
			squareSum += remain * remain;
			n /= 10;
		}
		if(squareSum == 1) return true;
		else return isHappy(squareSum);
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		HappyNumber sol = new HappyNumber();
		boolean res = sol.isHappy(19);
		System.out.println(res);
	}
}
