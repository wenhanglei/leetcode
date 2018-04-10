package easy.math;
/**
 * Given a positive integer, return its corresponding 
 * column title as appear in an Excel sheet.
 * @author wenhanglei
 */
public class ExcelSheetColumnTitle {
	/*
	 * 思路：
	 */
	public String convertToTitle(int n) {
		//边界检查
		if(n <= 0) return null;
		StringBuilder sb = new StringBuilder();
		while(n != 0){
			int pre = n/26;
			int rem = n%26;
			if(rem == 0){
				sb.append("Z");
				pre--;
			}else
				sb.append(toAlpha(rem));
			n = pre;
		}
		sb.reverse();
		return sb.toString();
    }
	
	private String toAlpha(int i){
		return (char)(i+64)+"";
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ExcelSheetColumnTitle sol = new ExcelSheetColumnTitle();
		String res = sol.convertToTitle(79);
		System.out.println(res);
	}
}
