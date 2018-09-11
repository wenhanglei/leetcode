package easy.string;

import java.util.HashSet;

/**
 * International Morse Code defines a standard encoding where each letter is
 * mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps
 * to "-...", "c" maps to "-.-.", and so on.
 * 
 * @author wenhanglei
 */
public class UniqueMorseCodeWords {
	/*
	 * 思路：使用set去重
	 */
	public int uniqueMorseRepresentations(String[] words) {
		//边界检查
		if(words == null) return 0;
		String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
				"....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
				"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
				"-.--", "--.." };
		HashSet<String> set = new HashSet<>();
		for (String str : words) {
			StringBuilder sb = new StringBuilder();
			for(char ch : str.toCharArray()){
				sb.append(morseCode[ch-'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		UniqueMorseCodeWords sol = new UniqueMorseCodeWords();
		int ret = sol.uniqueMorseRepresentations(new String[]{
				"gin", "zen", "gig", "msg"
		});
		System.out.println(ret);
	}
}
