package structure.queue;

import java.util.NoSuchElementException;

public class Queue<E> {

	private int N = 0;
	private Node head = null;
	private Node tail = null;

	class Node {
		private E e;
		private Node next;

	}

	public boolean isEmpty() {
		return head == null;
	}

	public void enque(E e) {
		if (e == null) {
			return;
		}
		Node node = new Node();
		node.e = e;

		if (isEmpty()) {
			head = node;
			tail = node;

		} else {
			tail.next = node;
			tail = node;
		}
		N++;
	}

	public E deque() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		E e = head.e;
		head = head.next;
		N--;
		return e;
	}

	public E peek() {
		return head.e;
	}

	public int getSize() {
		return N;
	}

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.enque(1);
		q.enque(2);
		q.enque(3);
		q.deque();
		q.deque();
		q.deque();
		System.out.println(q.isEmpty());
		System.out.println(q.peek());
		while (q.head != null) {
			System.out.println(q.head.e);
			q.head = q.head.next;
		}

	}

}
