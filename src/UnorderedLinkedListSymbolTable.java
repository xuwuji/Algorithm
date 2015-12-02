/*
 * Used for key-value mapping
 * 1.values are not null
 * 2.get() return null if key not present
 * 3.put() overwrites old value with the new value
 * 4.unordered linked list structure
 */
public class UnorderedLinkedListSymbolTable<Key, Value> {
	private Node head;
	private int N;

	class Node {
		private Key key;
		private Value value;
		private Node next;
	}

	/*
	 * put k-v into the table
	 */
	public void put(Key key, Value value) {

		if (value == null) {
			delete(key);
			return;
		}
		while (head != null) {
			if (key.equals(head.key)) {
				head.value = value;
			}
			head = head.next;
		}
		Node node = new Node();
		node.key = key;
		node.value = value;
		node.next = head;
		head = node;
	}

	public Value get(Key key) {
		while (head != null) {
			if (key.equals(head.key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	/**
	 * Removes the key and associated value from the symbol table (if the key is
	 * in the symbol table).
	 * 
	 * @param key
	 *            the key
	 */
	public void delete(Key key) {
		head = delete(head, key);
	}

	// delete key in linked list beginning at Node x
	// warning: function call stack too large if table is large
	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		if (key.equals(x.key)) {
			N--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public int size() {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public boolean isEmpty() {
		return size() == 0;
	}
}
