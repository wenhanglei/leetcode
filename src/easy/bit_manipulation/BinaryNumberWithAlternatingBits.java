package easy.bit_manipulation;


/**
 * Given a positive integer, check whether it has alternating bits: namely, if
 * two adjacent bits will always have different values.
 * 
 * @author wenhanglei
 */
public class BinaryNumberWithAlternatingBits {
	/*
	 * 思路：先向左移动两位再与原数异或判断该数字是否能被2除尽即可
	 */
	public boolean hasAlternatingBits(int n) {
		int i = Integer.highestOneBit(n)<<1;
		return (i-n-1) == (n>>1);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		BinaryNumberWithAlternatingBits sol = new BinaryNumberWithAlternatingBits();
		boolean ret = sol.hasAlternatingBits(10);
		System.out.println(ret);
		
	}
}
