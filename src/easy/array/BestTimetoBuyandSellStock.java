package easy.array;
/**
 * Say you have an array for which the ith 
 * element is the price of a given stock on day i.
 * If you were only permitted to complete at 
 * most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 * @author wenhanglei
 *
 */
public class BestTimetoBuyandSellStock {
	/*
	 * 思路：
	 * 动态规划
	 */
	public int maxProfit(int[] prices) {
		//边界检查
		if(prices == null || prices.length == 0) return 0;
		//第i天卖出的最大利润
		int max = -prices[0];
		//结果变量
		int res = 0;
		for(int i = 1; i < prices.length; i++){
			if(max > 0)
				max = prices[i]-prices[i-1]+max;
			else
				max = prices[i]-prices[i-1];
			if(max > res)
				res = max;
		}
		return res;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] arr = {7, 1, 5, 3, 6, 4};
		int[] arr1 = {7, 6, 4, 3, 1};
		int[] arr2 = {1, 2};
		BestTimetoBuyandSellStock sol = new BestTimetoBuyandSellStock();
		int res = sol.maxProfit(arr2);
		System.out.println(res);
	}
}
