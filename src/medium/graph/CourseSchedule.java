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
	boolean hasCircle = true;
	/*
	 * 思路：先决条件其实就是入度邻接表
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean[] marked = new boolean[numCourses];
		dfs(prerequisites, marked, 0);
		return hasCircle;
	}
	
	private void dfs(int[][] grid, boolean[] marked, int v){
		if(marked[v]) return;
		marked[v] = true;
		for(int w : grid[v]){
			if(marked[v]) hasCircle = false;
			else dfs(grid, marked, w);
		}
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
