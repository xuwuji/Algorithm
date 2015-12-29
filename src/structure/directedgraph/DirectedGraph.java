package structure.directedgraph;

import java.util.LinkedList;

/**
 * 
 * @author wuxu
 * @time 2015Äê12ÔÂ29ÈÕ
 */
public class DirectedGraph {
	// the number of vertices in the graph
	private int V;
	// the number of edges in the graph
	private int E;

	LinkedList<Integer>[] adjs;

	public DirectedGraph(int V) {
		adjs = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjs[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adjs[v].add(w);
		E++;
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public Iterable<Integer> adj(int v) {
		return adjs[v];
	}

	public DirectedGraph reverse() {
		DirectedGraph graph = new DirectedGraph(this.V());
		for (int pointer = 0; pointer < adjs.length; pointer++) {
			for (int i : adjs[pointer]) {
				graph.addEdge(i, pointer);
			}
		}
		return graph;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < adjs.length; i++) {
			sb.append("\n" + i + " ->");
			for (int pointer : adjs[i]) {
				sb.append(pointer + "  ");
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
