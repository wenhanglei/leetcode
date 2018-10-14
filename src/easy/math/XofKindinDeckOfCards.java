package easy.math;

import java.util.HashMap;

/**
 * In a deck of cards, each card has an integer written on it.
 * 
 * Return true if and only if you can choose X >= 2 such that it is possible to
 * split the entire deck into 1 or more groups of cards, where:
 * 
 * Each group has exactly X cards. All the cards in each group have the same
 * integer.
 * 
 * @author wenhanglei
 */
public class XofKindinDeckOfCards {
	/*
	 * 思路：使用hashmap统计即可
	 */
	public boolean hasGroupsSizeX(int[] deck) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < deck.length; i++){
			map.put(deck[i], map.containsKey(deck[i])?map.get(deck[i])+1:1);
		}
		int min = Integer.MAX_VALUE;
		for(int i : map.values()){
			min = Math.min(min, i);
		}
		if(min < 2) return false;
		boolean flag = false;
		for(int i = 2; i <= min; i++){
			if(min%i == 0){
				boolean f = true;
				for(int j : map.values()){
					if(j%i != 0) {
						f = false;
						break;
					}
				}
				flag = flag || f;
			}
		}
		return flag;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		XofKindinDeckOfCards sol = new XofKindinDeckOfCards();
		int[] deck = {1,1,1,2,2,2,3,3};
		boolean ret = sol.hasGroupsSizeX(deck);
		System.out.println(ret);
	}
}
