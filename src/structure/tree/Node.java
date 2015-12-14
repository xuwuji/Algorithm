package structure.tree;

public class Node<Key extends Comparable<Key>, E> {
	Key key;
	E e;
	Node left;
	Node right;

	@Override
	public String toString() {
		return "Node [key=" + key + ", e=" + e + "]";
	}

}
