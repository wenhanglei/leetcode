package easy.math;
/**
 * Given a column title as appear in an Excel sheet, 
 * return its corresponding column number.
 * @author wenhanglei
 */
public class ExcelSheetColumnNumber {
	/*
	 * 思路：
	 * 
	 */
	public int titleToNumber(String s) {
		//边界检查
		if(s == null || s.length() == 0) return 0;
		char[] cs = s.toCharArray();
		int res = 0;
		for(int i = 0; i < cs.length; i++){
			res = (cs[i]-64) + res*26;
		}
        return res;
    }
	
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		ExcelSheetColumnNumber sol = new ExcelSheetColumnNumber();
		int res = sol.titleToNumber("AB");
		System.out.println(res);
	}
}
