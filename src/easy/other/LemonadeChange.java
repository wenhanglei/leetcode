package easy.other;

import java.util.HashMap;

/**
 * At a lemonade stand, each lemonade costs $5.
 * 
 * Customers are standing in a queue to buy from you, and order one at a time
 * (in the order specified by bills).
 * 
 * Each customer will only buy one lemonade and pay with either a $5, $10, or
 * $20 bill. You must provide the correct change to each customer, so that the
 * net transaction is that the customer pays $5.
 * 
 * Note that you don't have any change in hand at first.
 * 
 * Return true if and only if you can provide every customer with correct
 * change.
 * 
 * @author wenhanglei
 */
public class LemonadeChange {
	/*
	 * 思路：遍历统计即可
	 */
	public boolean lemonadeChange(int[] bills) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < bills.length; i++){
			if(bills[i] == 10){
				Integer n = map.get(5);
				if(n == null || n < 1) return false;
				else map.put(5, n-1);
			}
			if(bills[i] == 20){
				Integer n = map.get(10);
				Integer l = map.get(5);
				if(n == null || n == 0) {
					if(l == null || l < 3) return false;
					else map.put(5, l-3);
				}else{
					if(l == null || l < 1) return false;
					else {
						map.put(10, n-1);
						map.put(5, l-1);
					}
				}
			}
			map.put(bills[i], map.containsKey(bills[i])?map.get(bills[i])+1:1);
		}
		return true;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LemonadeChange sol = new LemonadeChange();
		int[] bills = {5,5,5,5,20,20,5,5,20,5};
		boolean ret = sol.lemonadeChange(bills);
		System.out.println(ret);
	}
}
