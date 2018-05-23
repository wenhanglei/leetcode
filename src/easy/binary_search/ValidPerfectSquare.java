package easy.binary_search;
/**
 * Given a positive integer num, write a function which 
 * returns True if num is a perfect square else False.
 * @author wenhanglei
 */
public class ValidPerfectSquare {
	/*
	 * 思路：
	 * 迭代
	 */
	public boolean isPerfectSquare(int num) {
		if(num == 1 || num == 4 || num == 9) return true;
        for(int i = 4; i <= num/2; i++){
        	if(i*i == num) return true; 
        }
        return false;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ValidPerfectSquare sol = new ValidPerfectSquare();
		boolean ret = sol.isPerfectSquare(1);
		System.out.println(ret);
	}
}
