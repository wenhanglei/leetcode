package medium.other;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA. Write a function to find all the
 * 10-letter-long sequences (substrings) that occur more than once in a DNA
 * molecule.
 * 
 * @author wenhanglei
 */
public class RepeatedDNASequences {
	/*
	 * 思路：使用hashset来检查重复的子串
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		HashSet<String> seenSoFar = new HashSet<>();
		HashSet<String> repeated = new HashSet<>();
		for(int i = 0; i + 9 < s.length(); i++){
			String str = s.substring(i, i+10);
			if(!seenSoFar.add(str))
				repeated.add(str);
		}
		return new LinkedList<String>(repeated);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		RepeatedDNASequences sol = new RepeatedDNASequences();
		List<String> ret = sol.findRepeatedDnaSequences(s);
		System.out.println(ret);
	}
}
