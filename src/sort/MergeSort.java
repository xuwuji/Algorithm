package sort;

public class MergeSort {

	public static void merge(int[] data, int low, int middle, int high) {
		int[] temp = new int[data.length];
		int index = 0;
		int i = low;
		int j = middle;
		while (index <= high) {
			if (i >= middle) {
				temp[index++] = data[j++];
			}
			if (j >= high) {
				temp[index++] = data[i++];
			}
			if (data[i] <= data[j]) {
				temp[index++] = data[i++];
			} else {
				temp[index++] = data[j++];
			}
		}
		for (int t = 0; t < data.length; t++) {
			data[t] = temp[t];
		}

	}

	public static void sort(int[] data, int low, int high) {
		if (low >= high) {
			return;
		}
		int middle = (low + high) / 2;
		sort(data, low, middle);
		sort(data, middle + 1, high);
		merge(data, low, middle, high);

	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2 };
		MergeSort.sort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}
}
