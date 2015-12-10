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

	public void delete(Key key) {
		Node pointer = root;

		if (key.compareTo(pointer.key) < 0) {

		}

		if (key == pointer.key) {
			if (pointer.left == null && pointer.right == null) {

			}
		}

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

	public void inOrderTraverse(Node pointer) {
		if (pointer != null) {
			inOrderTraverse(pointer.left);
			System.out.println(pointer.key);
			inOrderTraverse(pointer.right);
		}
	}

	public void PreOrderTraverse(Node pointer) {
		if (pointer != null) {
			System.out.println(pointer.key);
			PreOrderTraverse(pointer.left);
			PreOrderTraverse(pointer.right);
		}
	}

	public void PostOrderTraverse(Node pointer) {
		if (pointer != null) {
			PostOrderTraverse(pointer.left);
			PostOrderTraverse(pointer.right);
			System.out.println(pointer.key);
		}
	}

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
		// tree.inOrderTraverse(tree.root);
		// tree.PreOrderTraverse(tree.root);
		// tree.PostOrderTraverse(tree.root);
		// tree.LevelOrderTraverse(tree.root);
		tree.ReverseLevelOrderTraverse(tree.root);
		System.out.println(tree.find(6));
	}

}
