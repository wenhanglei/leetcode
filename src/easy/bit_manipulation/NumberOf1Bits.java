package easy.bit_manipulation;
/**
 * Write a function that takes an unsigned integer 
 * and returns the number of ’1' bits it has (also 
 * known as the Hamming weight).
 * @author wenhanglei
 */
public class NumberOf1Bits {
	/*
	 * 思路：
	 */
	public int hammingWeight(int n) {
		int res = 0;
		while(n != 0){
			if((n & 1) == 1) res++;
			n >>>= 1;
		}
        return res;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		NumberOf1Bits sol = new NumberOf1Bits();
		int res = sol.hammingWeight(11);
		System.out.println(res);
	}
}
