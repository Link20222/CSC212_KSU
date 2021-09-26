public class LinkedDQueue<T> {
	private Node<T> head, tail;

	public boolean empty() {
		return head == null;
	}

	public void addFirst(T e) {
		Node<T> newHead = new Node<>(e);
		if (empty()) {
			head = tail = newHead;
			return;
		}

		newHead.next = head;
		head.previous = newHead;
		head = newHead;
	}

	public void addLast(T e) {
		Node<T> newTail = new Node<>(e);
		if (empty()) {
			head = tail = newTail;
			return;
		}
		tail.next = newTail;
		newTail.previous = tail;
		tail = newTail;
	}

	public T removeFirst() {
		if (empty())
			return null;

		Node<T> temp = head;
		head = head.next;

		if (head == null) {
			head = null;
			return temp.data;
		}

		head.previous = null;
		return temp.data;
	}

	public T removeLast() {
		if (empty())
			return null;

		Node<T> temp = tail;
		tail = tail.previous;

		if (tail == null) {
			head = null;
			return temp.data;
		}

		tail.next = null;
		return temp.data;
	}

	public T getFirst() {
		return head.data;
	}

	public T getLast() {
		return tail.data;
	}

}
