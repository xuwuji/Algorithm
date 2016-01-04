package structure.priorityQueue;

import java.util.Arrays;

import util.Util;

public class Heap {

	private int[] data;
	private static int N;

	public Heap(int capacity) {
		data = new int[capacity];
	}

	//
	private static void swim(int[] data, int k) {
		// beacuse we set the index of the heap begins from 0
		// k is the pointer represents the place we insert the new node
		// so it can not be 0, because if it's just the root
		// we don't need to swim the new node with its parent
		while (k > 0) {
			// index of its parent is (k-1)/2
			if (data[k] > data[(k - 1) / 2]) {
				Util.swap(data, k, (k - 1) / 2);
			}
			k = (k - 1) / 2;
		}
	}

	private static void insert(int[] data, int value) {

		// check if the heap is full
		if (isFull(data)) {
			// increase the heap size
			data = Arrays.copyOf(data, data.length + 1);
			// put the new element in the last place of the heap
			data[data.length - 1] = value;
		}
		int k = data.length - 1;
		System.out.print(k + "\n ");
		for (int i = 0; i < data.length; i++) {
			if (Integer.valueOf(data[i]) == null) {
				data[i] = value;
				k = i;
				break;
			}
		}
		// reorder the new element
		swim(data, k);
	}

	private static int delMax(int[] data) {
		int max = data[0];
		// swap the root with the last element
		Util.swap(data, 0, data.length - 1);
		// reorder the top element
		// now the last active element of the heap is in data.length-2
		sink(data, 0, data.length - 2);
		// make the last place of heap to be null
		data[data.length - 1] = (Integer) null;
		return max;
	}

	private static boolean isFull(int[] data) {
		if (!(Integer.valueOf(data[data.length - 1]) == null)) {
			return true;
		}
		return false;
	}

	// N is the pointer to the last element in the heap
	// K is the pointer to the element that should be reordered
	private static void sink(int[] data, int k, int N) {
		// the top in the heap is 0
		// left:2K+1
		// right:2K+2
		// make sure its left child is in the array
		while (k * 2 + 1 < N) {
			// pointer to its left child
			int j = k * 2 + 1;
			// check which one of its children is large
			// set the pointer to the larger one
			if (j < N && data[j] <= data[j + 1]) {
				j++;
			}
			// check if the node is smaller than its children
			if (data[k] > data[j]) {
				break;
			}
			// swap the parent and its larger child
			Util.swap(data, k, j);
			// repeat the step, make the pointer to the its changed index
			k = j;
		}
	}

	// 1.create a max oriented heap
	// 2.reorder the heap
	private static int[] sort(int[] data) {
		// N is the pointer to the last element in the heap
		int N = data.length - 1;
		// K is the pointer that should be reordered
		for (int k = N / 2; k >= 0; k--) {
			sink(data, k, N);
			// System.out.println(" ");
			System.out.println(k + "    " + N);

		}

		while (N >= 0) {
			Util.swap(data, 0, N);
			N--;
			sink(data, 0, N);
		}

		return data;
	}

	public static void main(String[] args) {
		// int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2 };
		int[] a = new int[4];
		// System.out.print(a[1] + " ");
		insert(a, 1);
		insert(a, 14);
		insert(a, 21);
		insert(a, 3);
		insert(a, 1444);
		insert(a, 2);
		insert(a, 1);
		// a = Heap.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}
}