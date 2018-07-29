package easy.array;

/**
 * Suppose you have a long flowerbed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots - they
 * would compete for water and both would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means
 * empty and 1 means not empty), and a number n, return if n new flowers can be
 * planted in it without violating the no-adjacent-flowers rule.
 * 
 * @author wenhanglei
 */
public class CanPlaceFlowers {
	/*
	 * 思路：
	 */
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		//边界检查
		int len = flowerbed.length;
		if(n > len/2+1) return false;
		int preIndex = 0, max = 0, i = -1;
		while(flowerbed[++i] == 0){
			if(i == len-1) return n <= len/2+(len%2==0?0:1);
		}
		max += i/2;
		preIndex = i;
		while(i < len-1){
			if(flowerbed[++i] == 1) {
				max += (i-preIndex-2)/2;
				preIndex = i;
			}
		}
		max += (i-preIndex)/2;
		return n <= max;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		CanPlaceFlowers sol = new CanPlaceFlowers();
		boolean ret = sol.canPlaceFlowers(new int[]{1,0, 0}, 1);
		System.out.println(ret);
	}
}
