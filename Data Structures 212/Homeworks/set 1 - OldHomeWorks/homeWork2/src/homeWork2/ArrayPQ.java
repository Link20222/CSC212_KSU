package homeWork2;

public class ArrayPQ<T> {
	private int maxsize;
	private int size;
	private int head;
	private PQElement<T>[] data;
	// private int[] priority;

	public ArrayPQ(int n) {
		maxsize = n;
		size = 0;
		head = 0;
		data = (PQElement<T>[]) new PQElement<?>[n];
		// priority = new int[n];

	}

	public boolean full() {
		return size == maxsize;
	}

	public int length() {
		return size;
	}

	public PQElement<T> serve() {

		PQElement<T> temp = data[head];
		head++;
		size--;
		return temp;
	}
	
	public void enqueue(T e, int pty) {
		PQElement<T> temp = new PQElement<T>(e, pty);

		if ((size == 0))
			data[head] = temp;

		else if (pty > data[head].p)
			if (head != 0) {
				data[--head] = temp;
				size++;
				return;
			}

		if (head != 0) {
			for (int x = 0; x < data.length; x++)
				if (head + x < data.length)
					data[x] = data[head + x];
				else
					data[x] = null;

			head = 0;
		}

		int index = head, i = 0;
		if (!(data[head].p < pty)) {
			for (i = 0; i < size; i++) {
				if (data[index + 1] != null)
					if (data[index].p >= pty && pty > data[index + 1].p) {
						index++;
						break;
					}
				index++;
			}
		}

		for (int j = size - 1; j >= i; j--) {
			data[j + 1] = data[j];
			if (j == index)
				break;
		}

		data[index] = temp;

		size++;
	}
}
