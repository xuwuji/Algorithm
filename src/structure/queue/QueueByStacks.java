package structure.queue;

import java.util.NoSuchElementException;

import structure.stack.Stack;

/**
 * 
 * @author wuxu 2016-2-25
 *
 *         implement queue using two stacks
 */
public class QueueByStacks<T extends Comparable> {
	private Stack<T> in;
	private Stack<T> out;
	private int size;

	public QueueByStacks() {
		in = new Stack<T>();
		out = new Stack<T>();
	}

	public void enque(T value) {
		in.push(value);
		size++;
	}

	public T deque() {
		if (in.isEmpty() && out.isEmpty()) {
			throw new NoSuchElementException("queue is empty");
		}
		size--;
		if (!out.isEmpty()) {
			return out.pop();
		} else {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
			return out.pop();
		}
	}

	public T peek() {
		if (!out.isEmpty()) {
			return out.peek();
		} else {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
			return out.peek();
		}
	}

	public boolean isEmpty() {
		return in.isEmpty() && out.isEmpty();
	}

	public static void main(String[] args) {
		QueueByStacks<Integer> queue = new QueueByStacks();
		queue.enque(1);
		queue.enque(2);
		queue.enque(3);
		queue.enque(4);
		while (!queue.isEmpty()) {
			System.out.print(queue.peek() + "->");
			queue.deque();
		}
	}

}
