package easy.binary_search;
/**
 * Guess a number picked from 1 to n
 * @author wenhanglei
 */
public class GuessNumberHigherOrLower extends GuessGame{
	/*
	 * 思路：
	 * 二分查找
	 */
	public int guessNumber(int n) {
		int lo = 1;
		int hi = n;
		while(lo <= hi){
			int mid = lo + (hi-lo)/2;
			if(guess(mid) < 0) lo = mid + 1;
			else if(guess(mid) > 0) hi = mid - 1;
			else return mid;
		}
		return -1;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		GuessNumberHigherOrLower sol = new GuessNumberHigherOrLower();
		int ret = sol.guessNumber(10);
		System.out.println(ret);
	}
}
