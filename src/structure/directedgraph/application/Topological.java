package structure.directedgraph.application;

import java.util.Stack;

import structure.directedgraph.DirectedGraph;

public class Topological {
	private Stack<Integer> order;

	public Topological(DirectedGraph graph) {
		DirectedGraphCycle cycleCheck = new DirectedGraphCycle(graph);
		DepthFirstOrder order = new DepthFirstOrder(graph);
		if (!cycleCheck.hasCycle()) {
			this.order = order.reversePost();
		}
	}

	public Stack<Integer> getOrder() {
		return order;
	}

}
