package sort;

public class RadixSort {

	private static void sort(int[] data) {
		// get the maximum
		int max = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}

		// get the check time
		int time = 0;
		while (max > 0) {
			max = max / 10;
			time++;
		}

		int radix = 10;

		// represents which fen wei is checking
		for (int i = 0; i < time; i++) {

			// count the fen wei key of each element in the bucket
			int[] buckets = new int[radix];
			for (int j = 0; j < data.length; j++) {
				int key = (data[j] / (int) Math.pow(10, i)) % radix;
				buckets[key]++;
			}

			int[] count = new int[buckets.length];

			// record which position it should be put it the bucket
			for (int k = 1; k < buckets.length; k++) {
				count[k] = count[k - 1] + buckets[k - 1];
			}

			// loop the origin data array, and put each element in the right
			// place of a temp array

			int[] temp = new int[data.length];

			for (int j = 0; j < data.length; j++) {
				int key = (data[j] / (int) Math.pow(10, i)) % radix;
				int position = count[key];
				count[key]++;
				temp[position] = data[j];
			}

			for (int j = 0; j < data.length; j++) {
				data[j] = temp[j];
			}
		}
	}

	private static void LSDsort(int[] data) {
		// get the maximum
		int max = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}

		// get the check time
		int time = 0;
		while (max > 0) {
			max = max / 10;
			time++;
		}

		int radix = 10;

		// represents which fen wei is checking
		for (int i = 0; i < time; i++) {

			// count the fen wei key of each element in the bucket
			int[] buckets = new int[radix + 1];
			for (int j = 0; j < data.length; j++) {
				int key = (data[j] / (int) Math.pow(10, i)) % radix;
				buckets[key + 1]++;
			}

			// record which position it should be put it the bucket
			for (int k = 1; k < buckets.length; k++) {
				buckets[k] = buckets[k] + buckets[k - 1];
			}

			// loop the origin data array, and put each element in the right
			// place of a temp array

			int[] temp = new int[data.length];

			for (int j = 0; j < data.length; j++) {
				int key = (data[j] / (int) Math.pow(10, i)) % radix;
				int position = buckets[key]++;
				temp[position] = data[j];
			}

			// put the data back to the origin array as this sort order
			for (int j = 0; j < data.length; j++) {
				data[j] = temp[j];
			}
		}
	}

	private static void MSDsort(int[] data) {
		// get the maximum
		int max = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}

		// get the check time
		int time = 0;
		while (max > 0) {
			max = max / 10;
			time++;
		}

		int radix = 10;

		// represents which fen wei is checking
		for (int i = 0; i < time; i++) {

			// count the fen wei key of each element in the bucket
			int[] buckets = new int[radix + 1];
			for (int j = 0; j < data.length; j++) {
				int key = (data[j] / (int) Math.pow(10, i)) % radix;
				buckets[key + 1]++;
			}

			// record which position it should be put it the bucket
			for (int k = 1; k < buckets.length; k++) {
				buckets[k] = buckets[k] + buckets[k - 1];
			}

			// loop the origin data array, and put each element in the right
			// place of a temp array

			int[] temp = new int[data.length];

			for (int j = 0; j < data.length; j++) {
				int key = (data[j] / (int) Math.pow(10, i)) % radix;
				int position = buckets[key]++;
				temp[position] = data[j];
			}

			// put the data back to the origin array as this sort order
			for (int j = 0; j < data.length; j++) {
				data[j] = temp[j];
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 4, 12, 4, 6, 2, 1, 3, 7743, 2, 0 };
		RadixSort.LSDsort(a);
		for (int i = 0; i < a.length; i++) {

			System.out.print(a[i] + " ");
		}

	}

}
