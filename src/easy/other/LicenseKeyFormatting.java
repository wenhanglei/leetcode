package easy.other;
/**
 * You are given a license key represented as a string S which 
 * consists only alphanumeric character and dashes. The string is 
 * separated into N+1 groups by N dashes.
 * @author wenhanglei
 */
public class LicenseKeyFormatting {
	/*
	 * 思路：
	 * 从后向前遍历
	 */
	public String licenseKeyFormatting(String S, int K) {
		//边界判断
		if(S == null || K == 0) return null;
		int len = S.length();
		int count = K;
		StringBuilder sb = new StringBuilder();
		for(int i = len-1; i >= 0; i--){
			char ch = S.charAt(i);
			if(ch =='-') continue;
			sb.append(Character.toUpperCase(ch));
			count--;
			if(count == 0) {
				sb.append('-');
				count = K;
			}
		}
		if(sb.length()!=0 && sb.charAt(sb.length()-1) == '-') sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LicenseKeyFormatting sol = new LicenseKeyFormatting();
		String ret = sol.licenseKeyFormatting("---", 3);
		System.out.println(ret);
	}
}
