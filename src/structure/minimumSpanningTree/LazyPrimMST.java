package structure.minimumSpanningTree;

import java.util.LinkedList;
import java.util.Queue;

import structure.priorityQueue.MinHeap;

/**
 * using the prim algorithm to find the mst
 * 
 * 1.start with the vertex 0 and greedily grow tree T
 * 
 * 2. Add to T the min weight edge with exactly one endpoint in T
 * 
 * 3.repeat until v-1 edges
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ4ÈÕ
 */
public class LazyPrimMST {

	private boolean[] marked;
	private Queue<Edge> mst;
	private MinHeap<Edge> heap;
	private double weight;

	public LazyPrimMST(EdgeWeightedGraph graph) {
		marked = new boolean[graph.V()];
		mst = new LinkedList<Edge>();
		heap = new MinHeap<Edge>();
		visit(graph, 0);
		while (!heap.isEmpty()) {
			Edge e = heap.delMin();
			int v = e.getEither();
			int w = e.getOther(v);
			// if both nodes of the edge are marked, skip this loop
			if (marked[v] && marked[w]) {
				continue;
			}
			mst.add(e);
			weight += e.getWeight();
			if (!marked[v]) {
				visit(graph, v);
			}
			if (!marked[w]) {
				visit(graph, w);
			}
		}
	}

	public void visit(EdgeWeightedGraph graph, int v) {
		marked[v] = true;
		for (Edge e : graph.adj(v)) {
			if (!marked[e.getOther(v)]) {
				heap.insert(e);
			}
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		return weight;
	}
}