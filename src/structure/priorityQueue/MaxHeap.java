package structure.priorityQueue;

import java.util.Arrays;
import java.util.Iterator;

import util.Util;

/**
 * Using a heap to represent a priority queue
 * 
 * This is a max-oriented heap, the greater number is on the top
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ4ÈÕ
 */
public class MaxHeap<Key extends Comparable<Key>> implements Iterable<Key> {

	private Key[] data;
	private int N;

	public MaxHeap(int capacity) {
		data = (Key[]) new Comparable[capacity];
	}

	//
	private void swim(int k) {
		// beacuse we set the index of the heap begins from 0
		// k is the pointer represents the place we insert the new node
		// so it can not be 0, because if it's just the root
		// we don't need to swim the new node with its parent
		while (k > 0) {
			System.out.println("k: " + k);
			// index of its parent is (k-1)/2
			if (data[k].compareTo(data[(k - 1) / 2]) > 0) {
				Util.swap(data, k, (k - 1) / 2);
				System.out.println("swap");
			}
			k = (k - 1) / 2;
		}
	}

	private void insert(Key value) {
		if (isFull()) {
			data = Arrays.copyOf(data, (data.length) * 2);
		}
		System.out.println("value: " + value + "  " + "  N:" + N);
		data[N] = value;
		swim(N++);
		System.out.println(value + "  " + "  N:" + N);
	}

	private boolean isFull() {
		return N == data.length;
	}

	// K is the pointer to the element that should be reordered
	private void sink(int k) {
		// the top in the heap is 0
		// left:2K+1
		// right:2K+2
		// make sure its left child is in the array
		while (k * 2 + 1 < N) {
			// pointer to its left child
			int j = k * 2 + 1;
			// check which one of its children is large
			// set the pointer to the larger one
			if (j + 1 < N && data[j].compareTo(data[j + 1]) < 0) {
				j++;
			}
			// System.out.println("j:" + j);
			// check if the node is smaller than its children
			if (data[k].compareTo(data[j]) > 0) {
				return;
			}
			// swap the parent and its larger child
			Util.swap(data, k, j);
			// repeat the step, make the pointer to the its changed index
			k = j;
		}
	}

	private Key delMax() {
		if (N == 0) {
			return null;
		}
		Key max = data[0];
		System.out.println(max);
		System.out.println("N:" + N);
		Util.swap(data, 0, --N);
		System.out.println("N:" + N);
		data[N] = null;
		sink(0);
		return max;
	}

	// 1.create a max oriented heap
	// 2.reorder the heap
	private Key[] sort(Key[] data) {
		// N is the pointer to the last element in the heap
		int N = data.length - 1;
		// K is the pointer that should be reordered
		for (int k = N / 2; k >= 0; k--) {
			sink(k);
			// System.out.println(" ");
			System.out.println(k + "    " + N);

		}

		while (N >= 0) {
			Util.swap(data, 0, N);
			N--;
			sink(0);
		}

		return data;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public Iterator<Key> iterator() {
		return new HeapIterator();
	}

	private class HeapIterator implements Iterator<Key> {
		// create a new pq
		private MaxHeap<Key> copy;

		// add all elements to copy of heap
		// takes linear time since already in heap order so no keys move
		public HeapIterator() {
			System.out.println(data.length + " ");
			copy = new MaxHeap<Key>(data.length - 1);
			for (int i = 0; i < N; i++) {
				if (data[i] != null) {
					copy.insert(data[i]);
				}
			}

		}

		public boolean hasNext() {
			return !copy.isEmpty();
		}

		public Key next() {
			return copy.delMax();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}
	}

	public static void main(String[] args) {
		MaxHeap<Integer> heap = new MaxHeap<Integer>(4);
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
