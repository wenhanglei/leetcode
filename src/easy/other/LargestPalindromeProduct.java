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
		long maxNum = (long)upBound * (long)upBound;
		//构成回文数字的前半部分
		int firstHalf = (int) (maxNum/(long)Math.pow(10, n));
		//结果标志
		boolean hasPalindrome = false;
		//结果数字
		long palindrome = 0;
		
		while(!hasPalindrome){
			palindrome = createPalindrome(firstHalf);
			
			for(long i = upBound; i > subBound; i--){
				if(palindrome > maxNum || i*i<palindrome)
					break;
				if(palindrome%i == 0){
					hasPalindrome = true;
					break;
				}
			}
			firstHalf--;
		}
		
        return (int) (palindrome%1337);
    }
	
	private long createPalindrome(long num){
		String str = num + new StringBuilder().append(num).reverse().toString();
		return Long.parseLong(str);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LargestPalindromeProduct sol = new LargestPalindromeProduct();
		int ret = sol.largestPalindrome(2);
		System.out.println(ret);
	}
}
