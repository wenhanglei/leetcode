package medium.string;



/**
 * Implement a basic calculator to evaluate a simple expression string. The
 * expression string contains only non-negative integers, +, -, *, / operators
 * and empty spaces . The integer division should truncate toward zero.
 * 
 * @author wenhanglei
 */
public class BasicCalculatorII {
	/*
	 * 思路：不使用栈依次累加即可
	 */
	public int calculate(String s) {
		//边界检查
		if(s == null || s.length() == 0) return 0;
		//清除字符串中的所有空白
		s = s.trim();
		
		int sum = 0;
		int preNum = 0;
		char preOpt = '+';
		
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == ' ') continue;
			
			if(Character.isDigit(c)){
				int val = c-'0';
				while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
					val = val * 10 + s.charAt(i+1)-'0';
					i++;
				}
				if(preOpt == '+'){
					sum += preNum;
					preNum = val;
				}else if(preOpt == '-'){
					sum += preNum;
					preNum = -val;
				}else if(preOpt == '*'){
					preNum = preNum * val;
				}else if(preOpt == '/'){
					preNum = preNum / val;
				}
			}else{
				preOpt = c;
			}
			
		}
		return sum+preNum;
	}
	
	private void test(String a){
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		BasicCalculatorII sol = new BasicCalculatorII();
	}
}
