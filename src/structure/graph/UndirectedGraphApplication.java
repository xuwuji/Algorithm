package structure.graph;

public class UndirectedGraphApplication {

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

	private void isBipartiteDFS(UndirectedGraph graph, int v, boolean[] marked, boolean[] color,
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

	/**
	 * find a cycle that uses every edge of the graph exactly once If there is a
	 * Eulerian cycle, the sum of the degree of all vertices need to be even.
	 * 
	 * @param graph
	 * @return
	 */
	public boolean CycleWithEdges(UndirectedGraph graph) {
		boolean[] marked = new boolean[graph.V()];
	}

	private void CycleWithEdgesDFS(UndirectedGraph graph, int v, boolean[] marked, boolean[] color,
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

	/**
	 * find a cycle that uses every vertex of the graph exactly once
	 * 
	 * @param graph
	 * @return
	 */
	public boolean CycleWithVertices(UndirectedGraph graph) {
		boolean[] marked = new boolean[graph.V()];
	}

}
