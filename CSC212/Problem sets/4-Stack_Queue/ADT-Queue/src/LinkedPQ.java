public class LinkedPQ<T> {
	private int size;
	private PQNode<T> head;

	public int length() {
		return size;
	}

	public boolean full() {
		return false;
	}

	public void enqueue(T e, int pty) {
		PQNode<T> temp = new PQNode<>(e, pty);
		if (size == 0 || pty > head.priority) {
			temp.next = head;
			head = temp;
		} else {
			PQNode<T> p = head;
			PQNode<T> q = null;
			while (p != null && pty <= p.priority) {
				q = p;
				p = p.next;
			}
			temp.next = p;
			q.next = temp;

		}
		size++;
	}

	public PQElement<T> serve() {
		PQElement<T> pqe = new PQElement<>(head.data, head.priority);
		head = head.next;
		size--;
		return pqe;
	}
}
