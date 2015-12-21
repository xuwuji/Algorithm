package structure.tree;

/**
 * A BST such that:
 * 
 * ・No node has two red links connected to it.
 * 
 * ・Every path from root to null link has the same number of black links.
 * 
 * ・Red links lean left.
 * 
 * The longest path (which is the longest red path) will not be twice larger
 * than the shortest path (which is the shortest black path)
 * 
 * @author xuwuji
 * @time Dec 21, 2015
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private Node root;
	private static final boolean RED = Boolean.TRUE;
	private static final boolean BLACK = Boolean.FALSE;

	class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		// this is the link connected to its parent
		boolean color;

		public Node(Key key, Value value, boolean color) {
			super();
			this.key = key;
			this.value = value;
			this.color = color;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
	}

	/**
	 * Search the node based on a key
	 * 
	 * @param key
	 * @return
	 */
	public Value search(Key key) {
		Node pointer = root;
		while (pointer.key != key) {
			if (pointer.key.compareTo(key) > 0) {
				pointer = pointer.right;
			} else if (pointer.key.compareTo(key) < 0) {
				pointer = pointer.left;
			} else {
				return pointer.value;
			}
		}
		return null;
	}

	/**
	 * check the link of a node which connected to its' parent is red or not
	 * 
	 * @param pointer
	 * @return
	 */
	public boolean isRed(Node pointer) {
		if (pointer == null) {
			return false;
		}
		return pointer.color == RED;
	}

	/**
	 * rotate locally, when the red link is in the right side
	 * 
	 * @param pointer
	 * @return
	 */
	public Node rotateLeft(Node pointer) {
		Node x = pointer.right;
		pointer.right = x.left;
		x.left = pointer;
		x.color = pointer.color;
		pointer.color = RED;
		return x;
	}

	/**
	 * rotate locally, when the red link is in the right side, rotate it to
	 * right temporarily
	 * 
	 * @param pointer
	 * @return
	 */
	public Node rotateRight(Node pointer) {
		Node x = pointer.left;
		pointer.left = x.right;
		x.right = pointer;
		x.color = pointer.color;
		pointer.color = RED;
		return x;
	}

	public void flipColors(Node pointer) {
		pointer.color = RED;
		pointer.left.color = BLACK;
		pointer.right.color = BLACK;
	}

	public void put(Key key, Value value) {
		if (key == null) {
			throw new NullPointerException("first argument to put() is null");
		}

		Node newNode = new Node(key, value, RED);
		root = put(root, newNode);
		root.color = BLACK;
	}

	// insert the key-value pair in the subtree rooted at pointer
	private Node put(Node pointer, Node newNode) {
		if (pointer == null) {
			return newNode;
		}
		int cmp = newNode.key.compareTo(pointer.key);
		if (cmp < 0) {
			pointer.left = put(pointer.left, newNode);
		} else if (cmp > 0) {
			pointer.right = put(pointer.right, newNode);
		} else {
			pointer.value = newNode.value;
		}

		// fix-up any right-leaning links
		if (isRed(pointer.right) && !isRed(pointer.left))
			pointer = rotateLeft(pointer);
		if (isRed(pointer.left) && isRed(pointer.left.left))
			pointer = rotateRight(pointer);
		if (isRed(pointer.left) && isRed(pointer.right))
			flipColors(pointer);

		return pointer;
	}

}
