package easy.math;

/**
 * Given a non-negative integer c, your task is to decide whether there're two
 * integers a and b such that a2 + b2 = c.
 * 
 * @author wenhanglei
 */
public class SumSquareNumbers {
	/*
	 * 思路：
	 */
	public boolean judgeSquareSum(int c) {
		//边界检查
		if(c == 0) return true;
		//上限
		int ceiling = (int) Math.sqrt(c/2)+1;
		for(int i = 0; i <= ceiling; i++){
			if(haveSqure(c-i*i)) return true;
		}
		return false;
	}
	
	private boolean haveSqure(int i){
		int j = (int) Math.sqrt(i);
		if(j*j == i) return true;
		else return false;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SumSquareNumbers sol = new SumSquareNumbers();
		boolean ret = sol.judgeSquareSum(16);
		System.out.println(ret);
	}
}
