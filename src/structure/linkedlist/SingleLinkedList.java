package structure.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import structure.exception.NotValidInputException;

/**
 * 
 * @author wuxu 2016-2-23
 *
 */
public class SingleLinkedList<T> implements Iterable<T> {

	class Node<T> {
		private T value;
		private Node<T> next;

		public Node(T value) {
			this.value = value;
		}
	}

	private Node<T> head;

	/**
	 * return the nth-to-the-end node in the linked list
	 * 
	 * @param n
	 * @throws NotValidInputException
	 */
	public T NthToTheEnd(int n) throws NotValidInputException {
		if (isEmpty()) {
			throw new NoSuchElementException("empty linked list");
		}
		if (n < 0) {
			throw new NotValidInputException("cannot be negative");
		}
		Node<T> fast = head;
		Node<T> slow = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.value;
	}

	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * insert a new element at the beginning
	 * 
	 * @param value
	 */
	public void addAtFirst(T value) {
		Node<T> node = new Node<T>(value);
		node.next = head;
		head = node;
	}

	/**
	 * insert a new element at the end
	 * 
	 * @param value
	 */
	public void addAtLast(T value) {
		if (isEmpty()) {
			addAtFirst(value);
		} else {
			Node<T> pointer = head;
			while (pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = new Node<T>(value);
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new SingleLinkedListIterator<T>(head);
	}

	class SingleLinkedListIterator<T> implements Iterator<T> {
		private Node<T> current;

		public SingleLinkedListIterator(Node<T> head) {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T value = current.value;
			current = current.next;
			return value;
		}
	}

	public static void main(String[] args) {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		list.addAtFirst("a");
		list.addAtFirst("b");
		list.addAtFirst("c");
		list.addAtLast("f");
		list.addAtFirst("d");
		list.addAtFirst("e");

		for (String s : list) {
			System.out.println(s);
		}
		try {
			System.out.println(list.NthToTheEnd(2));
		} catch (NotValidInputException e) {
			e.printStackTrace();
		}

	}

}
