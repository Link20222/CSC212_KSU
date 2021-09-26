
public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	@Override
	public void findFirst() {
		current = head;
	}

	@Override
	public void findNext() {
		current = current.next;
	}

	public void findPrevious() {
		Node<T> temp = head;
		while (temp.next != current)
			temp = temp.next;
		current = temp;
	}

	@Override
	public T retrieve() {
		return current.data;
	}

	@Override
	public void update(T e) {
		current.data = e;

	}
	
	@Override
	public void insert(T e) {
		if (empty()) {
			head = current = new Node<>(e);
			return;
		}

		Node<T> temp = current.next;
		current.next = new Node<>(e);
		current = current.next;
		current.next = temp;
	}

	@Override
	public void remove() {
		if (current == head)
			head = head.next;

		else {
			Node<T> temp = head;
			while (temp.next != current)
				temp = temp.next;
			temp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;

	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean empty() {
		return head == null;
	}

	@Override
	public boolean last() {
		return current.next == null;
	}

	public boolean find(T key) {
		Node<T> temp = head;
		while (temp != null) {
			if (temp.data.equals(key)) {
				current = temp;
				return true;
			}
			temp = temp.next;
		}
		return false;

	}
	
	//First Problem
	public void reverse() {
		if(empty() || head.next == null)
			return;
		
		Node<T> prev = null, curr = head, next = null;
		while(curr!= null) {
			next = curr.next; 
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

}
