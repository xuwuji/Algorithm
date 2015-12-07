package structure.queue;

import java.util.NoSuchElementException;

public class Queue {

	private int N = 0;
	private Node head = null;
	private Node tail = null;

	class Node {
		private int value;
		private Node next;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void enque(int value) {
		Node node = new Node();
		node.value = value;

		if (isEmpty()) {
			head = node;
			tail = node;

		} else {
			tail.next = node;
			tail = node;
		}
		N++;
	}

	public void deque() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		int value = head.value;
		head = head.next;
		N--;
	}

	public int peek() {
		return head.value;
	}

	public int getSize() {
		return N;
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enque(1);
		q.enque(2);
		q.enque(3);
		q.deque();
		System.out.println(q.peek());
		while (q.head != null) {
			System.out.println(q.head.value);
			q.head = q.head.next;
		}

	}

}
