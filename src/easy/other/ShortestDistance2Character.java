package easy.other;

import java.util.Arrays;

/**
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 * 
 * @author wenhanglei
 */
public class ShortestDistance2Character {
	/*
	 * 思路：统计出现间隔即可
	 */
	public int[] shortestToChar(String S, char C) {
		int[] ret = new int[S.length()];
		int preIdx = -1;               //前一个指定字符的下标
		for(int i = 0; i < S.length(); i++){
			if(S.charAt(i) == C){
				setValue(ret, preIdx, i);
				preIdx = i;
			}
		}
		setValue(ret, preIdx, ret.length);
		return ret;
	}
	
	private void setValue(int[] arr, int preIdx, int currIdx){
		int cnt = 1;
		if(preIdx == -1){
			for(int i = currIdx-1; i >= 0; i--){
				arr[i] = cnt++;
			}
		}else if(currIdx == arr.length){
			for(int i = preIdx+1; i < currIdx; i++){
				arr[i] = cnt++;
			}
		}else{
			while(preIdx < currIdx-1){
				arr[++preIdx] = cnt;
				arr[--currIdx] = cnt++;
			}
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ShortestDistance2Character sol = new ShortestDistance2Character();
		int[] arr = sol.shortestToChar("loveleetcode", 'e');
		System.out.println(Arrays.toString(arr));
	}
}
