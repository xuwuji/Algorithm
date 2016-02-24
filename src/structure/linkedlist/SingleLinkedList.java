package structure.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import structure.exception.NotValidInputException;

/**
 * Each element in a singly linked list contains a pointer to the next element
 * in the list, whereas each element in a doubly linked list points to both the
 * previous and the next elements. The rst ele- ment in both list types is
 * referred to as the head, whereas the last element is referred to as the tail.
 * Circular linked lists have no head or tail; instead, the elements are linked
 * together to form a cycle. List operations are much simpler to perform on
 * doubly linked lists, so most interview problems use singly linked lists.
 * Typical operations include updating the head of the list, traversing the list
 * to nd a speci c element from the end of the list, and inserting or removing
 * list elements.
 * 
 * @author wuxu 2016-2-23
 *
 *         1.add at the first
 *
 *         2.add at the end
 *
 *         3.reverse the linked list
 *
 *         4.check cycle
 * 
 *         5.iterate
 */
public class SingleLinkedList<T> implements Iterable<T> {

	class Node<T> {
		private T value;
		private Node<T> next;

		public Node() {

		}

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

	/**
	 * reverse a single linked list
	 */
	public void reverse() {
		if (isEmpty()) {
			throw new NoSuchElementException("empty linked list");
		}
		Node<T> newHead = null;
		Node<T> pointer = head;
		while (pointer != null) {
			Node<T> temp = pointer;
			pointer = pointer.next;
			temp.next = newHead;
			newHead = temp;
		}
		head = newHead;
	}

	/**
	 * determine whether there is a cycle in the linked list
	 * 
	 * The difference between the two lists appears at their ends. In the cyclic
	 * list, there is an end node that points back to one of the earlier nodes.
	 * In the acyclic list, there is an end node that is null termi- nated.
	 * Thus, if you can nd this end node, you can test whether the list is
	 * cyclic or acyclic.
	 *
	 * 
	 * 
	 * What can you do with two point- ers that you couldn’t do with one? You
	 * can advance them on top of each other, but then you might as well have
	 * one pointer. You could advance them with a xed interval between them, but
	 * this doesn’t seem to gain anything. What happens if you advance the
	 * pointers at different speeds? In the acyclic list, the faster pointer
	 * reaches the end. In the cyclic list, they both loop endlessly. The faster
	 * pointer eventually catches up with and passes the slower pointer. If the
	 * fast pointer is ever behind or equal to the slower pointer, you have a
	 * cyclic list. If it encounters a null pointer, you have an acyclic list.
	 * You’ll need to start the fast pointer one node ahead of the slow pointer
	 * so they’re not equal to begin with.
	 * 
	 * @return
	 */
	public boolean isCycle() {
		if (isEmpty()) {
			return false;
		}
		Node<T> fast = head.next;
		Node<T> slow = head;
		while (true) {
			if (fast == slow || fast.next == slow) {
				return true;
			}
			if (fast == null || fast.next == null) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
	}

	public static void main(String[] args) {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		// create a single linked list
		list.addAtFirst("a");
		list.addAtFirst("b");
		list.addAtFirst("c");

		// list.addAtLast("f");
		// list.addAtFirst("d");
		// list.addAtFirst("e");

		// 1.traverse the single linked list
		System.out.println("----traverse----");
		for (String s : list) {
			System.out.print(s + "->");
		}
		System.out.println("\n");

		// 2.get the nth to the end element in the list
		System.out.println("----n th to the end----");
		try {
			System.out.println(list.NthToTheEnd(2));
		} catch (NotValidInputException e) {
			e.printStackTrace();
		}
		System.out.println("\n");

		// 3.reverse the linked list
		list.reverse();
		System.out.println("----reverse----");
		for (String s : list) {
			System.out.print(s + "->");
		}
		System.out.println("\n");

		// 4. chech if a cycle in the single linked list
		list.head.next.next = list.head.next;
		System.out.println("there is a cycle in the list:" + list.isCycle());

	}

}
