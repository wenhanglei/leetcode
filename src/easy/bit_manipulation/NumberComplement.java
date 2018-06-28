package easy.bit_manipulation;
/**
 * Given a positive integer, output its complement number. 
 * The complement strategy is to flip the bits of its binary 
 * representation.
 * @author wenhanglei
 */
public class NumberComplement {
	/*
	 * 思路：
	 * 先对数字移位再按位取反
	 */
	public int findComplement(int num) {
        //检查边界
		if(num < 0) return -1;
		int step = Integer.numberOfLeadingZeros(num);
		num <<= step;
		num = ~num;
		return num >> step;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		NumberComplement sol = new NumberComplement();
		int ret = sol.findComplement(1);
		System.out.println(ret);
	}
}
