package sort;

import java.util.HashMap;
import java.util.Map.Entry;

import util.Util;

public class ShellSort {

	private static void sort(int[] data) {
		int length = data.length;
		int step = length / 3;
		while (step >= 1) {
			for (int i = 0; i < length; i++) {
				for (int j = i; j - step >= 0; j = j - step) {
					if (data[j] <= data[j - step]) {
						Util.swap(data, j, j - step);
					}
				}

			}
			step = step / 3;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2 };
		long start = System.nanoTime();
		ShellSort.sort(a);
		long elapsedTime = System.nanoTime() - start;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(elapsedTime);
	}

}
