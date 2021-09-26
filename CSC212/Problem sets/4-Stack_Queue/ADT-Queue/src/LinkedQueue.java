
public class LinkedQueue<T> implements Queue<T> {
	private int size;
	private Node<T> head, tail;

	public LinkedQueue() {
		head = tail = null;
		size = 0;
	}

	public boolean full() {
		return false;
	}

	public int length() {
		return size;
	}

	public void enqueue(T e) {
		Node<T> temp = new Node<>(e);
		if (head == null) {
			head = tail = temp;
			return;
		}
		tail.next = temp;
		tail = temp;
	}

	public T serve() {
		T e = head.data;
		head = head.next;
		size--;
		if (size == 0)
			tail = null;
		return e;
	}

	public T enquiry() {
		return head.data;
	}

	public int size() {
		Node<T> temp = head;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

}
