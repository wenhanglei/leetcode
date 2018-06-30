package easy.other;
/**
 * Find the largest palindrome made from 
 * the product of two n-digit numbers.
 * @author wenhanglei
 */
public class LargestPalindromeProduct {
	/*
	 * 思路：
	 */
	public int largestPalindrome(int n) {
		//边界判断
		if(n == 1)
			return 9;
		 //确定上下界
		int upBound = (int) (Math.pow(10, n)-1);
		int subBound = (int) ((Math.pow(10, n)-1)/10);
		//最大值
		
        return 0;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LargestPalindromeProduct sol = new LargestPalindromeProduct();
		int ret = sol.largestPalindrome(3);
		System.out.println(ret);
	}
}
