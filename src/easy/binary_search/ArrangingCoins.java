package easy.binary_search;
/**
 * You have a total of n coins that you want to 
 * form in a staircase shape, where every k-th row must 
 * have exactly k coins.
 * @author wenhanglei
 */
public class ArrangingCoins {
	/*
	 * 思路：
	 */
	public int arrangeCoins(int n) {
		int counter = 0;
		int curr = 1;
		while(n >= curr){
			n -= curr;
			curr++;
			counter++;
		}
        return counter;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		ArrangingCoins sol = new ArrangingCoins();
		int ret = sol.arrangeCoins(8);
		System.out.println(ret);
	}
}
