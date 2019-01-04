package medium.graph;

import java.util.HashMap;

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
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
		dfs(node, ret, map);
		return ret;
	}
	
	private void dfs(UndirectedGraphNode oN, UndirectedGraphNode nN, HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
		map.put(oN, nN);
		for(UndirectedGraphNode n : oN.neighbors){
			if(!map.containsKey(n)){
				UndirectedGraphNode next = new UndirectedGraphNode(n.label);
				nN.neighbors.add(next);
				dfs(n, next, map);
			}else{
				nN.neighbors.add(map.get(n));
			}
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
