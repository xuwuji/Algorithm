package structure.tree;

public class Node<Key extends Comparable<Key>, Value> {
	Key key;
	Value value;
	Node<Key, Value> left;
	Node<Key, Value> right;

	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + "]";
	}

}
