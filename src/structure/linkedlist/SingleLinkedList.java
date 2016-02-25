package structure.linkedlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

import structure.exception.NotValidInputException;
import structure.stack.Stack;

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
 * 
 *         6.merge two sorted linked list
 * 
 *         7.remove duplicated nodes from an unsorted linked list
 * 
 *         8.delete a node in the middle of the list, given that node and
 *         requires O(1) time
 * 
 *         9.if there is a cycle in the linked list, find the head of the cycle
 * 
 *         10.check if the linked list is a palindrome
 */
public class SingleLinkedList<T extends Comparable> implements Iterable<T> {

	class Node<T> {
		private T value;
		private Node<T> next;

		public Node() {

		}

		public Node(T value) {
			this.value = value;
		}
	}

	private Node<T> head = null;

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
		while (head != null) {
			Node<T> temp = head;
			head = head.next;
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

	/**
	 * merge two sorted linked list
	 * 
	 * @param a
	 */
	public Node mergerTwoSortedList(Node<T> a, Node<T> b) {
		Node<T> newHead = new Node<T>();
		Node<T> pointer = newHead;
		while (a != null || b != null) {
			if (a == null) {
				while (b != null) {
					pointer.next = b;
					pointer = pointer.next;
					b = b.next;
				}
			} else if (b == null) {
				while (a != null) {
					pointer.next = a;
					pointer = pointer.next;
					a = a.next;
				}
			} else {
				if (a.value.compareTo(b.value) < 0) {
					pointer.next = a;
					a = a.next;
					pointer = pointer.next;
				} else {
					pointer.next = b;
					b = b.next;
					pointer = pointer.next;
				}
			}
		}
		return newHead.next;
	}

	/**
	 * remove duplicated nodes in the linked list
	 */
	public void removeDuplicatedNodes() {
		if (isEmpty()) {
			return;
		}
		HashSet<T> set = new HashSet();
		Node<T> pointer = head;
		set.add(pointer.value);
		while (pointer != null && pointer.next != null) {
			if (set.contains(pointer.next.value)) {
				pointer.next = pointer.next.next;
			} else {
				set.add(pointer.next.value);
				pointer = pointer.next;
			}
		}
	}

	/**
	 * find the head of the cycle if it exists
	 * 
	 * @return
	 */
	public Node<T> findHeadOfTheCycle() {
		Node<T> fast = head.next;
		Node<T> slow = head;
		while (true) {
			// if there is no cycle in the cycle
			if (fast == null || fast.next == null) {
				return null;
			}

			if (fast == slow) {
				break;
			}
			fast = fast.next;
			slow = slow.next;
		}

		// move slow back to the head and keep the fast in the meeting place.
		// Continue moving them and when they meet, the place is the head of the
		// cycle
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}

	/**
	 * in the problem, you are not given the access of the head and only have
	 * the access of the node wanted to be deleted
	 * 
	 * @param node
	 */
	public void deleteNodeInTheMiddle(Node<T> node) {
		if (node == null) {
			return;
		}
		if (node.next == null) {
			node = null;
		} else {
			node.value = node.next.value;
			node.next = node.next.next;
		}
	}

	/**
	 * check if the list is palindrome or not
	 * 
	 * solution 1:reverse the whole linked list and compare it with the original
	 * one
	 * 
	 * solution 2:put the first half into a stack and pop , compare with the
	 * second half one by one
	 * 
	 * 
	 * Use the solution 2 here
	 * 
	 * @return
	 */
	public boolean checkPalindrome() {
		Stack<T> stack = new Stack();
		// 1.use two pointers slow and fast to check for middle position
		Node<T> fast = head;
		Node<T> slow = head;
		while (fast != null && fast.next != null) {
			stack.push(slow.value);
			slow = slow.next;
			fast = fast.next.next;
		}
		// if the list is odd, move the slow to next position( cross the middle
		// position), if it is an even list,just skip this step
		if (fast != null) {
			slow = slow.next;
		}

		while (!stack.isEmpty()) {
			if (stack.pop() != slow.value) {
				return false;
			}
			slow = slow.next;
		}
		return true;
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
		System.out.println("----check cycle----");
		list.head.next.next = list.head.next;
		System.out.println("there is a cycle in the list:" + list.isCycle());

		// 5.merge two sorted single linked list
		SingleLinkedList<Integer> listA = new SingleLinkedList<Integer>();
		SingleLinkedList<Integer> listB = new SingleLinkedList<Integer>();
		listA.addAtLast(1);
		listA.addAtLast(3);
		listA.addAtLast(5);
		listB.addAtLast(2);
		listB.addAtLast(4);
		listB.addAtLast(6);

		System.out.println("\n");
		System.out.println("----merge two sorted linked list----");
		System.out.println("----before----");
		for (Integer s : listA) {
			System.out.print(s + "->");
		}
		System.out.println("\n");
		for (Integer s : listB) {
			System.out.print(s + "->");
		}
		System.out.println("\n");

		listA.mergerTwoSortedList(listA.head, listB.head);

		System.out.println("----after----");
		for (Integer s : listA) {
			System.out.print(s + "->");
		}
		System.out.println("\n");

		// 6. remove duplicated nodes in the linked list
		System.out.println("----remove duplicated nodes----");
		SingleLinkedList<Integer> listC = new SingleLinkedList<Integer>();
		listC.addAtLast(1);
		listC.addAtLast(2);
		listC.addAtLast(1);
		listC.addAtLast(2);
		for (int i : listC) {
			System.out.print(i + "->");
		}
		listC.removeDuplicatedNodes();
		System.out.println("\n");
		for (int i : listC) {
			System.out.print(i + "->");
		}
		System.out.println("\n");

		// 7. check if it is parlindrome
		System.out.println("----check palindrome----");
		SingleLinkedList<Integer> listD = new SingleLinkedList<Integer>();
		listD.addAtLast(1);
		listD.addAtLast(2);
		listD.addAtLast(2);
		listD.addAtLast(1);
		for (int i : listC) {
			System.out.print(i + "->");
		}
		System.out.println("\n");
		System.out.println("it is palindrom: " + listC.checkPalindrome());
		for (int i : listD) {
			System.out.print(i + "->");
		}
		System.out.println("\n");
		System.out.println("it is palindrom: " + listD.checkPalindrome());

	}

}
