package easy.math;
/**
 * Determine whether an integer is a palindrome（回文）. 
 * Do this without extra space.
 * @author wenhanglei
 */
public class PalindromeNumber {
	/*
	 * 思路：
	 * 
	 */
	public boolean isPalindrome(int x) {
		//排除负数和10的整数
		if(x < 0 || (x > 0 && x%10 == 0)) return false;
		int res = 0;
		//将输入数字反向
		while(x > res){
			res = res*10 + (x%10);
			x /= 10;
		}
        return (res == x || x == res/10);
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int a = 12321;
		PalindromeNumber sol = new PalindromeNumber();
		boolean p = sol.isPalindrome(a);
		System.out.println(p);
		
	}
}
