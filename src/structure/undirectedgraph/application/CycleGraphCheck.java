package structure.undirectedgraph.application;

import java.util.Stack;

import structure.undirectedgraph.UndirectedGraph;

public class CycleGraphCheck {

	public static boolean hasCycle(UndirectedGraph graph) {
		boolean[] marked = new boolean[graph.V()];
		// int[] edgeTo = new int[graph.V()];
		// Stack<Integer> cycle = new Stack<Integer>();
		boolean hasCycle = false;
		return dfs(graph, marked, -1, 0, hasCycle);
	}

	/**
	 * 在这个方法中，有hasCycle作为tag，由于是递归的来进行，所以一直进行下去直到某个节点没有相邻的节点为止
	 * 其实在上面的方法就是要返回dfs（－1，0）的结果，在递归的过程中，只有当满足w!=pre的条件时，才会改变hasCycle
	 * 的值，所以最终如果有环的环，hasCycle会为true，注意在每次调用递归的时候，并没有return，因为递归的时候
	 * 我们并不想return，只有等到所有情况跑完之后才会返回
	 * 
	 * 
	 * @param graph
	 * @param marked
	 * @param pre
	 * @param current
	 * @param hasCycle
	 * @return
	 */
	public static boolean dfs(UndirectedGraph graph, boolean[] marked, int pre, int current, boolean hasCycle) {
		// System.out.println("pre:" + pre);
		// System.out.println("current:" + current);
		// System.out.println("hasCycle:" + hasCycle);
		marked[current] = true;
		for (int w : graph.adj(current)) {
			if (!marked[w]) {
				hasCycle = dfs(graph, marked, current, w, hasCycle);
			} else if (w != pre) {
				hasCycle = true;
			}
		}
		return hasCycle;

	}

}
