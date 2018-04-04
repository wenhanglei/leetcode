package easy.array;
/**
 * Say you have an array for which the ith 
 * element is the price of a given stock on day i.
 * @author wenhanglei
 *
 */
public class BestTimetoBuyandSellStockII {
	/*
	 * 思路：
	 */
	public int maxProfit(int[] prices) {
		//边界检查
		if(prices == null || prices.length == 0) return 0;
		//结果变量
		int res = 0;
		for(int i = 0; i < prices.length-1; i++){
			if(prices[i+1] > prices[i])
				res += prices[i+1] - prices[i];
		}
		return res;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {7, 1, 5, 3, 6, 4};
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {5, 4, 3, 2, 1, 3};
		int[] arr3 = {1, 4, 2};
		BestTimetoBuyandSellStockII sol = new BestTimetoBuyandSellStockII();
		int res = sol.maxProfit(arr1);
		System.out.println(res);
	}
}
