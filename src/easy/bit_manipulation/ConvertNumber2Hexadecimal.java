package easy.bit_manipulation;
/**
 * Given an integer, write an algorithm to convert 
 * it to hexadecimal. For negative integer, two’s 
 * complement method is used.
 * @author wenhanglei
 */
public class ConvertNumber2Hexadecimal {
	/*
	 * 思路：
	 */
	public String toHex(int num) {
		StringBuilder sb = new StringBuilder();
		if(num == 0) sb.append("0");
		while(num != 0){
			int a = num&15;
			sb.append(a/10==0?(char)(a+'0'):(char)(a%10+'a'));
			num>>>=4;
		}
        return sb.reverse().toString();
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ConvertNumber2Hexadecimal sol = new ConvertNumber2Hexadecimal();
		String ret = sol.toHex(-1);
		System.out.println(ret);
	}
}
