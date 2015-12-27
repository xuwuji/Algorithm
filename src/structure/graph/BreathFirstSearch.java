package structure.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {

	private boolean[] marked;
	private int[] edgeTo;
	private int v;

	public BreathFirstSearch(UndirectedGraph graph, int v) {
		marked = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		bfs(graph, v);
	}

	public void bfs(UndirectedGraph graph, int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		marked[v] = true;
		queue.add(v);
		while (!queue.isEmpty()) {
			int head = queue.poll();
			for (int i : graph.adj(head)) {
				if (!marked[i]) {
					edgeTo[i] = head;
					queue.add(i);
					marked[i] = true;
				}
			}
		}
	}

}
