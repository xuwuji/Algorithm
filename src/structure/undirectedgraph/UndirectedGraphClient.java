package structure.undirectedgraph;

import java.util.Stack;

import structure.undirectedgraph.application.BipartiteGraph;
import structure.undirectedgraph.application.CycleGraphCheck;

public class UndirectedGraphClient {

	public static void main(String args[]) {
		UndirectedGraph graph = new UndirectedGraph(6);
		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		// graph.addEdge(0, 5);
		// graph.addEdge(1, 2);
		// graph.addEdge(2, 4);
		graph.addEdge(3, 2);
		// graph.addEdge(3, 4);
		// graph.addEdge(3, 5);
		System.out.println(graph.V());
		DepthFirstSearch search = new DepthFirstSearch(graph, 0);
		System.out.println(search.connected(4));
		search.DisplayMarked();
		search.DisplayedgeTo();
		Stack<Integer> path = search.path(3);
		System.out.println("\n");
		while (!path.isEmpty()) {
			System.out.print(path.pop());
		}
		System.out.println("\n");
		System.out.println("graph has cycle:" + CycleGraphCheck.hasCycle(graph));
		System.out.println("graph is bipartite:" + BipartiteGraph.isBipartite(graph));
	}
}
