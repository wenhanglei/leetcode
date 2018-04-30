package easy.bit_manipulation;
/**
 * Given an integer, write a function to determine if it is a power of two.
 * @author wenhanglei
 */
public class PowerOfTwo {
	/*
	 * 思路：
	 */
	public boolean isPowerOfTwo(int n) {
		if(n < 0) return false;
		int count = 0;
		while(n != 0){
			count += (n&1);
			n >>>= 1;
		}
        if(count == 1) return true;
        else return false;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PowerOfTwo sol = new PowerOfTwo();
		boolean res = sol.isPowerOfTwo(7);
		System.out.println(res);
	}
}
