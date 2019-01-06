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
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for(int i = 0; i < gas.length; i++){
			if(gas[i]-cost[i] >= 0){
				if(isValid((i+1)%gas.length, gas[i]-cost[i], i, gas, cost)) return i;
			}
		}
		return -1;
	}
	
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
