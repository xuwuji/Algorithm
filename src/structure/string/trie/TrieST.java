package structure.string.trie;

/**
 * this is a R way trie
 * 
 * @author wupointeru
 * @time 2016Äê1ÔÂ5ÈÕ
 */
public class TrieST<Value> {
	private static final int R = 256;
	private Node root = new Node();
	private int N; // number of keys in trie

	public static class Node {
		private Object value;
		private Node[] next = new Node[R];
	}

	public void put(String key, Value value) {
		if (value == null)
			delete(key);
		else
			root = put(root, key, value, 0);
	}

	/**
	 * put a particular position of key and value under a pointer node
	 * 
	 * @param pointer
	 * @param key
	 * @param value
	 * @param position
	 * @return
	 */
	private Node put(Node pointer, String key, Value value, int position) {
		if (pointer == null) {
			pointer = new Node();
		}

		if (position == key.length()) {
			//if (pointer.value == null) {
			//	N++;
			//}
			pointer.value = value;
			return pointer;
		}

		// get the character of this position
		char c = key.charAt(position);

		// put this character under the pointer and recursively do this process
		pointer.next[c] = put(pointer.next[c], key, value, position + 1);

		return pointer;
	}

	public void delete(String key) {

	}

	public Value get(String key) {
		return null;
	}

}
