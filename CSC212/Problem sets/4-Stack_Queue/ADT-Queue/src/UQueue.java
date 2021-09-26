
public interface UQueue<T> {
	int length();

	boolean enqueue(T e);

	T serveFirst();

	T serveLast();
}

class LinkedUqueue<T> implements UQueue<T> {
	private Node<T> head, tail;
	private int size;

	@Override
	public int length() {
		return size;
	}

	@Override
	public boolean enqueue(T e) {
		if (size == 0) {
			tail = head = new Node<T>(e);
		} else {
			Node<T> p = head;
			while (p.next != null && !e.equals(p.data))
				p = p.next;
			if ((p.data).equals(e))
				return false;
			tail.next = new Node<>(e);
			tail = tail.next;
		}
		size++;
		return true;
	}

	@Override
	public T serveFirst() {
		T e = head.data;
		head = head.next;
		if (head == null)
			tail = null;
		else
			head.previous = null;
		size--;
		return e;
	}

	@Override
	public T serveLast() {
		T e = tail.data;
		tail = tail.previous;
		if (tail == null)
			head = null;
		else
			tail.next = null;
		size--;
		return e;
	}

}