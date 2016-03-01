package structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import structure.queue.Queue;

public class BinaryTree<Key extends Comparable<Key>, E> {

	private Node root;
	private Queue<Node> queue = new Queue<Node>();

	class Node {
		Key key;
		E e;
		Node left;
		Node right;

		@Override
		public String toString() {
			return "Node [key=" + key + ", e=" + e + "]";
		}

	}

	public void addNode(Key key, E e) {
		Node node = new Node();
		node.key = key;
		node.e = e;

		if (root == null) {
			root = node;
		} else {
			insertHelper(node, root);
		}

	}

	public void insertHelper(Node node, Node pointer) {
		if (node.key.compareTo(pointer.key) < 0) {
			if (pointer.left == null) {
				pointer.left = node;
			} else {
				insertHelper(node, pointer.left);
			}
		} else {
			if (pointer.right == null) {
				pointer.right = node;
			} else {
				insertHelper(node, pointer.right);
			}
		}
	}

	public void delete(Key key) {
		root = deleteHelper(key, root);
	}

	public Node deleteHelper(Key key, Node pointer) {
		if (key.compareTo(pointer.key) > 0) {
			pointer.right = deleteHelper(key, pointer.right);
		} else if (key.compareTo(pointer.key) < 0) {
			pointer.left = deleteHelper(key, pointer.left);
		} else if (key.compareTo(pointer.key) == 0) {
			if (pointer.left == null && pointer.right == null) {
				pointer = null;
			} else if (pointer.left == null) {
				pointer = pointer.right;
			} else if (pointer.right == null) {
				pointer = pointer.left;
			} else {
				Node temp = pointer;
				Node n = pointer.right;
				while (n.left != null) {
					n = n.left;
				}
				pointer = n;
				pointer = n;
				pointer.right = deleteMin(temp.right);
				pointer.left = temp.left;
			}
		}
		return pointer;
	}

	public Node deleteMax(Node pointer) {

		if (pointer.right != null) {
			return deleteMax(pointer.right);
		} else {
			pointer = pointer.left;
		}
		return pointer;
	}

	public Node deleteMin(Node pointer) {

		if (pointer.left != null) {
			return deleteMin(pointer.left);
		} else {
			pointer = pointer.right;
		}
		return pointer;

	}

	public boolean isContains(Key key) {
		if (this.find(key) == null) {
			return false;
		}
		return true;
	}

	public E find(Key key) {
		Node pointer = root;
		while (pointer != null) {
			if (key.equals(pointer.key)) {
				return pointer.e;
			} else if (key.compareTo(pointer.key) < 0) {
				pointer = pointer.left;
			} else {
				pointer = pointer.right;
			}
		}
		return null;
	}

	public E findRecursively(Node pointer, Key key) {
		if (pointer == null) {
			return null;
		}
		if (pointer.key == key) {
			return pointer.e;
		} else if (pointer.key.compareTo(key) > 0) {
			return findRecursively(pointer.left, key);
		} else {
			return findRecursively(pointer.right, key);
		}
	}

	public Node findNode(Key key) {
		Node pointer = root;
		while (pointer != null) {
			if (key.equals(pointer.key)) {
				return pointer;
			} else if (key.compareTo(pointer.key) < 0) {
				pointer = pointer.left;
			} else {
				pointer = pointer.right;
			}
		}
		return null;
	}

	public Node findNodeRecursively(Node pointer, Key key) {
		if (pointer == null) {
			return null;
		}
		if (pointer.key == key) {
			return pointer;
		} else if (pointer.key.compareTo(key) > 0) {
			return findNodeRecursively(pointer.left, key);
		} else {
			return findNodeRecursively(pointer.right, key);
		}
	}

	public Node findMin(Node pointer) {
		if (pointer.left != null) {
			return findMin(pointer.left);
		} else {
			return pointer;
		}
	}

	public Node findMax(Node pointer) {
		if (pointer.right != null) {
			return findMax(pointer.right);
		} else {
			return pointer;
		}
	}

	/**
	 * in-order:left,root,right
	 * 
	 * @param pointer
	 */
	public void inOrderTraverse(Node pointer) {
		if (pointer != null) {
			inOrderTraverse(pointer.left);
			System.out.println(pointer.toString());
			inOrderTraverse(pointer.right);
		}
	}

	/**
	 * pre-order:root, left, right
	 * 
	 * @param pointer
	 */
	public void PreOrderTraverse(Node pointer) {
		if (pointer != null) {
			System.out.println(pointer.key);
			PreOrderTraverse(pointer.left);
			PreOrderTraverse(pointer.right);
		}
	}

	/**
	 * post-order:left,right,root
	 * 
	 * @param pointer
	 */
	public void PostOrderTraverse(Node pointer) {
		if (pointer != null) {
			PostOrderTraverse(pointer.left);
			PostOrderTraverse(pointer.right);
			System.out.println(pointer.key);
		}
	}

	/**
	 * level-order:up to down, left to right
	 * 
	 * @param pointer
	 */
	public void LevelOrderTraverse(Node pointer) {
		if (queue.isEmpty()) {
			queue.enque(pointer);
		}

		while (!queue.isEmpty()) {
			Node node = queue.deque();
			System.out.println(node);
			if (node.left != null) {
				queue.enque(node.left);
			}
			if (pointer.right != null) {
				queue.enque(node.right);
			}
		}

	}

	/**
	 * reverse-level-order:up to down, right to left
	 * 
	 * @param pointer
	 */
	public void ReverseLevelOrderTraverse(Node pointer) {
		if (queue.isEmpty()) {
			queue.enque(pointer);
		}

		while (!queue.isEmpty()) {
			Node node = queue.deque();
			System.out.println(node);
			if (node.right != null) {
				queue.enque(node.right);
			}
			if (pointer.left != null) {
				queue.enque(node.left);
			}
		}

	}

	public void PreOrderWithoutRecursive(Node pointer) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(pointer);
		while (!stack.isEmpty()) {
			pointer = stack.pop();
			System.out.println(pointer);
			// pre-order:current,left,right
			// stack is first-in-last-out
			// so the right push to the stack first
			if (pointer.right != null) {
				stack.push(pointer.right);
			}
			if (pointer.left != null) {
				stack.push(pointer.left);
			}
		}
	}

	public void InOrderWithoutRecursive(Node pointer) {
		Stack<Node> stack = new Stack();
		if (pointer == null) {
			return;
		}
		while (pointer != null || !stack.isEmpty()) {
			while (pointer != null) {
				stack.push(pointer);
				pointer = pointer.left;
			}
			pointer = stack.pop();
			System.out.println(pointer);
			pointer = pointer.right;
		}
	}

	public void PostOrderWithOutRecursive(Node pointer) {
		Stack<Node> stack = new Stack();
		LinkedList<Node> result = new LinkedList<>();
		stack.push(pointer);
		while (!stack.isEmpty()) {
			pointer = stack.pop();
			result.addFirst(pointer);
			if (pointer.left != null) {
				stack.push(pointer.left);
			}
			if (pointer.right != null) {
				stack.push(pointer.right);
			}
		}
		for (Node n : result) {
			System.out.println(n);
		}
	}

	/**
	 * put nodes in a same level into one same list
	 * 
	 * @param pointer
	 * @return
	 */
	public ArrayList<List<Node>> LevelOrderWithLevelDetail(Node pointer) {
		ArrayList<List<Node>> list = new ArrayList<List<Node>>();
		LevelOrderWithLevelDetailHelper(list, root, 0);
		return list;
	}

	public void LevelOrderWithLevelDetailHelper(ArrayList<List<Node>> list, Node pointer, int level) {
		if (pointer == null) {
			return;
		}
		if (list.size() == level) {
			list.add(level, new ArrayList<Node>());
		}
		list.get(level).add(pointer);
		LevelOrderWithLevelDetailHelper(list, pointer.left, level + 1);
		LevelOrderWithLevelDetailHelper(list, pointer.right, level + 1);

	}

	/**
	 * count the all nodes under a node,including itself
	 * 
	 * @param pointer
	 * @return
	 */
	public int getNodesCount(Node pointer) {
		if (pointer == null) {
			return 0;
		} else {
			return 1 + getNodesCount(pointer.left) + getNodesCount(pointer.right);
		}
	}

	/**
	 * return the rank by a given key
	 * 
	 * @param pointer
	 * @return
	 */
	public int rank(Key key) {

		if (key == null) {
			return 0;
		}

		return rank(key, root);
	}

	public int rank(Key key, Node pointer) {
		if (pointer == null) {
			return 0;
		}
		if (key.compareTo(pointer.key) < 0) {
			return rank(key, pointer.left);
		} else if (key.compareTo(pointer.key) > 0) {
			return getNodesCount(pointer.left) + rank(key, pointer.right);
		} else {
			return getNodesCount(pointer.left) + 1;
		}

	}

	/**
	 * get the maximum height from a node to its leaf nodes. A node without
	 * leaves should be 0 height,the root should begin from 0
	 * 
	 * @param pointer
	 * @return
	 */
	public int getMaxHeight(Node pointer) {
		if (pointer == null) {
			return -1;
		}
		return 1 + Math.max(getMaxHeight(pointer.left), getMaxHeight(pointer.right));
	}

	/**
	 * get the minimum height from a node to its leaf nodesA node without leaves
	 * should be 0 height,the root should be begin from 0
	 * 
	 * @param pointer
	 * @return
	 */
	public int getMinHeight(Node pointer) {
		if (pointer == null) {
			return -1;
		}

		if (pointer.left == null) {
			return 1 + getMinHeight(pointer.right);
		} else if (pointer.right == null) {
			return 1 + getMinHeight(pointer.left);
		} else {
			return 1 + Math.min(getMinHeight(pointer.left), getMinHeight(pointer.right));
		}
	}

	/**
	 * Get all nodes on a given level. The tree begins from level 0
	 * 
	 * @param k
	 * @return
	 */
	public int getLevelNodesCount(int k) {
		return getLevelNodesCounthelper(root, k);
	}

	/**
	 * The helper method.
	 * 
	 * The k can be seen as how many levels are checking for the pointer.
	 * 
	 * For example, (root,2) represents check the nodes under root in two
	 * levels. If the pointer is null,the it is a null node, then it should
	 * return 0. If the k=0, it means it is already on the checking level, so it
	 * should return 1.
	 * 
	 * @param pointer
	 * @param k
	 * @return
	 */
	public int getLevelNodesCounthelper(Node pointer, int k) {
		if (pointer == null || k < 0) {
			return 0;
		} else if (k == 0) {
			return 1;
		} else {
			return getLevelNodesCounthelper(pointer.left, k - 1) + getLevelNodesCounthelper(pointer.right, k - 1);

		}
	}

	public boolean isBST() {
		return isBSTHelper(root, null, null);
	}

	/**
	 * the helper method: each node should between the correct low value and the
	 * correct high value
	 * 
	 * @param pointer
	 * @param low
	 * @param high
	 * @return
	 */
	public boolean isBSTHelper(Node pointer, Key low, Key high) {
		if (pointer == null) {
			return true;
		}
		if ((low == null || pointer.key.compareTo(low) > 0) && (high == null || pointer.key.compareTo(high) < 0)
				&& isBSTHelper(pointer.left, low, pointer.key) && isBSTHelper(pointer.right, pointer.key, high)) {
			return true;
		}
		return false;
	}

	/**
	 * check whether the binary tree is balanced
	 * 
	 * balanced: the heights of two subtrees of any node never differ by more
	 * than one
	 * 
	 * @return
	 */

	public boolean isBalanced() {
		return isBalancedHelper(this.root);
	}

	public boolean isBalancedHelper(Node pointer) {
		if (pointer == null) {
			return true;
		}
		int differ = Math.abs(this.getMaxHeight(pointer.left) - this.getMaxHeight(pointer.right));
		if (differ > 1) {
			return false;
		} else {
			return isBalancedHelper(pointer.left) && isBalancedHelper(pointer.right);
		}
	}

	public Node invertTree(Node root) {
		if (root == null) {
			return root;
		}
		Node temp = root.right;
		root.right = root.left;
		root.left = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	public void getSymmetric(Node pointer) {

		if (pointer != null) {
			System.out.println(pointer.toString());
			Node temp = pointer.left;
			pointer.left = pointer.right;
			pointer.right = temp;
			getSymmetric(pointer.left);
			getSymmetric(pointer.right);
		}
	}

	/**
	 * can be used in normal binary tree
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public Node FindLowestAncestorInBT(Node root, Node p, Node q) {
		if (root == null || p == root || q == root) {
			return root;
		}

		Node left = FindLowestAncestorInBT(root.left, p, q);
		Node right = FindLowestAncestorInBT(root.right, p, q);

		if (left != null && right != null) {
			return root;
		} else {
			if (left != null) {
				return left;
			} else {
				return right;
			}
		}
	}

	/**
	 * only used in BST
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public Node FindLowestAncestorInBST(Node root, Node p, Node q) {
		if (root == null) {
			return null;
		}
		while (root != null) {
			if (root.key.compareTo(p.key) > 0 && root.key.compareTo(q.key) > 0) {
				root = root.left;
			} else if (root.key.compareTo(p.key) < 0 && root.key.compareTo(q.key) < 0) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	public boolean hasPathSum(Node root, int sum) {

		if (root == null) {
			return false;
		}

		sum = sum - Integer.valueOf(String.valueOf(root.key));

		if (sum == 0 && root.left == null && root.right == null) {
			return true;
		}

		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

	}

	/**
	 * get all paths from the root to leaves
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths(Node root) {
		List<String> list = new ArrayList<String>();
		if (root == null) {
			return list;
		}
		helper(list, "", root);
		return list;
	}

	public void helper(List<String> list, String string, Node pointer) {
		if (pointer == null) {
			return;
		}
		if (pointer.left == null && pointer.right == null) {
			string = string + pointer.key;
			list.add(string);
		} else {
			string += pointer.key + "->";
			if (pointer.left != null) {
				helper(list, string, pointer.left);
			}
			if (pointer.right != null) {
				helper(list, string, pointer.right);
			}
		}
	}

	public int LongestPath(Node root) {
		if (root == null) {
			return -1;
		}

		int maxLeft = 0;
		int maxRight = 0;

		maxLeft = 1 + getMaxHeight(root.left);
		maxRight = 1 + getMaxHeight(root.right);

		int lLongPath = LongestPath(root.left);
		int rLongPath = LongestPath(root.right);

		return Math.max(Math.max(lLongPath, rLongPath), maxLeft + maxRight);
	}

	public int PathBetweenRootToNode(Node root, Node p) {
		if (root == null) {
			return -1;
		}

		if (root == p) {
			return 0;
		}

		if (root.left == null) {
			return 1 + PathBetweenRootToNode(root.right, p);
		}

		if (root.right == null) {
			return 1 + PathBetweenRootToNode(root.left, p);
		}

		return 1 + Math.min(PathBetweenRootToNode(root.left, p), PathBetweenRootToNode(root.right, p));

	}

	public int getShortestPathBetweenTwoNodes(Node root, Node p, Node q) {
		Node ancestor = FindLowestAncestorInBT(root, p, q);
		return PathBetweenRootToNode(root, p) + PathBetweenRootToNode(root, q);
	}

	/**
	 * return all nodes between key1 and key2 (not including)
	 * 
	 * @param key1
	 * @param key2
	 * @return
	 */
	public List<Node> rangeSearch(Key key1, Key key2) {
		List<Node> list = new ArrayList<Node>();
		list = rangeSearch(list, root, key1, key2);
		return list;

	}

	public List<Node> rangeSearch(List<Node> list, Node pointer, Key key1, Key key2) {
		if (pointer == null) {
			return list;
		}

		if (pointer.key.compareTo(key2) < 0 && pointer.key.compareTo(key1) > 0) {
			list.add(pointer);
		}
		rangeSearch(list, pointer.left, key1, key2);
		rangeSearch(list, pointer.right, key1, key2);
		return list;
	}

	/**
	 * count the number of nodes between key1 and key2
	 * 
	 * @param key1
	 * @return
	 */
	public int countRange(Key key1, Key key2) {
		List<Node> list = new ArrayList<Node>();
		list = rangeSearch(key1, key2);
		return list.size();
	}

	public static void main(String[] args) {
		BinaryTree<Integer, String> tree = new BinaryTree<Integer, String>();
		tree.addNode(6, "f");
		tree.addNode(7, "g");
		// System.out.println(tree.root.value);
		// System.out.println(tree.root.right.value);
		tree.addNode(8, "h");
		tree.addNode(3, "c");
		tree.addNode(4, "d");
		tree.addNode(1, "a");
		tree.addNode(2, "b");
		tree.addNode(5, "e");
		tree.addNode(9, "i");
		// tree.addNode(10, "j");
		// tree.delete(9, tree.root);
		// tree.delete(3);
		// tree.root.left.left = tree.root.left.left.right;
		// tree.deleteMin(tree.root);
		// tree.deleteMin(tree.root);
		// tree.inOrderTraverse(tree.root);
		// tree.PreOrderTraverse(tree.root);
		// tree.PostOrderTraverse(tree.root);
		// tree.LevelOrderTraverse(tree.root);
		// tree.ReverseLevelOrderTraverse(tree.root);

		System.out.println(tree.findNode(5).left);
		// System.out.println(tree.root.toString());
		// System.out.println((tree.root));
		System.out.println("min of the tree:" + tree.findMin(tree.root));
		System.out.println("max of the tree:" + tree.findMax(tree.root));
		System.out.println("recursively find a node by its key:" + tree.findNodeRecursively(tree.root, 2));
		System.out.println("max height:" + tree.getMaxHeight(tree.root));
		System.out.println("min height:" + tree.getMinHeight(tree.root));
		System.out.println("----pre-order without recursive--------");
		tree.PreOrderWithoutRecursive(tree.root);
		System.out.println("----in-order without recursive--------");
		tree.InOrderWithoutRecursive(tree.root);
		System.out.println("----post-order without recursive--------");
		tree.PostOrderWithOutRecursive(tree.root);
		System.out.println("---- level-order traverse ------");
		tree.LevelOrderTraverse(tree.root);
		System.out.println("---- level-order with detail -----");
		ArrayList listA = new ArrayList();
		listA = tree.LevelOrderWithLevelDetail(tree.root);
		for (int i = 0; i < listA.size(); i++) {
			System.out.println(i + " th level:");
			System.out.println(listA.get(i));
		}

		System.out.println("nodes number under root(including):" + tree.getNodesCount(tree.root));
		int k = 2;
		System.out.println("the number of nodes on the " + k + "th level:" + tree.getLevelNodesCount(k));

		// tree.invertTree(tree.root);
		// tree.LevelOrderTraverse(tree.root);
		// tree.getSymmetric(tree.root);
		// tree.LevelOrderTraverse(tree.root);
		System.out.println("tree has path with the sum: " + tree.hasPathSum(tree.root, 18));
		System.out.println("--------  all paths from root to leaves  ------");
		List<String> list = tree.binaryTreePaths(tree.root);
		for (String s : list) {
			System.out.println(s);
		}

		// System.out.println(tree.LongestPath(tree.root.right.right.right));
		// System.out.println(tree.LongestPath(tree.root.right.right.right));
		System.out.println(tree.PathBetweenRootToNode(tree.root, tree.root.left.right));
		System.out.println(
				tree.getShortestPathBetweenTwoNodes(tree.root, tree.root.left.right, tree.root.right.right.right));
		System.out.println(tree.countRange(2, 4));
		System.out.println(tree.rank(1));
		System.out.println("the tree is balanced:" + tree.isBalanced());
		System.out.println("this is a BST:" + tree.isBST());
	}

}
