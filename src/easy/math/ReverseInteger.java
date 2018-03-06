package easy.math;
/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * @author wenhanglei
 */
public class ReverseInteger {
	public int reverse(int x) {
		//结果变量
		int res = 0;
		while(x != 0){
			int a = x%10;
			int b = res;
			res = res * 10 + a;
			if((res-a)/10 != b)
				return 0;
			x /= 10;
		}
        return res;
    }
	
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int a = 1923;
		ReverseInteger sol = new ReverseInteger();
		int reverse = sol.reverse(a);
		System.out.println(reverse);
	}
}
