package medium.graph;

import java.util.HashSet;

/**
 * Given the head of a graph, return a deep copy (clone) of the graph. Each node
 * in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of
 * its neighbors. There is an edge between the given node and each of the nodes
 * in its neighbors.
 * 
 * @author wenhanglei
 */
public class CloneGraph {
	/*
	 * 思路：深度优先遍历全图即可
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		HashSet<UndirectedGraphNode> set = new HashSet<>();
		UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
		dfs(node, ret, set);
		return ret;
	}
	
	private void dfs(UndirectedGraphNode oN, UndirectedGraphNode nN, HashSet<UndirectedGraphNode> set){
		set.add(oN);
		for(UndirectedGraphNode n : oN.neighbors){
			UndirectedGraphNode next = (n== oN)?nN:new UndirectedGraphNode(n.label);
			nN.neighbors.add(next);
			if(!set.contains(n)){
				dfs(n, next, set);
			}
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
