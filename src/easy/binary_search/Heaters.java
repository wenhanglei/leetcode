package easy.binary_search;

import java.util.Arrays;

/**
 * you are given positions of houses and heaters on 
 * a horizontal line, find out minimum radius of heaters 
 * so that all houses could be covered by those heaters.
 * @author wenhanglei
 */
public class Heaters {
	/*
	 * 思路：
	 * 遍历所有的house查找在heaters中最近的一个heater
	 * 从所有取得的heater中找到最小值即为结果
	 */
	public int findRadius(int[] houses, int[] heaters) {
		int min = 0;                                     //离当前house最近的一个heater
		int max = 0;                                     //所有min中的最大值
		Arrays.sort(heaters);                            //对heaters进行排序
		for(int i = 0; i < houses.length; i++){
			if(houses[i] <= heaters[0])
				min = heaters[0] - houses[i];
			else if(houses[i] >= heaters[heaters.length-1])
				min = houses[i] - heaters[heaters.length-1];
			else {
				if(Arrays.binarySearch(heaters, houses[i]) < 0){
					int ip = -1-Arrays.binarySearch(heaters, houses[i]);
					min = Math.min(heaters[ip]-houses[i], houses[i]-heaters[ip-1]);
				}else min = 0;
			}
			if(min > max) max = min;
		}
        return max;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Heaters sol = new Heaters();
		int[] houses = {1, 2, 3};
		int[] heaters = {1, 2, 3};
		int ret = sol.findRadius(houses, heaters);
		System.out.println(ret);
	}
}
