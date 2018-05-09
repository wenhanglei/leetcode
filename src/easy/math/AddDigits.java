package easy.math;
/**
 * Given a non-negative integer num, repeatedly add all 
 * its digits until the result has only one digit.
 * @author wenhanglei
 */
public class AddDigits {
	/*
	 * 思路：
	 * 根据公式可求
	 */
	public int addDigits(int num) {
        if(num == 0) return 0;
        if(num % 9 == 0) return 9;
        else return num % 9;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
