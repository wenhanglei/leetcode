package medium.other;

/**
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * @author wenhanglei
 */
public class GasStation {
	/*
	 * 思路：使用最笨的办法，遍历检查
	 * 贪心算法不仅可以求出下一步最优，而且可以使用上一步不符合条件排除下一步不符合条件
	 * 使用两次遍历求解
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		//第一次遍历如果总的气量小于需要消耗的气量则不存在解
		int total = 0;
		for(int i = 0; i < gas.length; i++){
			total += gas[i] - cost[i];
		}
		if(total < 0) return -1;
		//第二次遍历检查找到一个合法起点
		int start = 0;
		int accu = 0;
		for(int i = 0; i < gas.length; i++){
			int curr = gas[i]-cost[i];
			if(accu+curr < 0) {
				start = i+1;
				accu = 0;
			}else accu += curr;
		}
		return start;
	}
	
	
//	public int canCompleteCircuit(int[] gas, int[] cost) {
//		for(int i = 0; i < gas.length; i++){
//			if(gas[i]-cost[i] >= 0){
//				if(isValid((i+1)%gas.length, gas[i]-cost[i], i, gas, cost)) return i;
//			}
//		}
//		return -1;
//	}
	
	public boolean isValid(int i, int rem, int start, int[] gas, int[] cost){
		if(i == start) return true;
		rem = gas[i]+rem-cost[i];
		if(rem < 0) return false;
		else return isValid((i+1)%gas.length, rem, start, gas, cost);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {3, 4, 5, 1, 2};
		GasStation sol = new GasStation();
		int ret = sol.canCompleteCircuit(gas, cost);
		System.out.println(ret);
	}
}
