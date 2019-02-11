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
		//边界检查
		if(m == 0) return 0;
		
		int count = 0;
		while(m != n){
			m >>= 1;
			n >>= 1;
			count++;
		}
		return m << count;
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
