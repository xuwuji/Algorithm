package sort;

import util.Util;

public class InsertionSort {

	/*
	 * 
	 */
	public static int[] sort(int[] data, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (data[j] < data[j - 1]) {
					Util.swap(data, j - 1, j);
				}
			}
		}
		return data;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2 };
		a = InsertionSort.sort(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}
}
