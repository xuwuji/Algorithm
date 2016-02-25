package util;

public class Util {
	public static void swap(int[] data, int i, int j) {
		int temp = data[j];
		data[j] = data[i];
		data[i] = temp;

	}

	public static void swap(Object[] data, int i, int j) {
		Object temp = data[j];
		data[j] = data[i];
		data[i] = temp;

	}

	public static int randomInt() {
		return (int) (Math.random() * ((1000) + 1));
	}

}
