package medium.graph;

import java.util.LinkedList;

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
	
	boolean[] marked;
	boolean[] onStack;
	boolean canFinish = true;
	
	/*
	 * 思路：先决条件其实就是入度邻接表
	 * 只要找到先决条件中存在环就可以判断为否
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//边界检查
		if(numCourses == 1 || prerequisites.length == 0) return true;
		//根据先决条件构建邻接表
		LinkedList<Integer>[] edges = (LinkedList<Integer>[]) new LinkedList<?>[numCourses];
		for(int[] ent : prerequisites) {
			if(edges[ent[1]] == null){
				LinkedList<Integer> list = new LinkedList<>();
				list.add(ent[0]);
				edges[ent[1]] = list;
			}else{
				edges[ent[1]].add(ent[0]);
			}
		}
		marked = new boolean[numCourses];
		onStack = new boolean[numCourses];
		//深度优先遍历查看图中是否有环
		for(int i = 0; i < numCourses; i++){
			if(!marked[i]) dfs(edges, i);
		}
		return canFinish;
	}
	
	public void dfs(LinkedList<Integer>[] edges, int v){
		if(!canFinish) return;
		marked[v] = true;
		if(edges[v] == null) return;
		onStack[v] = true;
		for(Integer w : edges[v]){
			if(!marked[w]){
				dfs(edges, w);
			}else{
				if(onStack[w]) canFinish = false;
			}
		}
		onStack[v] = false;
	}
	

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		CourseSchedule sol = new CourseSchedule();
		boolean ret = sol.canFinish(2, new int[][] {{1, 0}});
		System.out.println(ret);
	}
}
