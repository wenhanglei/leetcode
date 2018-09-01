package easy.binary_search;

import java.util.TreeSet;

/**
 * 
 * Given a list of sorted characters letters containing only lowercase letters,
 * and given a target letter target, find the smallest element in the list that
 * is larger than the given target.
 * 
 * Letters also wrap around. For example, if the target is target = 'z' and
 * letters = ['a', 'b'], the answer is 'a'.
 * 
 * @author wenhanglei
 */
public class FindSmallestLetterGreaterThanTarget {
	/*
	 * 思路:
	 */
	public char nextGreatestLetter(char[] letters, char target) {
		TreeSet<Character> set = new TreeSet<>();
		for(int i = 0; i < letters.length; i++){
			set.add(letters[i]);
		}
		if(target >= set.last()) return set.first();
		return set.higher(target);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		FindSmallestLetterGreaterThanTarget sol = new FindSmallestLetterGreaterThanTarget();
		char[] letters = {'c', 'f', 'j'};
		char ret = sol.nextGreatestLetter(letters, 'k');
		System.out.println(ret);
	}
}
