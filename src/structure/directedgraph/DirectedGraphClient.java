package structure.directedgraph;

import structure.directedgraph.application.StronglyConnectedComponents;
import structure.directedgraph.application.Topological;

public class DirectedGraphClient {

	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(13);
		graph.addEdge(0, 2);
		graph.addEdge(0, 6);
		graph.addEdge(1, 0);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 11);
		graph.addEdge(5, 0);
		graph.addEdge(5, 3);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		graph.addEdge(8, 7);
		graph.addEdge(9, 6);
		graph.addEdge(9, 8);
		graph.addEdge(9, 12);
		graph.addEdge(10, 9);
		graph.addEdge(11, 9);
		graph.addEdge(12, 10);
		graph.addEdge(12, 11);
		graph.toString();
		DirectedGraph reverseGraph = graph.reverse();
		StronglyConnectedComponents scc = new StronglyConnectedComponents(reverseGraph);
		scc.toString();
		Topological tp = new Topological(reverseGraph);
		System.out.println(tp.getOrder().toString());
	}

}
