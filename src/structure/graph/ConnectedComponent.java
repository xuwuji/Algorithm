package structure.graph;

/**
 * 
 * @author xuwuji
 * @time Dec 27, 2015
 */

/**
 * get all connected component in a graph
 * 
 * @author xuwuji
 * @time Dec 27, 2015
 */
public class ConnectedComponent {
	// marked[v] = has vertex v been marked?
	private boolean[] marked;
	// id[v] = id of connected component containing v
	private int[] id;
	// size[id] = number of vertices in given component
	private int[] size;
	// the current number of connected component in the graph
	private int count = 0;

	public ConnectedComponent(UndirectedGraph graph) {
		marked = new boolean[graph.V()];
		id = new int[graph.V()];
		for (int pointer = 0; pointer < graph.V(); pointer++) {
			if (!marked[pointer]) {
				// because a one time dfs will track all vertices connected to
				// the source,so for a unmarked source, it will connect all
				// vertices in one connected component.

				/**
				 * After one time dfs, will get a connected component. Check the
				 * marked array to set the next track and it is a new connected
				 * component, so the count(current connected component id)should
				 * be plus one
				 */
				dfs(graph, pointer);
				count++;
			}

		}
	}

	private void dfs(UndirectedGraph graph, int v) {
		marked[v] = true;
		id[v] = count;
		size[count]++;
		for (int w : graph.adj(v))
			if (!marked[w])
				dfs(graph, w);
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}

}
