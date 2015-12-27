package structure.graph;

import java.util.LinkedList;

public class UndirectedGraph {

	private LinkedList<Integer>[] adjs;
	private int E;
	private int V;

	public UndirectedGraph(int V) {
		adjs = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjs[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		E++;
		adjs[v].add(w);
		adjs[w].add(v);
	}

	/**
	 * return all vertices adjacent to v
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adjs[v];

	}

	/**
	 * 
	 * @return number of vertices
	 */
	public int V() {
		return adjs.length;
	}

	/**
	 * 
	 * @return number of edges
	 */
	public int E() {
		return E;
	}

	public static int degree(UndirectedGraph graph, int v) {
		int degree = 0;
		for (int i : graph.adjs[v]) {
			degree++;
		}
		return degree;
	}

	public static int maxDegree(UndirectedGraph graph) {
		int max = 0;
		for (int i = 0; i < graph.adjs.length; i++) {
			if (degree(graph, i) >= max) {
				max = degree(graph, i);
			}
		}
		return max;
	}

	public static double avergeDegree(UndirectedGraph graph) {
		return 2.0 * graph.E() / graph.V();
	}

	public static int numberOfSelfLoop(UndirectedGraph graph) {
		int count = 0;
		for (int v = 0; v < graph.adjs.length; v++) {
			for (int w : graph.adjs[v]) {
				if (v == w) {
					count++;
				}
			}
		}
		return count / 2;
	}

}
