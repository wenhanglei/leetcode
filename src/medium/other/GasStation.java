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
	 * 思路：
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int r = 0, c = 0, idx = -1;
		for(int i = 0; i < gas.length; i++){
			if(gas[i]-cost[i] >= 0) {
				if(gas[i]-cost[i] > r) {
					r = gas[i]-cost[i];
					idx = i;
				}
			}else{
				if(cost[i]-gas[i] > r) {
					c = cost[i]-gas[i];
					idx = -1;
				}
			}
		}
		return idx;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
