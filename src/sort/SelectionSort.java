package sort;

import util.Util;

public class SelectionSort {
	/*
	 * find the smallest element of the remaining and swap them
	 */
	public static int[] sort(int[] data, int n) {
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (data[j] <= data[min]) {
					min = j;
				}
			}
			Util.swap(data, i, min);

		}
		return data;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2 };
		a = SelectionSort.sort(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}
}