package easy.math;
/**
 * Given an integer, write a function to determine if it is a power of three.
 * @author wenhanglei
 */
public class PowerOfThree {
	/*
	 * 思路：
	 */
	public boolean isPowerOfThree(int n) {
		return n>0 && 1162261467 % n == 0;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
//		int count = 1;
//		long i = 3;
//		while(i < Integer.MAX_VALUE){
//			count++;
//			i *= 3;
//		}
//		System.out.println((int)Math.pow(3, 19));
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(count);
//		System.out.println(i);
		PowerOfThree sol = new PowerOfThree();
		boolean ret = sol.isPowerOfThree(27);
		System.out.println(ret);
	}
}
