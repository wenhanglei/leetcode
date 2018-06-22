package easy.bit_manipulation;
/**
 * The Hamming distance between two integers is the 
 * number of positions at which the corresponding bits 
 * are different.
 * @author wenhanglei
 */
public class HammingDistance {
	/*
	 * 思路：
	 */
	public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		HammingDistance sol = new HammingDistance();
		int ret = sol.hammingDistance(1, 4);
		System.out.println(ret);
	}
}
