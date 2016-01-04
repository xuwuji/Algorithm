package structure.shorestPath;

import java.util.Stack;

import structure.priorityQueue.IndexMinPQ;
import structure.priorityQueue.MinHeap;

/**
 * from one source, find shortest path to all other vertices
 * 
 * using the dijkstra algorithm
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ4ÈÕ
 */
public class ShortestPathTree {

	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> heap;

	public ShortestPathTree(EdgeWeightedDirectedGraph graph, int source) {
		edgeTo = new DirectedEdge[graph.V()];
		distTo = new double[graph.V()];
		heap = new IndexMinPQ<Double>(graph.V());
		for (int i = 0; i < graph.V(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[source] = 0.0;
		heap.insert(source, 0.0);
		while (!heap.isEmpty()) {
			relax(graph, heap.delMin());
		}
	}

	private void relax(EdgeWeightedDirectedGraph graph, int v) {
		for (DirectedEdge e : graph.adj(v)) {
			int w = e.to();
			// update the weight of w if the current dist of w is greater
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (heap.contains(w)) {
					heap.changeKey(w, distTo[w]);
				} else {
					heap.insert(w, distTo[w]);
				}
			}
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	/**
	 * Returns true if there is a path from the source vertex <tt>s</tt> to
	 * vertex <tt>v</tt>.
	 *
	 * @param v
	 *            the destination vertex
	 * @return <tt>true</tt> if there is a path from the source vertex
	 *         <tt>s</tt> to vertex <tt>v</tt>; <tt>false</tt> otherwise
	 */
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	/**
	 * Returns a shortest path from the source vertex <tt>s</tt> to vertex
	 * <tt>v</tt>.
	 *
	 * @param v
	 *            the destination vertex
	 * @return a shortest path from the source vertex <tt>s</tt> to vertex
	 *         <tt>v</tt> as an iterable of edges, and <tt>null</tt> if no such
	 *         path
	 */
	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}
}
