package structure.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Use linked list to implement the stack
 * 
 * insert a new element in the head and delete it from the head.
 * 
 * Both operations change the first element of the list
 * 
 * @author wuxu 2016-2-23
 */
public class Stack<T> implements Iterable<T> {

	class Node<T> {
		private T value;
		private Node<T> next;

		public Node(T value) {
			this.value = value;
		}
	}

	private Node<T> head;
	private int size;

	public void push(T value) {
		Node<T> node = new Node<T>(value);
		node.next = head;
		head = node;
		size++;
	}

	public T pop() {
		if (head == null) {
			throw new NoSuchElementException("Stack underflow");
		}
		T value = head.value;
		head = head.next;
		size--;
		return value;

	}

	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}

		return head.value;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int getSize() {
		return this.size;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(head);
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<T> implements Iterator<T> {
		private Node<T> current;

		public ListIterator(Node<T> head) {
			current = head;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T value = current.value;
			current = current.next;
			return value;
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		try {
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
		} catch (NoSuchElementException e) {
			System.out.println("stack is empty");
		}
		for (Integer i : stack) {
			System.out.println(i);
		}
	}

}
