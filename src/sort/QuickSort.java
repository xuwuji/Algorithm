package sort;

import util.Util;

/**
 * 
 * @author wuxu
 *
 */
public class QuickSort {

	public static int partition(int[] data, int low, int high) {
		int i = low + 1;
		int j = high;
		while (true) {
			while (data[i] < data[low]) {
				if (i == high) {
					break;
				}

				i++;
			}

			while (data[j] > data[low]) {
				if (j == low) {
					break;
				}

				j--;
			}
			if (i >= j) {

				break;
			}
			Util.swap(data, i, j);
			i++;
			j--;
		}
		Util.swap(data, low, j);
		return j;
	}

	public static void sort(int[] data, int low, int high) {
		if (low >= high) {
			return;
		}
		int i = partition(data, low, high);
		sort(data, low, i - 1);
		sort(data, i + 1, high);
	}

	/**
	 * find the element in the nth position (begins from 0),also you can get
	 * like the nth biggest/smallest number or n biggest/smallest number
	 * 
	 * this is another way compares to heap sort
	 * 
	 * @param data
	 * @param low
	 * @param high
	 * @param n
	 * @return
	 */
	public static int findNth(int[] array, int low, int high, int n) {
		int pivot = partition(array, low, high);
		if (pivot == n) {
			return array[pivot];
		} else if (pivot < n) {
			return findNth(array, pivot + 1, high, n);
		} else {
			return findNth(array, low, pivot - 1, n);
		}
	}

	public static void main(String[] args) {
		int[] b = new int[100];
		for (int i = 0; i < 100; i++) {
			int randomNum = (int) (Math.random() * ((1000) + 1));
			b[i] = randomNum;
		}
		int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2 };
		long start = System.nanoTime();
		QuickSort.sort(b, 0, b.length - 1);
		long elapsedTime = System.nanoTime() - start;
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		// System.out.println(elapsedTime);
		System.out.println(QuickSort.findNth(a, 0, a.length - 1, 5));
		for (int i = 5; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
