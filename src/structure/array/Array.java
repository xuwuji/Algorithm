package structure.array;

/**
 * In a linked list, lookup is always an O(n) operation, but array lookup is
 * O(1) as long as you know the index of the element you want.
 * 
 * 
 * The price for this improved lookup is signi cantly decreased ef ciency for
 * insertion and dele- tion of data in the middle of the array. Because an array
 * is essentially a block of contiguous memory, it’s not possible to create or
 * eliminate storage between any two elements as it is with a linked list.
 * Instead, you must physically move data within the array to make room for an
 * insertion or to close the gap left by a deletion; this is an O(n) operation.
 * 
 * Most modern languages also have library support for dynamic arrays: arrays
 * that can change size to store as much or as little data as necessary. (Some
 * languages, typically scripting languages, use dynamic arrays as their
 * fundamental array type and have no static array type.) This discussion won’t
 * go into the details of implementing a dynamic array, but you should know that
 * most dynamic array implementations use static arrays internally. A static
 * array cannot be resized, so dynamic arrays are resized by allocating a new
 * array of the appropriate size, copying every element from the old array into
 * the new array, and freeing the old array. This is an expensive operation that
 * should be done as infrequently as possible.
 * 
 * @author wuxu 2016-3-1
 *
 */
public class Array {

	/**
	 * rotate a N*N matrix for 90 degree
	 * 
	 * this is an in-place method, do not need temporary array
	 * 
	 * @param matrix
	 * @param N
	 */
	public static void rotate2DArray(Object[][] matrix, int N) {
		for (int layer = 0; layer < N / 2; layer++) {
			int first = layer;
			int last = N - first - 1;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				// 1. save top
				Object top = matrix[first][i];
				// 2. left -> top
				matrix[first][i] = matrix[last - offset][first];
				// 3. bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				// 4. right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// 5. top -> right
				matrix[i][last] = top;
			}
		}
	}

	/**
	 * rotate a 2d array, not necessary to be a N*N matrix, but this method
	 * needs temporary array to store the new array
	 * 
	 * @param array
	 * @return
	 */
	public static Object[][] rotate2DArray(Object[][] array) {
		Object[][] temp = new Object[array[0].length][array.length];
		int k = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				temp[j][k] = array[i][j];
			}
			k--;
		}
		return temp;
	}

	public static void pring2DMatrix(Object[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Object[][] matrix = new Object[][] { { 1, 2, 3, 11 }, { 4, 5, 6, 22 }, { 7, 8, 9, 44 } };
		// Array.rotate2DArray(matrix, 3);
		// Array.pring2DMatrix(matrix);
		Object[][] temp = Array.rotate2DArray(matrix);
		Array.pring2DMatrix(temp);
	}
}
