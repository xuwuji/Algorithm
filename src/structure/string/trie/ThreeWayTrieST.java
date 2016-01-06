package structure.string.trie;

/**
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ6ÈÕ
 */
public class ThreeWayTrieST<Value> {
	private Node root;

	class Node {
		char c;
		Object value;
		Node left, right, middle;
	}

	public void put(String key, Value value) {
		root = put(root, key, value, 0);
	}

	public Node put(Node pointer, String key, Value value, int d) {

		char c = key.charAt(d);

		if (pointer == null) {
			pointer = new Node();
			pointer.c = c;
		}

		// if it is smaller than current node,put it to the left
		/**
		 * because in the three way trie, the nodes dont share the common prefix
		 * node, so the d should not be d+1
		 */
		if (c < pointer.c) {
			pointer.left = put(pointer.left, key, value, d);
		}
		// if it is bigger than current node,put it to the right
		else if (c > pointer.c) {
			pointer.right = put(pointer.right, key, value, d);
		}
		// if it is equal to current node and it is not finished, put it the
		// middle and continue
		else if (d < key.length() - 1) {
			pointer.middle = put(pointer.middle, key, value, d + 1);
		}
		// if it is equal to current node and it is finished, then finish the
		// process
		else {
			pointer.value = value;
		}
		return pointer;
	}
}
