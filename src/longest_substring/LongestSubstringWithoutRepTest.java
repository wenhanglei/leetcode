package longest_substring;

import org.junit.Test;

public class LongestSubstringWithoutRepTest {
	@Test
	public void TestLongestSubstringWithoutRep(){
		String str1 = "abcabcbb";
		String str2 = "bbbbbbbbbbbb";
		String str3 = "pwwkew";
		
		LongestSubstringWithoutRep sol = new LongestSubstringWithoutRep();
		int length = sol.lengthOfLongestSubstring(str3);
		System.out.println(length);
		
	}
}
