package sort;

public class BinaryInsertionSort {

	private static void sort(int[] data) {
		int length = data.length;
		for (int i = 0; i < length; i++) {
			int low = 0;
			int high = i;
			int middle = (low + high) / 2;
			// find the right place to insert
			// it is just a binary search
			while (low < high) {
				if (data[i] < data[middle]) {
					high = middle;
				} else {
					low = middle + 1;
				}

			}

		}

	}

}
