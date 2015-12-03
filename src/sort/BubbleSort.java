package sort;

import util.Util;

public class BubbleSort {

	/*
	 * given a array and its size 1. 0 ~ n-1 2. 0 ~ n-2 3. 0 ~ n-3 ....
	 */
	private static int[] sort(int[] data, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (data[j] >= data[j + 1]) {
					Util.swap(data, i, j);
				}
			}
		}
		return data;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2};
		long start = System.nanoTime();
		BubbleSort.sort(a, a.length - 1);
		long elapsedTime = System.nanoTime() - start;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(elapsedTime);
	}

}
