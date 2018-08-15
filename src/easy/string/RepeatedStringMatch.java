package easy.string;

/**
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * @author wenhanglei
 */
public class RepeatedStringMatch {
	/*
	 * 思路：
	 */
	public int repeatedStringMatch(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		int times = lenB%lenA==0?lenB/lenA:lenB/lenA+1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < times; i++){
			sb.append(A);
		}
		if(sb.toString().contains(B)) return times;
		if(sb.append(A).toString().contains(B)) return times+1;
		return -1;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		RepeatedStringMatch sol = new RepeatedStringMatch();
		int ret = sol.repeatedStringMatch("a", "aa");
		System.out.println(ret);
	}
}
