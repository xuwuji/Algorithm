package structure.undirectedgraph.application;

import structure.undirectedgraph.BreathFirstSearch;

public class DegreesOfSeparation {

	private BreathFirstSearch search;
	private SymbolGraph graph;

	public DegreesOfSeparation(SymbolGraph graph, int source) {
		this.graph = graph;
		search = new BreathFirstSearch(graph.getGraph(), source);
	}

	public int getDegree(String name) {
		int index = graph.getIndex(name);
		return search.getDegree(index);
	}
}
