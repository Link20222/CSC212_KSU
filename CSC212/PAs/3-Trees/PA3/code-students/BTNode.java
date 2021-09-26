class BTNode<T> {
	public T data;
	public BTNode<T> left, right, parent;

	public BTNode(T data) {
		this.data = data;
		parent = left = right = null;
	}
}
