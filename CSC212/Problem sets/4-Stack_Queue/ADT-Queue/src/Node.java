public class Node<T> {
	T data;
	Node<T> next;
	Node<T> previous; // only when using doubly linked lists!!!

	public Node() {
		data = null;
		next = null;
		previous = null;
	}

	public Node(T val) {
		data = val;
		next = null;
		previous = null;
	}


}
