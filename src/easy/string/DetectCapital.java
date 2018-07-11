package easy.string;

import java.util.regex.Pattern;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * @author wenhanglei
 */
public class DetectCapital {
	/*
	 * 思路：
	 * 最好的办法是正则表达式
	 */
	public boolean detectCapitalUse(String word) {
		boolean ret = Pattern.matches("^[A-Z]+|^[A-Z][a-z]*|^[a-z]+", word);
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		DetectCapital sol = new DetectCapital();
		boolean ret = sol.detectCapitalUse("AabD");
		System.out.println(ret);
	}
}
