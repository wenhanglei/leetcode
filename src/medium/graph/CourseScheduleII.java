package medium.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1. Some
 * courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1] Given the total
 * number of courses and a list of prerequisite pairs, return the ordering of
 * courses you should take to finish all courses. There may be multiple correct
 * orders, you just need to return one of them. If it is impossible to finish
 * all courses, return an empty array.
 * 
 * @author wenhanglei
 */
public class CourseScheduleII {
	
	boolean[] marked;
	boolean[] onStack;
	boolean hasCycle = false;
	Stack<Integer> stack;                 //保存结果的栈
	
	/*
	 * 思路：使用邻接表实现拓扑排序
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		marked = new boolean[numCourses];
		onStack = new boolean[numCourses];
		stack = new Stack<>();
		
		//构建邻接表
		LinkedList<Integer>[] edges = (LinkedList<Integer>[]) new LinkedList<?>[numCourses];
		for(int i = 0; i < numCourses; i++) edges[i] = new LinkedList<>();
		for(int[] ent : prerequisites) edges[ent[1]].add(ent[0]);
		
		for(int i = 0; i < numCourses; i++){
			if(!hasCycle && !marked[i]) dfs(edges, i);
		}
		
		if(hasCycle) return new int[0];
		
		int[] ret = new int[numCourses];
		for(int i = 0; i < numCourses; i++) ret[i] = stack.pop();
		return ret;
	}
	
	private void dfs(LinkedList<Integer>[] edges, int v){
		if(hasCycle) return;
		marked[v] = true;
		onStack[v] = true;
		for(int w : edges[v]){
			if(!marked[w]){
				dfs(edges, w);
			}else {
				if(onStack[w]) hasCycle = true;
			}
		}
		stack.push(v);
		onStack[v] = false;
	}
	
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		CourseScheduleII sol = new CourseScheduleII();
		int[][] prerequisites = {
				{1, 0}, {2, 0}, {3, 1}, {3, 2}
		};
		int[] ret = sol.findOrder(4, prerequisites);
		System.out.println(Arrays.toString(ret));
	}
}
