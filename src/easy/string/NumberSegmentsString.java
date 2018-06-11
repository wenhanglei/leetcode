package easy.string;
/**
 * Count the number of segments in a string, 
 * where a segment is defined to be a contiguous 
 * sequence of non-space characters.
 * @author wenhanglei
 */
public class NumberSegmentsString {
	/*
	 * 思路：
	 * 遍历
	 */
	public int countSegments(String s) {
		if(s == null || s.isEmpty()) return 0;
        int ret =  s.split(" +").length;
        if(s.startsWith(" ") && !s.trim().equals(""))
        	ret--;
        return ret;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		NumberSegmentsString sol = new NumberSegmentsString();
		int ret = sol.countSegments(", , , ,        a, eaefa");
		System.out.println(ret);
	}
}
