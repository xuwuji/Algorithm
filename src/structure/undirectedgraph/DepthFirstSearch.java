package structure.undirectedgraph;

import java.util.Stack;

/**
 * all the operation is choosing v as the source
 * 
 * @author xuwuji
 * @time Dec 27, 2015
 */
public class DepthFirstSearch {

	// represents which vertices are marked
	private boolean[] marked;
	// represents the relationship of a tree rooted at v
	private int[] edgeTo;
	// means all path goes from v
	private int v;

	public DepthFirstSearch(UndirectedGraph graph, int v) {
		marked = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		dfs(graph, v);
	}

	/**
	 * return
	 * 
	 * @param graph
	 * @param v
	 */
	public void dfs(UndirectedGraph graph, int v) {
		System.out.println("v:" + v);
		marked[v] = true;
		// scan the vertices adjacent with v
		for (int w : graph.adj(v)) {
			/**
			 * if the vertices are not marked (means not been searched), then
			 * mark it to true. And record that it is from v
			 */
			if (marked[w] != true) {
				edgeTo[w] = v;
				dfs(graph, w);
			}
		}
	}

	public void DisplayMarked() {
		for (int i = 0; i < marked.length; i++) {
			System.out.println(i + " : " + marked[i]);
		}
	}

	public void DisplayedgeTo() {
		for (int i = 0; i < edgeTo.length; i++) {
			System.out.println(i + " : " + edgeTo[i]);
		}
	}

	/**
	 * determine whether v is connected to w or not
	 * 
	 * @param w
	 * @return
	 */
	public boolean connected(int w) {
		return marked[w];
	}

	/**
	 * return the path from the source(v) to the target(w)
	 * 
	 * @param w
	 * @return
	 */
	public Stack<Integer> path(int w) {
		if (!connected(w)) {
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();
		int pointer = w;
		while (pointer != v) {
			path.push(pointer);
			pointer = edgeTo[pointer];
		}
		path.push(v);
		return path;
	}
}
