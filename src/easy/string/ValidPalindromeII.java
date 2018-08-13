package easy.string;

/**
 * Given a non-empty string s, you may delete at most one character. Judge
 * whether you can make it a palindrome.
 * 
 * @author wenhanglei
 */
public class ValidPalindromeII {
	/*
	 * 思路：双指针
	 */
	public boolean validPalindrome(String s) {
		// 边界检查
		if (s == null) return false;
		char[] array = s.toCharArray();
		int begin = 0, end = array.length - 1;
		while (begin < end)
			if (array[begin] != array[end]) break;
			else {
				begin++;
				end--;
			}
		if(isPalindrome(array, begin+1, end) || isPalindrome(array, begin, end-1))
			return true;
		return false;
	}
	
	private boolean isPalindrome(char[] arr, int i, int j){
		if(i >= j) return true;
		while(i < j)
			if(arr[i++] != arr[j--]) return false;
		return true;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ValidPalindromeII sol = new ValidPalindromeII();
		String s1 = "a";
		String s2 = "ab";
		String s3 = "aba";
		String s4 = "abca";
		String s5 = "acab";
		String s6 = "abc";
		String s7 = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
		boolean ret = sol.validPalindrome(s7);
		System.out.println(ret);
	}
}
