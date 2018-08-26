package easy.string;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns
 * the same string in lowercase.
 * 
 * @author wenhanglei
 */
public class ToLowerCase {
	/*
	 * 思路：
	 */
	public String toLowerCase(String str) {
		StringBuilder sb = new StringBuilder();
		for (char ch : str.toCharArray()) {
			if(ch >= 65 && ch <= 90) ch = (char) (ch+32);
			sb.append(ch);
		}
		return sb.toString();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ToLowerCase sol = new ToLowerCase();
		String ret = sol.toLowerCase("FAMILY");
		System.out.println(ret);
	}
}
