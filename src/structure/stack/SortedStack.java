package structure.stack;

import java.util.NoSuchElementException;

import util.Util;

/**
 * 
 * @author wuxu 2016-2-25
 * 
 *         sort a stack with one additional stack
 *
 */
public class SortedStack<T extends Comparable> extends Stack<T> {

	public void sort() {
		Stack<T> helper = new Stack();
		while (!this.isEmpty()) {
			T temp = this.pop();
			while (!helper.isEmpty() && temp.compareTo(helper.peek()) < 0) {
				this.push(helper.pop());
			}
			helper.push(temp);
		}
		while (!helper.isEmpty()) {
			this.push(helper.pop());
		}
	}

	public static void main(String[] args) {
		SortedStack<Integer> stack = new SortedStack<Integer>();
		for (int i = 0; i < 1000; i++) {
			stack.push(Util.randomInt());
		}
		stack.sort();
		for (int i : stack) {
			System.out.println(i);
		}
	}
}
