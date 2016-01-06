package structure.string.sort;

import sort.InsertionSort;

/**
 * use the msd algorithm to sort the array, from left to right
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ5ÈÕ
 */
public class MSD {
	private static int M = 3;
	private static int R = 256;
	private static String[] temp;

	private static int charAt(String s, int index) {
		if (index < s.length()) {
			return s.charAt(index);
		} else {
			return -1;
		}
	}

	public static void sort(String[] data) {
		temp = new String[data.length];
		sort(data, 0, data.length - 1, 0);
	}

	/**
	 * every process we just sort the data between the low and high scope
	 * 
	 * @param a
	 * @param low
	 * @param high
	 * @param pointer
	 */
	public static void sort(String[] a, int low, int high, int pointer) {
		// when the scope is too small, using msd will waste a lot of time
		// because it used a count array and it is very big
		// so when the scope is small, we just use the insertion sort
		if (high <= low + M) {
			insertion(a, low, high, pointer);
			return;
		}
		/**
		 * because here we set the empty key to -1
		 * 
		 * count[0] is same as lsd, leave as empty
		 * 
		 * count[1] represents number of -1(no char at a word in that position)
		 */
		int[] count = new int[R + 2];

		// 1.count the frequency,here it needs to add 2 instead of 1 like lsd
		/**
		 * count process is just between the low and high scope
		 */
		for (int j = low; j <= high; j++) {
			count[charAt(a[j], pointer) + 2]++;
		}

		// 2.caculate the cumulates of the count
		for (int j = 1; j < count.length; j++) {
			count[j] = count[j] + count[j - 1];
		}

		// 3.loop the original array and put into the right position
		for (int j = low; j <= high; j++) {
			int position = count[charAt(a[j], pointer) + 1]++;
			temp[position] = a[j];
		}

		// 4.rewrite the temp to the original
		for (int j = low; j <= high; j++) {
			a[j] = temp[j - low];
		}

		// recursive, each count[j] actually is the a scope
		for (int j = 0; j < R; j++) {
			sort(a, low + count[j], low + count[j + 1] - 1, pointer + 1);
		}
	}

	// insertion sort a[lo..hi], based on the pointer character position
	private static void insertion(String[] a, int low, int high, int pointer) {
		for (int i = low; i <= high; i++)
			for (int j = i; j > low && less(a[j], a[j - 1], pointer); j--)
				exch(a, j, j - 1);
	}

	// exchange a[i] and a[j]
	private static void exch(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// is v less than w, starting at pointer character position
	private static boolean less(String v, String w, int pointer) {
		for (int i = pointer; i < Math.min(v.length(), w.length()); i++) {
			if (v.charAt(i) < w.charAt(i))
				return true;
			if (v.charAt(i) > w.charAt(i))
				return false;
		}
		return v.length() < w.length();
	}

	public static void main(String[] args) {
		String[] a = new String[] { "awwe", "v332", "cdd2", "dwqedqwe", "ee2132eeds", "dsd", "we", "weqwe" };
		String[] b = new String[] { "a", };
		MSD.sort(a);
		MSD.sort(b);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}

		System.out.println("b-------------");
		for (int i = b.length - 1; i >= 0; i--) {
			System.out.print(b[i] + " ");
		}

	}
}
