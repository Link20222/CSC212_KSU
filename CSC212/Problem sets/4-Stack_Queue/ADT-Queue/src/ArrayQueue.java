
public class ArrayQueue<T> implements Queue<T> {
	private int size, maxsize, head, tail;
	private T[] data;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int max) {
		maxsize = max;
		size = head = tail = 0;
		data = (T[]) new Object[max];
	}

	public T serve() {
		T temp = data[head];
		head = (head + 1) % maxsize;
		size--;
		return temp;
	}

	public void enqueue(T e) {
		data[tail] = e;
		tail = (tail + 1) % maxsize;
		size++;
	}

	public int length() {
		return size;
	}

	public boolean full() {
		return size == maxsize;
	}

	public T enquiry() {
		return data[head];
	}

}
