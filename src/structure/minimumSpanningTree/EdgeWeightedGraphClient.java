package structure.minimumSpanningTree;

public class EdgeWeightedGraphClient {
	public static void main(String[] args) {

		EdgeWeightedGraph G = new EdgeWeightedGraph(10);
		G.addEdge(new Edge(0, 7, 0.16));
		G.addEdge(new Edge(2, 3, 0.17));
		G.addEdge(new Edge(1, 7, 0.19));
		G.addEdge(new Edge(0, 2, 0.26));
		G.addEdge(new Edge(5, 7, 0.28));
		G.addEdge(new Edge(4, 5, 0.35));
		G.addEdge(new Edge(6, 2, 0.40));
		G.addEdge(new Edge(0, 3, 0.10));
		G.addEdge(new Edge(3, 4, 0.2));
		G.addEdge(new Edge(3, 5, 0.2));
		KruskalMST mst = new KruskalMST(G);
		LazyPrimMST lpmst = new LazyPrimMST(G);
		System.out.printf("kruskal---------------------------------");
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}
		System.out.printf("%.5f\n", mst.weight());
		System.out.printf("lazy prim ------------------------------");
		for (Edge e : lpmst.edges()) {
			System.out.println(e);
		}
		System.out.printf("%.5f\n", lpmst.weight());
	}
}
