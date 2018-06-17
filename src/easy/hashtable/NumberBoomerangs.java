package easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the number of boomerangs. You may assume 
 * that n will be at most 500 and coordinates of 
 * points are all in the range [-10000, 10000] (inclusive).
 * @author wenhanglei
 */
public class NumberBoomerangs {
	/*
	 * 思路：
	 * 统计所有距离相同的点的数量
	 * 通过公式可以求出距离相同的点能构造的boomerang的数量
	 */
	public int numberOfBoomerangs(int[][] points) {
		//边界检查
		if(points == null) return 0;
		int ret = 0;
		
		//因为只需要统计数量所以计算准确的距离没有必要
		Map<Integer, Integer> map = new HashMap<>();    //map<距离的平方，数量>
		for(int i = 0; i < points.length; i++){
			for(int j = 0; j < points.length; j++){
				if(j == i) continue;
				int dist = getDistance(points[i], points[j]);
				map.put(dist, map.containsKey(dist)?map.get(dist)+1:1);
			}
			//当前以i点为第一个点的可能组合数量
			for(int val : map.values()){
				ret += val*(val-1);
			}
			//清空容器
			map.clear();
		}
		
		return ret;
    }
	
	/**
	 * 两个坐标之间的距离的平方
	 */
	private int getDistance(int[] i, int[] j){
		int dx = i[0] - j[0];
		int dy = i[1] - j[1];
		return dx*dx + dy*dy;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
