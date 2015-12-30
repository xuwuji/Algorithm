package structure.directedgraph.application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import structure.directedgraph.DirectedGraph;

/**
 * The <tt>DepthFirstOrder</tt> class represents a data type for determining
 * depth-first search ordering of the vertices in a digraph or edge-weighted
 * digraph, including preorder, postorder, and reverse postorder.
 * 
 * @author wuxu
 * @time 2015��12��30��
 */
public class DepthFirstOrder {
	private boolean[] marked;
	private Queue<Integer> preOrder;
	private Queue<Integer> postOrder;
	private Stack<Integer> reversePostOrder;

	public DepthFirstOrder(DirectedGraph graph) {
		marked = new boolean[graph.V()];
		preOrder = new LinkedList<Integer>();
		postOrder = new LinkedList<Integer>();
		reversePostOrder = new Stack<Integer>();
		// 由于可能并不是所有的点都是连通的，所以每个点都要check一下
		for (int i = 0; i < graph.V(); i++) {
			if (!marked[i]) {
				dfs(graph, i);
			}
		}
	}

	public void dfs(DirectedGraph graph, int v) {
		marked[v] = true;
		// 相当于每次在进行下一次递归或者说找其下一个节点前
		// preOrder先入队，即preOrder的顺序总是从“头”到“尾”
		preOrder.add(v);
		// 进行递归操作
		for (int i : graph.adj(v)) {
			if (!marked[i]) {
				dfs(graph, i);
			}
		}
		// postOrder是每条路径上越在结尾的节点越放在队列的最前端
		// 所以在上述递归后，若一个节点没有相邻的节点了，则说明在这条path上面，这个节点已经是尾了
		// 所以将此节点入队，结束此次递归，返回到上一个节点
		// 同样道理，在上一个节点处，若上一个节点还有其他相邻节点，处继续递归，没有的话，就结束for循环块
		// 把上一个节点一样放入队中
		postOrder.add(v);
		// 通过栈的性质，将上述的postOrder翻转，输出的时候就相当于把postOrder的队列顺序变了
		reversePostOrder.push(v);
	}

	public Iterable<Integer> pre() {
		return preOrder;
	}

	public Iterable<Integer> post() {
		return postOrder;
	}

	public Stack<Integer> reversePost() {
		return reversePostOrder;
	}

}
