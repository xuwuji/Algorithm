package structure.minimumSpanningTree;

import java.util.LinkedList;
import java.util.Queue;

import structure.priorityQueue.MinHeap;
import structure.unionFind.UF;

/**
 * Using the Kruskal Algorithm to get the MST
 * 
 * @author xuwuji
 * @time Jan 1, 2016
 */
public class KruskalMST {
	private Queue<Edge> mst = new LinkedList<Edge>();
	private double weight;

	public KruskalMST(EdgeWeightedGraph graph) {
		MinHeap<Edge> heap = new MinHeap<Edge>();
		for (Edge e : graph.edges()) {
			heap.insert(e);
		}
		UF uf = new UF(graph.V());
		while (!heap.isEmpty() && mst.size() < graph.V() - 1) {
			Edge e = heap.delMin();
			int v = e.getEither();
			int w = e.getOther(v);
			if (!uf.connected(v, w)) {
				uf.union(v, w);
				mst.add(e);
				weight += e.getWeight();
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
