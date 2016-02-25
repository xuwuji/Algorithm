package structure.stack;

import java.util.NoSuchElementException;

/**
 * 
 * @author wuxu 2016-2-25
 *
 * @param <T>
 * 
 *            get min/max Two approach:
 * 
 *            (1) Node with another field max/min
 * 
 *            (2) Additional stacks to track min/max
 */
public class StackWithMinMax<T extends Comparable> extends Stack<T> {
	private Stack<T> minStack = new Stack();
	private Stack<T> maxStack = new Stack();

	@Override
	public void push(T value) {
		if (getMin() == null || value.compareTo(getMin()) < 0) {
			minStack.push(value);
		}

		if (getMax() == null || value.compareTo(getMax()) > 0) {
			maxStack.push(value);
		}
		super.push(value);
	}

	public T pop() {
		T value = super.pop();
		if (value == getMin()) {
			minStack.pop();
		}
		if (value == getMax()) {
			maxStack.pop();
		}
		return value;
	}

	public T peek() {
		return super.peek();
	}

	public T getMin() {
		if (minStack.isEmpty()) {
			return null;
		} else {
			return minStack.peek();
		}
	}

	public T getMax() {
		if (maxStack.isEmpty()) {
			return null;
		} else {
			return maxStack.peek();
		}
	}

	public static void main(String[] args) {
		StackWithMinMax<Integer> stack = new StackWithMinMax<Integer>();
		try {
			stack.push(1);
			stack.push(2);
			stack.push(3);
			// stack.pop();
			// stack.pop();
			// stack.pop();
			// stack.pop();
		} catch (NoSuchElementException e) {
			System.out.println("stack is empty");
		}

		for (Integer i : stack) {
			System.out.println(i);
		}

		System.out.println("------ max&&min of the stack -----");
		System.out.println("min: " + stack.getMin());
		System.out.println("max: " + stack.getMax());
	}

}
