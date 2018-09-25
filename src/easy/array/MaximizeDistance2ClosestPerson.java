package easy.array;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0
 * represents that the seat is empty.
 * 
 * There is at least one empty seat, and at least one person sitting.
 * 
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized.
 * 
 * Return that maximum distance to closest person.
 * 
 * @author wenhanglei
 */
public class MaximizeDistance2ClosestPerson {
	/*
	 * 思路：双指针遍历即可
	 */
	public int maxDistToClosest(int[] seats) {
		//边界检查
		if(seats == null) return -1;
		int i, j, ret = 0;
		for(i = -1, j = 0; j < seats.length; j++){
			if(seats[j] == 1){
				if(i == -1) ret = Math.max(ret, j);
				else ret = Math.max(ret, (j-i)/2);
				i = j;
			}
		}
		ret = Math.max(ret, seats.length-i-1);
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		MaximizeDistance2ClosestPerson sol = new MaximizeDistance2ClosestPerson();
		int[] seats = {1,0,0,0,1,0,1};
		int ret = sol.maxDistToClosest(seats);
		System.out.println(ret);
	}
}
