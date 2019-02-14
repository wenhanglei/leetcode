package medium.graph;
/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * @author wenhanglei
 */
public class CourseSchedule {
	/*
	 * 思路：先决条件其实就是入度邻接表
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//边界检查
		if(numCourses == 1 || prerequisites.length == 0) return true;
		boolean flag = prerequisites[0][0]-prerequisites[0][1] > 0;
		for(int[] edge : prerequisites){
			if(flag){
				if(edge[0] < edge[1]) return false;
			}else{
				if(edge[0] > edge[1]) return false;
			}
		}
		return true;
	}
	

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		CourseSchedule sol = new CourseSchedule();
		boolean ret = sol.canFinish(2, new int[][] {{1, 0}, {0, 1}});
		System.out.println(ret);
	}
}
