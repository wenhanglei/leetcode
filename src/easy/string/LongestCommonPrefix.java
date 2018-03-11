package easy.string;
/**
 * Write a function to find the longest 
 * common prefix string amongst an array of strings.
 * @author wenhanglei
 */
public class LongestCommonPrefix {
	/*
	 * 思路：
	 * 简单的循环检查
	 */
	public String longestCommonPrefix(String[] strs) {
		StringBuilder res = new StringBuilder();
		if(strs == null || strs.length == 0) return res.toString();
		int num = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
        	num = Math.min(strs[i].length(), num);
        }
        for(int i = 0; i < num; i++){
        	char ch = strs[0].charAt(i);
        	for(int j = 1; j < strs.length; j++){
        		if(ch != strs[j].charAt(i)){
        			return res.toString();
        		}
        	}
        	res.append(ch);
        }
        return res.toString();
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String[] strings = new String[4];
		strings[0] = "I am a tiger.";
		strings[1] = "I am your father.";
		strings[2] = "I am your mother.";
		strings[3] = "I am a rabbish.";
		
		LongestCommonPrefix sol = new LongestCommonPrefix();
		String pre = sol.longestCommonPrefix(strings);
		System.out.println(pre);
	}
}
