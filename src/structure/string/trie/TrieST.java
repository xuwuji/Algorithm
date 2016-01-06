package structure.string.trie;

import java.util.LinkedList;
import java.util.Queue;

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
	 * put a particular position of key under a pointer node and put the value
	 * under the leaf node
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

		// it gets to the leaf node
		if (position == key.length()) {
			// if (pointer.value == null) {
			// N++;
			// }
			pointer.value = value;
			return pointer;
		}

		// get the character of this position
		char c = key.charAt(position);

		// put this character under the pointer and recursively do this process
		pointer.next[c] = put(pointer.next[c], key, value, position + 1);

		return pointer;
	}

	public Value get(String key) {
		Node node = get(root, key, 0);
		if (node == null) {
			return null;
		} else {
			return (Value) node.value;
		}
	}

	private Node get(Node pointer, String key, int position) {
		if (pointer == null) {
			return null;
		}
		if (position == key.length()) {
			return pointer;
		}
		return get(pointer.next[key.charAt(position)], key, position + 1);
	}

	public boolean contains(String key) {
		return get(key) != null;
	}

	public void delete(String key) {
		delete(root, key, 0);
	}

	public Node delete(Node pointer, String key, int d) {
		if (pointer == null) {
			return null;
		}

		/**
		 * find the node should be deleted and set the value to that leaf to
		 * null
		 */
		if (d == key.length()) {
			pointer.value = null;
		} else {
			pointer.next[key.charAt(d)] = delete(pointer.next[key.charAt(d)], key, d + 1);
		}

		if (pointer.value != null) {
			return pointer;
		}

		/**
		 * at here, if this pointer is the leaf node, delete it and go up and
		 * delete its parent node
		 * 
		 * if it is not the leaf node, means it is the prefix of other words, so
		 * just return it because we have already set its value to null above
		 */

		for (int i = 0; i < R; i++) {
			if (pointer.next[i] != null) {
				return pointer;
			}
		}
		// after the check, we know it is the leaf node, so we just set it to
		// null and return it, then check its parent
		return null;

	}

	/**
	 * Returns all keys in the symbol table as an <tt>Iterable</tt>. To iterate
	 * over all of the keys in the symbol table named <tt>st</tt>, use the
	 * foreach notation: <tt>for (Key key : st.keys())</tt>.
	 * 
	 * @return all keys in the sybol table as an <tt>Iterable</tt>
	 */
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	/**
	 * Returns all of the keys in the set that start with <tt>prefix</tt>.
	 * 
	 * @param prefix
	 *            the prefix
	 * @return all of the keys in the set that start with <tt>prefix</tt>, as an
	 *         iterable
	 */
	public Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> results = new LinkedList<String>();
		Node x = get(root, prefix, 0);
		collect(x, new StringBuilder(prefix), results);
		return results;
	}

	private void collect(Node pointer, StringBuilder prefix, Queue<String> results) {
		if (pointer == null)
			return;
		// if the pointer's value is null, so it is a key, then add it to the
		// result
		if (pointer.value != null) {
			results.add(prefix.toString());
		}
		/**
		 * check each child of this pointer
		 */
		for (char c = 0; c < R; c++) {
			// 1.append the child to current prefix
			prefix.append(c);
			// 2. recursively call the method to check pointer's child is a key
			// or not
			collect(pointer.next[c], prefix, results);
			// 3. delete the character that just append and check next character
			// of current node
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}

	/**
	 * Returns all of the keys in the symbol table that match <tt>pattern</tt>,
	 * where . symbol is treated as a wildcard character.
	 * 
	 * @param pattern
	 *            the pattern
	 * @return all of the keys in the symbol table that match <tt>pattern</tt>,
	 *         as an iterable, where . is treated as a wildcard character.
	 */
	public Iterable<String> keysThatMatch(String pattern) {
		Queue<String> results = new LinkedList<String>();
		collect(root, new StringBuilder(), pattern, results);
		return results;
	}

	private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results) {
		if (x == null)
			return;
		int d = prefix.length();
		/**
		 * if current node matches the pattern length and its value is null, so
		 * it matches the pattern, so add it the result
		 */
		if (d == pattern.length() && x.value != null) {
			results.add(prefix.toString());
		}
		// if the value is null, so it is not a key so just return
		if (d == pattern.length())
			return;
		char c = pattern.charAt(d);
		// treat . as a wildcard character
		if (c == '.') {
			for (char ch = 0; ch < R; ch++) {
				prefix.append(ch);
				collect(x.next[ch], prefix, pattern, results);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		} else {
			prefix.append(c);
			collect(x.next[c], prefix, pattern, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
}
