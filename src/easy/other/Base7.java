package easy.other;


/**
 * Given an integer, return its base 7 string representation.
 * 
 * @author wenhanglei
 */
public class Base7 {
	/*
	 * 思路：
	 * 方案一：使用现成的jdk方法
	 */
//	public String convertToBase7(int num) {
//		return Integer.toString(num, 7);
//	}
	
	/*
	 * 方案二：
	 * 自己实现jdk的方法
	 */
	public String convertToBase7(int num){
		if(num == 0) return "0";
		StringBuilder builder = new StringBuilder();
		int temp = (num < 0)?-num:num;
		while(temp != 0){
			int remain = temp % 7;
			builder.append(remain);
			temp = temp/7;
		}
		if(num < 0) builder.append('-');
		return builder.reverse().toString();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Base7 sol = new Base7();
		String ret = sol.convertToBase7(100);
		System.out.println(ret);
	}
}
