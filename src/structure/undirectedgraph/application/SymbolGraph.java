package structure.undirectedgraph.application;

import java.util.HashMap;

import structure.undirectedgraph.UndirectedGraph;

public class SymbolGraph {

	// name <-> index
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	// index <-> name
	private String[] index;
	private UndirectedGraph graph;

	public void addEdge(String v, String w) {
		if (!constainsKey(v)) {
			index[map.size()] = v;
			map.put(v, map.size());

		}
		if (!constainsKey(w)) {
			index[map.size()] = w;
			map.put(w, map.size());
		}
		graph.addEdge(getIndex(v), getIndex(w));
	}

	public boolean constainsKey(String name) {
		return map.containsKey(name);
	}

	public int getIndex(String name) {
		if (constainsKey(name)) {
			return map.get(name);
		}
		return -1;
	}

	public String getKey(int i) {
		return index[i];
	}

	public UndirectedGraph getGraph() {
		return graph;
	}
}
