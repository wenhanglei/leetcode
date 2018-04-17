package easy.bit_manipulation;
/**
 * Reverse bits of a given 32 bits unsigned integer.
 * @author wenhanglei
 */
public class ReverseBits {
	/*
	 * 思路：
	 * 位无符号左移操作
	 */
	public int reverseBits(int n) {
		int res = 0;
		for(int i = 0; i < 32; i++){
			res <<= 1;
			res += n & 1;
			n >>>= 1;
		}
        return res;
    }
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseBits sol = new ReverseBits();
		int res = sol.reverseBits(43261596);
		System.out.println(res);
	}
}
