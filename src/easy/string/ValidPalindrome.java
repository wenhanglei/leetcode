package easy.string;
/**
 * Given a string, determine if it is a palindrome, considering 
 * only alphanumeric characters and ignoring cases.
 * @author wenhanglei
 */
public class ValidPalindrome {
	/*
	 * 思路：
	 * 使用两个指针保存下一个需要用来比较的头字符和尾字符的位置
	 * 比较头字符和尾字符是否相等，如果不相等返回false
	 * 当头字符的下标大于尾字符的坐标时比较结束
	 */
	public boolean isPalindrome(String s) {
		//边界判断
		if(s.length() == 0) return true;
		//下一个需要比较的头字符和尾字符的下标
		int head=0, tail=s.length()-1;
		//需要比较的头字符和尾字符
		char cHead, cTail;
		//循环比较
		while(head < tail){
			//取得需要比较的头字符
			 cHead = s.charAt(head);
			 //取得需要比较的尾字符
			 cTail = s.charAt(tail);
			 //判断比较的字符是否合法
			 if(!Character.isLetterOrDigit(cHead)){
				 head++;
			 }else if(!Character.isLetterOrDigit(cTail)){
				 tail--;
			 }else{
				 if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) 
					 return false;
				 head++;
				 tail--;
			 }
		}
		return true;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		ValidPalindrome sol = new ValidPalindrome();
		boolean res = sol.isPalindrome(str);
		System.out.println(res);
	}
}
