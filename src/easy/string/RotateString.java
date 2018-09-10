package easy.string;

/**
 * We are given two strings, A and B.
 * 
 * A shift on A consists of taking string A and moving the leftmost character to
 * the rightmost position. For example, if A = 'abcde', then it will be 'bcdea'
 * after one shift on A. Return True if and only if A can become B after some
 * number of shifts on A.
 * 
 * @author wenhanglei
 */
public class RotateString {
	/*
	 * 思路：
	 */
	public boolean rotateString(String A, String B) {
		//边界检查
		if(A.length() != B.length()) return false;
		String str = A+A;
		return str.contains(B);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		RotateString sol = new RotateString();
		boolean ret = sol.rotateString("abcde", "abced");
		System.out.println(ret);
	}
}
