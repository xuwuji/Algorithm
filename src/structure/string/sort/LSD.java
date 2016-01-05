package structure.string.sort;

import sort.RadixSort;

/**
 * use the lsd, from right to left
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ5ÈÕ
 */
public class LSD {
	/**
	 * choose which position to start radix sort
	 * 
	 * @param a
	 * @param index
	 */
	public static void sort(String[] a, int index) {

		// we use the extended ASCII, 8 bits
		// char("a letter, a integer, a character...")= 0,1,2,3,4....255
		// eg. char(1)=49, char(g)=103
		/**
		 * so if you want to just want to sort String contains only 0-9 and a-z,
		 * and A-Z, you don't have to use 256, just 10+26+26 is ok
		 */
		int R = 256;

		// create a temp array to put the temp result
		String[] temp = new String[a.length];

		// check each position
		for (int pointer = index; pointer >= 0; pointer--) {

			// count array
			int[] count = new int[R + 1];

			// 1.the frequency of each key
			for (int j = 0; j < a.length; j++) {
				count[a[j].charAt(pointer) + 1]++;
			}

			// 2.calculate the culumalates
			for (int j = 1; j < count.length; j++) {
				count[j] = count[j] + count[j - 1];
			}

			// 3.loop the original to the temp array
			for (int j = 0; j < a.length; j++) {
				int position = count[a[j].charAt(pointer)]++;
				temp[position] = a[j];
			}

			// 4.rewrite the temp result to the original array
			for (int j = 0; j < a.length; j++) {
				a[j] = temp[j];
			}
		}
	}

	public static void main(String[] args) {
		String[] a = new String[] { "awwe", "v332", "cdd2" };
		LSD.sort(a, (a[0].length() - 1));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

}
