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
	boolean hasCircle = false;
	boolean[] onStack;          //当前路径已经遍历过的节点
	/*
	 * 思路：先决条件其实就是入度邻接表
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//边界检查
		if(numCourses == 1) return true;
		if(prerequisites == null || prerequisites.length == 0) return false;
		boolean[] marked = new boolean[numCourses];
		onStack = new boolean[numCourses];
		dfs(prerequisites, marked, 0);
		if(hasCircle) return false;
		for(boolean b : marked) if(!b) return false;
		return true;
	}
	
	private void dfs(int[][] grid, boolean[] marked, int v){
		if(hasCircle) return;            //如果已经有环了就不再遍历了
		marked[v] = true;
		onStack[v] = true;
		for(int w : grid[v]){
			if(!marked[v]) {
				dfs(grid, marked, w);
			}else if(onStack[w]) hasCircle = true;
		}
		onStack[v] = false;
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
