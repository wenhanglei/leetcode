package medium.string;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * @author wenhanglei
 */
public class Integer2Roman {
	/*
	 * 思路：使用treemap保存对应的数值和罗马字符
	 */
	public String intToRoman(int num) {
		int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		String[] romes = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		StringBuilder sb = new StringBuilder();
		int ceiling = nums.length;
		while(num > 0){
			int i = ceiling;
			while(num < nums[--i]);
			sb.append(romes[i]);
			num -= nums[i];
			ceiling = i+1;
		}
		return sb.toString();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Integer2Roman sol = new Integer2Roman();
		String ret = sol.intToRoman(1994);
		System.out.println(ret);
	}
}
