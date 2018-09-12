package easy.other;

import java.util.Arrays;

/**
 * We are to write the letters of a given string S, from left to right into
 * lines. Each line has maximum width 100 units, and if writing a letter would
 * cause the width of the line to exceed 100 units, it is written on the next
 * line. We are given an array widths, an array where widths[0] is the width of
 * 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 * 
 * Now answer two questions: how many lines have at least one character from S,
 * and what is the width used by the last such line? Return your answer as an
 * integer list of length 2.
 * 
 * @author wenhanglei
 */
public class NumberOfLinesToWriteString {

	/*
	 * 思路：遍历即可
	 */
	public int[] numberOfLines(int[] widths, String S) {
        int[] ret = {1, 0};
        for(int i = 0; i < S.length(); i++){
        	int width = widths[S.charAt(i)-'a'];
        	if(ret[1] > 100-width){
        		ret[1] = width;
        		ret[0]++;
        	}else ret[1] += width;
        }
        return ret;
    }
	
	public static void main(String[] args) {
		NumberOfLinesToWriteString sol = new NumberOfLinesToWriteString();
		int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		int[] ret = sol.numberOfLines(widths, "bbbcccdddaaa");
		System.out.println(Arrays.toString(ret));
	}
}
