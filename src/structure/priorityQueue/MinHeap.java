package structure.priorityQueue;

import java.util.Arrays;
import java.util.Iterator;

import util.Util;

/**
 * Use a heap to represent a priority queue
 * 
 * This is a min-oriented heap, it puts the smaller on the top
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ4ÈÕ
 */
public class MinHeap<Key extends Comparable<Key>> implements Iterable<Key> {
	// the array to represent the priority queue
	private Key[] data;

	// the number of elements in the heap
	private int N = 0;

	public MinHeap(int capacity) {
		data = (Key[]) new Comparable[capacity];
	}

	public MinHeap() {
		this(1);
	}

	public boolean isfull() {
		return N == data.length;
	}

	/**
	 * reorder the value in position k, if it is smaller than its parent, swap
	 * them,continue this process until the position reaches one level below the
	 * root,because we don;t need to check the root
	 * 
	 * down to top
	 * 
	 * @param k
	 * 
	 */
	public void swim(int k) {
		while (k > 0) {
			if (data[k].compareTo(data[(k - 1) / 2]) < 0) {
				Util.swap(data, k, (k - 1) / 2);
			}
			k = k / 2;
		}
	}

	/**
	 * sink a element, top to down
	 * 
	 * @param k
	 */
	public void sink(int k) {
		while ((2 * k) + 1 < N) {
			int j = (2 * k) + 1;
			if (j + 1 < N && data[j].compareTo(data[j + 1]) > 0) {
				j = j + 1;
			}
			if (data[k].compareTo(data[j]) < 0) {
				break;
			}
			Util.swap(data, k, j);
			k = j;
		}
	}

	/**
	 * insert a new element in the first open place in the heap, the reorder the
	 * heap,makes every element in the right position
	 * 
	 * @param value
	 */
	public void insert(Key value) {

		// if the heap is full, then resize it
		if (isfull()) {
			data = Arrays.copyOf(data, (data.length) * 2);
		}
		data[N] = value;
		swim(N++);
	}

	/**
	 * remove the minmum(the top) element
	 * 
	 * 1.swap the top with the last element of the heap and remove it
	 * 
	 * 2.reorder the heap from the last element
	 * 
	 * @return
	 */
	public Key delMin() {
		if (N == 0) {
			return null;
		}
		Key min = data[0];
		Util.swap(data, 0, --N);
		data[N] = null;
		sink(0);
		return min;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public Iterator<Key> iterator() {
		return new MinHeapIterator();
	}

	private class MinHeapIterator implements Iterator<Key> {
		private MinHeap<Key> copy;

		public MinHeapIterator() {

			copy = new MinHeap<Key>(data.length - 1);
			for (int i = 0; i < N; i++) {
				if (data[i] != null) {
					copy.insert(data[i]);
				}
			}
		}

		@Override
		public boolean hasNext() {
			return !copy.isEmpty();
		}

		@Override
		public Key next() {
			return copy.delMin();
		}

		@Override
		public void remove() {
		}

	}

	public static void main(String[] args) {
		MinHeap<Integer> heap = new MinHeap<Integer>(4);
		// int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2 };
		Comparable[] a = new Comparable[4];
		heap.insert(1);
		heap.insert(2);
		heap.insert(24);
		heap.insert(32);
		heap.insert(2222);
		// a = heap.sort((Integer[]) a);
		System.out.println("deleting---------------------- ");
		for (int i = heap.N; i > 0; i--) {
			// heap.delMax();
			// System.out.print(heap.data[i].toString());
			// System.out.println("N:" + heap.N);
		}
		System.out.println("itetating---------------------- ");
		for (int i : heap) {
			System.out.println("itetating:" + i + " ");
		}
	}

}
