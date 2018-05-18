package easy.bit_manipulation;
/**
 * Given an integer (signed 32 bits), write a function 
 * to check whether it is a power of 4.
 * @author wenhanglei
 */
public class PowerOfFour {
	/*
	 * 思路：
	 * 一个数和它本身减1的数相与为0则为偶数，如果为1的位出现在奇数位上则不符合要求
	 */
	public boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num-1)) == 0 && (num & 0x55555555) != 0);
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(4));
		System.out.println(Integer.toBinaryString(16));
		System.out.println(Integer.toBinaryString(64));
	}
}
