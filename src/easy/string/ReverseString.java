package easy.string;
/**
 * Write a function that takes a string as input 
 * and returns the string reversed.
 * @author wenhanglei
 */
public class ReverseString {
	/*
	 * 思路：
	 */
	public String reverseString(String s) {
		//边界检查
		if(s == null) return null;
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
	
//	public String reverseString(String s) {
//		//边界检查
//		if(s == null) return null;
//		char[] ca = s.toCharArray();
//		StringBuilder sb = new StringBuilder();
//		for(int i = ca.length-1; i >= 0; i--){
//			sb.append(ca[i]);
//		}
//		return sb.toString();
//	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ReverseString sol = new ReverseString();
		String ret = sol.reverseString("hello");
		System.out.println(ret);
	}
}
