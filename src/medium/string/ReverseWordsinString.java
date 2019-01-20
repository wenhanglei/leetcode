package medium.string;

/**
 * Given an input string, reverse the string word by word.
 * 
 * @author wenhanglei
 */
public class ReverseWordsinString {
	/*
	 * 思路：先将整个字符串翻转，再逐个翻转每一个单词
	 */
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder(s.trim());
		sb.reverse();
		String[] strs = sb.toString().split(" ");
		StringBuilder sb1 = new StringBuilder();
		for (String st : strs) {
			if(!st.equals("")) sb1.append(new StringBuilder(st).reverse() + " ");
		}
		return sb1.toString().trim();
	}
	
	private void reverse(StringBuilder sb, int i, int j){
		while(i < j){
			char temp = sb.charAt(i);
			sb.setCharAt(i++, sb.charAt(j));
			sb.setCharAt(j--, temp);
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String s = "    a     b ";
		ReverseWordsinString sol = new ReverseWordsinString();
		String ret = sol.reverseWords(s);
		System.out.println(ret);
	}
}
