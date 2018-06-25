package easy.binary_search;
/**
 * you are given positions of houses and heaters on 
 * a horizontal line, find out minimum radius of heaters 
 * so that all houses could be covered by those heaters.
 * @author wenhanglei
 */
public class Heaters {
	/*
	 * 思路：
	 */
	public int findRadius(int[] houses, int[] heaters) {
		for(int i = 0; i < houses.length; i++){
			
		}
        return 0;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Heaters sol = new Heaters();
		int[] houses = {1, 2, 3, 4};
		int[] heaters = {1, 4};
		int ret = sol.findRadius(houses, heaters);
		System.out.println(ret);
	}
}
