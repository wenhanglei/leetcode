package easy.string;

/**
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X. Each digit must be rotated -
 * we cannot choose to leave it alone.
 * 
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8
 * rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each
 * other, and the rest of the numbers do not rotate to any other number and
 * become invalid.
 * 
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * 
 * @author wenhanglei
 */
public class RotatedDigits {

	/*
	 * 思路：遍历即可
	 */
	public int rotatedDigits(int N) {
		int cnt = 0;
		for(int i = 1; i <= N; i++){
			if(isGood(i)) cnt++;
		}
		return cnt;
	}
	
	private boolean isGood(int i){
		String str = Integer.toString(i);
		if(!str.matches("[0125689]*")) return false;
		if(str.matches("[018]*")) return false;
		return true;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		RotatedDigits sol = new RotatedDigits();
		int ret = sol.rotatedDigits(10);
		System.out.println(ret);
	}

}
