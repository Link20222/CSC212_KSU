// Class Node implementation
public class Node <T> {
	// Attributes
	private T data;
	private Node next;

	// Methods
	public Node(T obj) {
		data = obj;
		next = null;
	}

	public void setNext(Node nextPtr) {
		next = nextPtr;
	}

	public Node getNext() {
		return next;
	}

	public void setData(T obj) {
		data = obj;
	}

	public T getData() {
		return data;
	}

	public String toString() {
		return data.toString();
	}
} // end class
