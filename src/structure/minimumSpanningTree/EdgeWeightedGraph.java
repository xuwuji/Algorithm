package structure.minimumSpanningTree;

import java.util.LinkedList;

public class EdgeWeightedGraph {

	private int V;
	private int E;
	private LinkedList<Edge>[] adjs;

	public EdgeWeightedGraph(int V) {
		this.V = V;
		adjs = (LinkedList<Edge>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjs[i] = new LinkedList<Edge>();
		}
	}

	public void addEdge(Edge e) {
		int v = e.getEither();
		int w = e.getOther(v);
		adjs[v].add(e);
		adjs[w].add(e);
		E++;
	}

	public Iterable<Edge> adj(int v) {
		return adjs[v];
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public Iterable<Edge> edges() {
		LinkedList<Edge> edges = new LinkedList<Edge>();
		for (int i = 0; i < V; i++) {
			for (Edge e : adjs[i]) {
				if (e.getOther(i) > i) {
					edges.add(e);
				}
			}
		}
		return edges;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < V; i++) {
			builder.append(i + "  ->");
			for (Edge e : adjs[i]) {
				builder.append(e.toString() + "  ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
