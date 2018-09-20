package easy.string;


/**
 * A sentence S is given, composed of words separated by spaces. Each word
 * consists of lowercase and uppercase letters only.
 * 
 * We would like to convert the sentence to "Goat Latin" (a made-up language
 * similar to Pig Latin.)
 * 
 * @author wenhanglei
 */
public class GoatLatin {
	/*
	 * 思路：简单的遍历即可
	 */
	public String toGoatLatin(String S) {
		StringBuilder sb = new StringBuilder();
		String suffix = "a";
		for(String word : S.split(" ")){
			transformWord(word, sb, suffix);
			suffix += "a";
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	private void transformWord(String word, StringBuilder sb, String suffix){
		if(!"aeiouAEIOU".contains(word.charAt(0)+"")){
			for(int i = 1; i < word.length(); i++){
				sb.append(word.charAt(i));
			}
			sb.append(word.charAt(0));
		}else sb.append(word);
		sb.append("ma" + suffix + " ");
	}
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "The quick brown fox jumped over the lazy dog";
		GoatLatin sol = new GoatLatin();
		String ret = sol.toGoatLatin(str);
		System.out.println(ret);
	}
}
