package structure.directedgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * find all target vertices can be reached by the source
 * 
 * @author wuxu
 * @time 2015Äê12ÔÂ29ÈÕ
 */
public class DirectedDFS {

	private boolean[] marked;

	public DirectedDFS(DirectedGraph graph, int v) {
		marked = new boolean[graph.V()];
		dfs(graph, v);
	}

	public void dfs(DirectedGraph graph, int v) {
		marked[v] = true;
		for (int w : graph.adj(v)) {
			dfs(graph, w);
		}
	}

	public boolean Connected(int w) {
		return marked[w];
	}

	public Iterable<Integer> getAllConnected() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < marked.length; i++) {
			if (marked[i] == true) {
				list.add(i);
			}
		}
		return list;
	}

}
