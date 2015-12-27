package structure.graph;

/**
 * check whether a graph is bipartite graph
 * 
 * @author xuwuji
 * @time Dec 28, 2015
 */
public class BipartiteGraph {

	public boolean isBipartite(UndirectedGraph graph) {
		boolean[] marked = new boolean[graph.V()];
		boolean[] color = new boolean[graph.V()];
		boolean isTwoColorable = true;
		for (int pointer = 0; pointer < graph.V(); pointer++)
			if (!marked[pointer]) {
				isBipartiteDFS(graph, pointer, marked, color, isTwoColorable);
			}
		return isTwoColorable;
	}

	public void isBipartiteDFS(UndirectedGraph graph, int v, boolean[] marked, boolean[] color,
			boolean isTwoColorable) {
		marked[v] = true;
		for (int w : graph.adj(v)) {
			if (!marked[w]) {
				color[w] = !color[v];
				isBipartiteDFS(graph, w, marked, color, isTwoColorable);
			} else if (color[w] == color[v]) {
				isTwoColorable = false;
			}
		}
		isTwoColorable = true;
	}
}
