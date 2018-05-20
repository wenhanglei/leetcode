package easy.string;
/**
 * Write a function that takes a string as input 
 * and reverse only the vowels of a string.
 * @author wenhanglei
 */
public class ReverseVowelsOfAString {
	/*
	 * 思路：
	 */
	public String reverseVowels(String s) {
		//边界检查
		if(s == null) return null;
		char[] ca = s.toCharArray();
		int lo = 0, hi = ca.length-1;
		while(lo <= hi){
			if(isVowel(ca[lo]) && isVowel(ca[hi])){
				swap(ca, lo, hi);
				lo++;
				hi--;
			}else if(!isVowel(ca[lo])) lo++;
			else if(!isVowel(ca[hi])) hi--;
		}
        return new String(ca);
    }
	
	private void swap(char[] ca, int i, int j){
		char temp = ca[i];
		ca[i] = ca[j];
		ca[j] = temp;
	}
	
	private boolean isVowel(char c){
		return "aeiouAEIOU".contains(c+"");
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ReverseVowelsOfAString sol = new ReverseVowelsOfAString();
		String ret = sol.reverseVowels("hello");
		System.out.println(ret);
	}
}
