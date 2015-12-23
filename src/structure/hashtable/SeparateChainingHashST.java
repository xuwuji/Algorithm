package structure.hashtable;

public class SeparateChainingHashST<Key, Value> {
	// normally, the bucket size is the total number of <k,V> pairs/5
	private int buckets_size = 97;
	private Node[] buckets = new Node[buckets_size];

	// You can't have arrays of generic classes. Java simply doesn't support it.
	// declare the type to Object
	private static class Node {
		// Key key;
		Object key;
		// Value value;
		Object value;
		Node next;
	}

	public int hash(Key key) {
		int hashcode = key.hashCode();
		// make the hashcode to be positive first
		return (hashcode & 0x7fffffff) % buckets_size;
	}

	public Value get(Key key) {
		// 1.check it is in which bucket
		int i = hash(key);
		// 2. set a pointer to the head of this bucket
		Node pointer = buckets[i];
		// 3.scan this bucket
		while (pointer != null) {
			if (pointer.key.equals(key)) {
				return (Value) pointer.value;
			}
			pointer = pointer.next;
		}
		return null;
	}

	public void put(Key key, Value value) {
		int i = hash(key);
		Node node = new Node();
		node.key = key;
		node.value = value;
		Node pointer = buckets[i];
		if (pointer == null) {
			buckets[i] = node;
			return;
		}
		while (pointer.next != null) {
			if (key.equals(pointer.key)) {
				pointer.value = value;
				return;
			}
			pointer = pointer.next;
		}
		pointer.next = node;
	}

	public void delete(Key key) {

	}

}
