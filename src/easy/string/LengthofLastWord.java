package easy.string;
/**
 * Given a string s consists of upper/lower-case 
 * alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * @author wenhanglei
 */
public class LengthofLastWord {
	/*
	 * 思路：
	 */
	public int lengthOfLastWord(String s) {
		//边界检查
		if(s == null || s.trim().isEmpty()) return 0;
		char[] arr = s.toCharArray();
		int i = arr.length-1;
		while(arr[i] == ' ')
			i--;
		int j = i;
		for(; i >= 0; i--){
			if(arr[i] == ' ') break;
		}
        return j-i;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String str = "Hello World 1";
		LengthofLastWord sol = new LengthofLastWord();
		int res = sol.lengthOfLastWord(str);
		System.out.println(res);
	}
}
