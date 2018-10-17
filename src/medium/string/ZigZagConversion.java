package medium.string;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * @author wenhanglei
 */
public class ZigZagConversion {
	/*
	 * 思路：简单朴素地排列即可
	 */
	public String convert(String s, int numRows) {
		//边界检查
		if(numRows == 1) return s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for(int i = 0; i < numRows; i++){
			sb[i] = new StringBuilder();
		}
		int direct = -1;                 //字符添加方向
		for(int i = 0, index = 0; i < s.length(); i++){
			if(index == numRows-1 || index == 0) direct = -direct;
			sb[index].append(s.charAt(i));
			index = index+direct;
		}
		String ret = "";
		for(StringBuilder b : sb) ret += b.toString();
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ZigZagConversion sol = new ZigZagConversion();
		String ret = sol.convert("ABCD", 2);
		System.out.println(ret);
	}
}
