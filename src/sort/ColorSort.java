package sort;

import util.Util;

public class ColorSort {

	private static void sort(int[] data) {
		int index = 0;
		int i = 0;
		int j = data.length - 1;
		while (index < data.length) {
			if (data[index] == 0) {
				if (index == i) {
					index++;
					i++;
				} else if (index > i) {
					Util.swap(data, i, index);
					i++;
				}
			} else if (data[index] == 1) {
				index++;
			} else if (data[index] == 2) {
				if (index < j) {
					Util.swap(data, index, j);
					j--;
				} else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 0, 1, 2, 0, 1, 2, 2, 1, 0, 2, 2, 1, 2, 0 };
		long start = System.nanoTime();
		ColorSort.sort(a);
		long elapsedTime = System.nanoTime() - start;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(elapsedTime);
	}
}
