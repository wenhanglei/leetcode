package medium.other;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * @author wenhanglei
 */
public class BitwiseANDOfNumbersRange {
	/*
	 * 思路：逐个相与即可
	 */
	public int rangeBitwiseAnd(int m, int n) {
		int ret = m++;
		for(int i = m; i <= n; i++){
			ret &= i;
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		BitwiseANDOfNumbersRange sol = new BitwiseANDOfNumbersRange();
		int ret = sol.rangeBitwiseAnd(5, 7);
		System.out.println(ret);
	}
}
