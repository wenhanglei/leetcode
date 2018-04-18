package easy.bit_manipulation;
/**
 * Reverse bits of a given 32 bits unsigned integer.
 * @author wenhanglei
 */
public class ReverseBits {
	/*
	 * 思路：
	 * 位无符号左移操作
	 * 二进制位翻转
	 */
	public int reverseBits(int n) {
		int res=n;
        res = res >>> 16 | res<<16;
        res = (res & 0xff00ff00) >>> 8 | (res & 0x00ff00ff) << 8;
        res = (res & 0xf0f0f0f0) >>> 4 | (res & 0x0f0f0f0f) << 4;
        res = (res & 0xcccccccc) >>> 2 | (res & 0x33333333) << 2;
        res = (res & 0xaaaaaaaa) >>> 1 | (res & 0x55555555) << 1;
        return res;
    }
//	public int reverseBits(int n) {
//		int res = 0;
//		for(int i = 0; i < 32; i++){
//			res <<= 1;
//			res += n & 1;
//			n >>>= 1;
//		}
//		return res;
//	}
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseBits sol = new ReverseBits();
		int res = sol.reverseBits(0b11010101);
		System.out.println(Integer.toBinaryString(res));
	}
}
