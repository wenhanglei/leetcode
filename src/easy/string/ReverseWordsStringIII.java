package easy.string;

/**
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * @author wenhanglei
 */
public class ReverseWordsStringIII {
	/*
	 * 思路：
	 */
	public String reverseWords(String s) {
		int chNum = 0;                     //字符个数
		char[] chs = s.toCharArray();
		for(int i = 0; i < chs.length; i++){
			if(chs[i] == ' '){
				swap(chs, i, chNum);
				chNum = 0;
			}else chNum++;
		}
		swap(chs, chs.length, chNum);
		return new String(chs);
	}
	
	/**
	 * 反转指定上下限的字符串
	 */
	private void swap(char[] str, int index, int chNum){
		int hi = index-1, lo = index-chNum;
		while(lo < hi){
			char temp = str[lo];
			str[lo++] = str[hi];
			str[hi--] = temp;
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ReverseWordsStringIII sol = new ReverseWordsStringIII();
		String ret = sol.reverseWords("Let's take LeetCode contest");
		System.out.println(ret);
	}
}
