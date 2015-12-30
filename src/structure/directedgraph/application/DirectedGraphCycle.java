package structure.directedgraph.application;

import java.util.Stack;

import structure.directedgraph.DirectedGraph;

/**
 * determine whether there is a cycle in the directed graph
 * 
 * go from a source node and use the dfs algorithm
 * 
 * if there is a cycle, so stop the algorithm and return the cycle (always
 * return a first detective cycle which has the source)
 * 
 * @author wuxu
 * @time 2015Äê12ÔÂ30ÈÕ
 */
public class DirectedGraphCycle {

	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	private boolean[] onStack; // onStack[v] = is vertex on the stack?

	public DirectedGraphCycle(DirectedGraph graph) {
		marked = new boolean[graph.V()];
		onStack = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		for (int v = 0; v < graph.V(); v++)
			if (!marked[v] && cycle == null)
				dfs(graph, v);
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	/**
	 * go from the source node (v) to marked all connected nodes and put nodes
	 * in a same cycle into the stack
	 * 
	 * @param graph
	 * @param v
	 */
	private void dfs(DirectedGraph graph, int current) {
		onStack[current] = true;
		marked[current] = true;
		for (int i : graph.adj(current)) {
			// short circuit if directed cycle found
			if (cycle != null) {
				return;
				// check the adjacency vertices and if it is marked means it has
				// been not visited, so mark it and recursive check it
			} else if (!marked[i]) {
				edgeTo[i] = current;
				dfs(graph, i);
			} // trace back directed cycle
			else if (onStack[i]) {
				cycle = new Stack<Integer>();
				for (int pointer = current; pointer != i; pointer = edgeTo[pointer]) {
					cycle.push(pointer);
				}
				cycle.push(i);
				cycle.push(current);
			}
		}
		onStack[current] = false;
	}

	/**
	 * Returns a directed cycle if the digraph has a directed cycle, and null
	 * otherwise.
	 * 
	 * @return
	 */
	public Iterable<Integer> cycle() {
		return cycle;
	}

}
