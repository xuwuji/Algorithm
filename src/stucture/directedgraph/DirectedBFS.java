package stucture.directedgraph;

import java.util.LinkedList;
import java.util.Queue;

public class DirectedBFS {

	private boolean[] marked;
	private int[] distTo;

	public DirectedBFS(DirectedGraph graph, int v) {
		distTo = new int[graph.V()];
		bfs(graph, v);
	}

	public void bfs(DirectedGraph graph, int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		marked[v] = true;
		queue.add(v);
		while (!queue.isEmpty()) {
			int head = queue.poll();
			for (int i : graph.adj(head)) {
				distTo[i] = distTo[head] + 1;
				queue.add(i);
			}
		}
	}

	public boolean connected(int w) {
		return marked[w];
	}

	public int distTo(int w) {
		return distTo[w];
	}
}
