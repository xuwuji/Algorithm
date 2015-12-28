package structure.undirectedgraph.application;

import structure.undirectedgraph.UndirectedGraph;

/**
 * check whether a graph is bipartite graph
 * 
 * @author xuwuji
 * @time Dec 28, 2015
 */
public class BipartiteGraph {

	public static boolean isBipartite(UndirectedGraph graph) {
		boolean[] marked = new boolean[graph.V()];
		boolean[] color = new boolean[graph.V()];
		boolean isTwoColorable = true;
		for (int pointer = 0; pointer < graph.V(); pointer++)
			if (!marked[pointer]) {
				isTwoColorable = isBipartiteDFS(graph, pointer, marked, color, isTwoColorable);
				if (isTwoColorable == false) {
					return false;
				}
			}
		return isTwoColorable;
	}

	public static boolean isBipartiteDFS(UndirectedGraph graph, int v, boolean[] marked, boolean[] color,
			boolean isTwoColorable) {
		System.out.println("current:" + v);
		marked[v] = true;
		for (int w : graph.adj(v)) {
			if (!marked[w]) {
				color[w] = !color[v];
				isBipartiteDFS(graph, w, marked, color, isTwoColorable);
			} else if (color[w] == color[v]) {
				isTwoColorable = false;
			}
		}
		return isTwoColorable;
	}
}
