package easy.string;

import java.util.Arrays;

import javax.print.attribute.IntegerSyntax;

/**
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than 
 * or equal to the original array.
 * @author wenhanglei
 */
public class StringCompression {
	/*
	 * 思路：
	 */
	public int compress(char[] chars) {
        //边界检查
		if(chars.length == 1) return 1;
		int count = 1;          //重复字符次数统计
		int curr = 0;           //当前的比对字符的下标
		int next = 1;           //下一个需要比对的字符下标
		
		while(next <= chars.length){
			if(next != chars.length && chars[next] != chars[curr]){
				if(count != 1)
					for(char c : Integer.toString(count).toCharArray()){
						chars[++curr] = c;
					}
				chars[++curr] = chars[next++];
				count = 1;
			}else {
				count++;
				next++;
			}
			if(next == chars.length)
				if(count != 1)
					for(char c : Integer.toString(count).toCharArray()){
						chars[++curr] = c;
					}
		}
		return curr+1;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		StringCompression sol = new StringCompression();
		char[] arr = {'a','b','c'};
		int ret = sol.compress(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(ret);
	}
}
