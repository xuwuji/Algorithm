package structure.directedgraph.application;

import java.util.LinkedList;
import java.util.Queue;

import structure.directedgraph.DirectedGraph;

/**
 * The <tt>DepthFirstOrder</tt> class represents a data type for determining
 * depth-first search ordering of the vertices in a digraph or edge-weighted
 * digraph, including preorder, postorder, and reverse postorder.
 * 
 * @author wuxu
 * @time 2015Äê12ÔÂ30ÈÕ
 */
public class DepthFirstOrder {
	private boolean[] marked;
	private Queue<Integer> preOrder;
	private Queue<Integer> postOrder;

	public DepthFirstOrder(DirectedGraph graph) {
		marked = new boolean[graph.V()];
		preOrder = new LinkedList<Integer>();
		postOrder = new LinkedList<Integer>();
	}

	public void dfs(DirectedGraph graph, int v) {
		marked[v] = true;
		preOrder.add(v);
		while(preOrder){
			
		}
	}

}
