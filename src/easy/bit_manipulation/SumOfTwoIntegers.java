package easy.bit_manipulation;
/**
 * Calculate the sum of two integers a and b, but 
 * you are not allowed to use the operator + and -.
 * @author wenhanglei
 */
public class SumOfTwoIntegers {
	/*
	 * 思路：
	 * 位操作
	 * 异或保留不同的位
	 */
	public int getSum(int a, int b) {
		if(b == 0) return a;
        int c = a^b;           //不考虑进位的结果
        int d = (a&b)<<1;      //进位后需要添加的值
        return getSum(c, d);
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
