package structure.shorestPath;

import java.util.LinkedList;

import structure.minimumSpanningTree.Edge;

public class EdgeWeightedDirectedGraph {
	private int V;
	private int E;
	private LinkedList<DirectedEdge>[] adjs;

	public EdgeWeightedDirectedGraph(int V) {
		this.V = V;
		adjs = (LinkedList<DirectedEdge>[]) new LinkedList[V];
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(DirectedEdge edge) {
		int from = edge.from();
		this.adjs[from].add(edge);
		E++;
	}

	public Iterable<DirectedEdge> adj(int v) {
		return this.adjs[v];
	}

	public Iterable<DirectedEdge> edges() {
		LinkedList<DirectedEdge> edges = new LinkedList<DirectedEdge>();
		for (int i = 0; i < V; i++) {
			for (DirectedEdge e : adjs[i]) {
				edges.add(e);
			}
		}
		return edges;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < adjs.length; i++) {
			sb.append(i + "  -->");
			for (DirectedEdge e : adjs[i]) {
				sb.append(e + "  ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
