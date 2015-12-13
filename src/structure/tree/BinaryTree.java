package structure.tree;

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

	public Node deleteMin(Node pointer) {

		if (pointer.left != null) {
			pointer.left = deleteMin(pointer.left);
		} else {
			pointer = pointer.right;
		}
		return pointer;

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

	public boolean isContains(Key key) {
		if (this.find(key) == null) {
			return false;
		}
		return true;
	}

	public Node findMin(Node pointer) {

		if (pointer.left != null) {
			pointer.left = findMin(pointer.left);
		} else {
			return pointer;
		}
		return pointer;
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
			pointer.right = deleteMax(pointer.right);
		} else {
			pointer = pointer.left;
		}
		return pointer;
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
			System.out.println(node.key);
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
			System.out.println(node.toString());
			if (node.right != null) {
				queue.enque(node.right);
			}
			if (pointer.left != null) {
				queue.enque(node.left);
			}
		}

	}

	/**
	 * count the all nodes under a node
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
	 * get the maximum height from a node to its leaf nodes. A node without
	 * leaves should be 0 height,the root should be begin from 0
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
		}

		if (pointer.right == null) {
			return 1 + getMinHeight(pointer.left);
		}

		return 1 + Math.min(getMinHeight(pointer.left), getMinHeight(pointer.right));
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
	 * should return 0.
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

	public boolean isBST(Node pointer) {

		if (pointer.left != null) {
			if (pointer.left.key.compareTo(pointer.key) > 0) {
				return false;
			} else {
				isBST(pointer.left);
			}
		}
		if (pointer.right != null) {
			if (pointer.right.key.compareTo(pointer.key) < 0) {
				return false;
			} else {
				isBST(pointer.right);
			}
		}
		return true;
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
		tree.addNode(10, "j");
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

		// System.out.println(tree.find(6));
		// System.out.println(tree.root.toString());
		// System.out.println(tree.isBST(tree.root));
		System.out.println("max:" + tree.getMaxHeight(tree.root));
		System.out.println("min:" + tree.getMinHeight(tree.root));
		System.out.println(tree.getNodesCount(tree.root));
		int k = 2;
		System.out.println("the nodes on the " + k + " level:" + tree.getLevelNodesCount(k));
		System.out.println(tree.getLevelNodesCounthelper(null, 2));
	}

}
