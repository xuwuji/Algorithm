package sort;

import util.Util;

public class QuickSort {

	public static int Partition(int[] data, int low, int high) {

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
		int i = Partition(data, low, high);
		sort(data, low, i - 1);
		sort(data, i + 1, high);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2 };
		QuickSort.sort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

}
