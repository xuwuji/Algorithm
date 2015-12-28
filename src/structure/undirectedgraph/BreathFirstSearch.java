package structure.undirectedgraph;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {

	private boolean[] marked;
	private int[] edgeTo;
	// distTo[v] = number of edges shortest from target to point v
	private int[] distTo;
	private int v;

	public BreathFirstSearch(UndirectedGraph graph, int v) {
		marked = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		distTo = new int[graph.V()];
		bfs(graph, v);
	}

	public void bfs(UndirectedGraph graph, int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < distTo.length; i++) {
			distTo[i] = 0;
		}
		marked[v] = true;
		queue.add(v);
		while (!queue.isEmpty()) {
			int head = queue.poll();
			for (int i : graph.adj(head)) {
				if (!marked[i]) {
					distTo[i] = distTo[head] + 1;
					edgeTo[i] = head;
					queue.add(i);
					marked[i] = true;
				}
			}
		}
	}

	public int getDegree(int v) {
		return distTo[v];
	}

}
