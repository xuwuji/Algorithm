package sort;

import util.Util;

public class HeapSort {

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
			// System.out.println(k + " " + N);

		}

		while (N >= 0) {
			Util.swap(data, 0, N);
			N--;
			sink(data, 0, N);
		}

		return data;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2 };
		long start = System.nanoTime();
		
		
		a = HeapSort.sort(a);
		long elapsedTime = System.nanoTime() - start;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(elapsedTime);
	}

}
