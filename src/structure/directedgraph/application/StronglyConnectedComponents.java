package structure.directedgraph.application;

import java.util.Stack;

import structure.directedgraph.DirectedGraph;

/**
 * using Kosaraju's algorithm
 * 
 * 1.get the reverse graph of the original one
 * 
 * 2.get the reverse post order of reverse graph
 * 
 * 3.use the order to dfs the original graph
 * 
 * @author wuxu
 * @time 2015��12��31��
 */
public class StronglyConnectedComponents {

	private boolean[] marked;
	private int[] id;
	private int count;

	public StronglyConnectedComponents(DirectedGraph graph) {
		marked = new boolean[graph.V()];
		id = new int[graph.V()];
		// 1.reverse the graph
		DirectedGraph reverseGraph = graph.reverse();
		// 2.get the reverse post order of the reversed graph
		DepthFirstOrder search = new DepthFirstOrder(reverseGraph);
		Stack<Integer> reversePostOrder = new Stack<Integer>();
		// 注意这里的由于没有判断是否存在环，所以返回的order可能不同
		// 只有当无环时才等同于也是拓扑排序，若存在环，则返回的仅仅是一个逆后序order而已
		reversePostOrder = search.reversePost();
		// 3.use this order to do dfs on original graph
		while (!reversePostOrder.isEmpty()) {
			int pointer = reversePostOrder.pop();
			if (!marked[pointer]) {
				dfs(graph, pointer);
				count++;
			}
		}
	}

	public void dfs(DirectedGraph graph, int v) {
		marked[v] = true;
		id[v] = count;
		for (int i : graph.adj(v)) {
			if (!marked[i]) {
				dfs(graph, i);
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < id.length; i++) {
			sb.append("\n" + i + " ->" + id[i]);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
