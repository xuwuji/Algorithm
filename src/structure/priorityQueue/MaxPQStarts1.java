package structure.priorityQueue;

/**
 * A max oriented priority queue
 * 
 * The first element stores in index 1
 * 
 * the capacity of elements should be n+1
 * 
 * @author wuxu
 *
 *         2016-1-27
 */
public class MaxPQStarts1<Key extends Comparable<Key>> {

	private Key[] array;
	// size of elements in the array, also the last element index
	private int size;

	public MaxPQStarts1(int capacity) {
		array = (Key[]) new Comparable[capacity + 1];
	}

	private boolean isEmpty() {
		return size == 0;
	}

	private boolean isFull() {
		return size + 1 == array.length;
	}

	private boolean less(Key a, Key b) {
		return a.compareTo(b) < 0;
	}

	/**
	 * return the index of the current minimum element
	 * 
	 * @return
	 */
	private int findMin() {
		int min = 1;
		int k = 1;
		while (k < size) {
			if ((1 + 2 * k) <= size && less(array[2 * k + 1], array[2 * k])) {
				min = 2 * k + 1;
			} else {
				min = 2 * k;
			}
			k = min;
		}
		return min;
	}

	private void swap(int i, int j) {
		Key temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * insert a new element into the priority queue
	 * 
	 * if the queue is full, change it with the minimum
	 * 
	 * @param element
	 */
	public void insert(Key element) {
		if (isFull()) {
			int min = this.findMin();
			if (less(array[min], element)) {
				array[min] = element;
				swim(min);
			}
		} else {
			size++;
			array[size] = element;
			swim(size);
		}
	}

	/**
	 * sink an element in the queue
	 * 
	 * @param index
	 */
	public void sink(int index) {
		int bigger = index;
		int k = index;
		while (k < size) {
			if ((1 + 2 * k) <= size && less(array[2 * k + 1], array[2 * k])) {
				bigger = 2 * k + 1;
			} else {
				bigger = 2 * k;
			}
			swap(k, bigger);
			k = bigger;
		}
	}

	/**
	 * swim a new element, make it to the right place
	 * 
	 * @param index
	 */
	private void swim(int index) {
		while (index > 1) {
			if (less(array[index / 2], array[index])) {
				swap(index / 2, index);
			}
			index = index / 2;
		}
	}

	public static void main(String[] args) {
		MaxPQStarts1<Integer> pq = new MaxPQStarts1<Integer>(4);
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		pq.insert(4);
		pq.insert(5);
		pq.insert(6);
		for (Comparable key : pq.array) {
			System.out.println(key);
		}
	}

}
