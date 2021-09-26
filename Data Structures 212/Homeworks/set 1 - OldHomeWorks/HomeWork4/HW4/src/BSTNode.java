class BSTNode<T> {
	public int key;
	public T data;
	public BSTNode<T> left, right;

	public BSTNode(int key, T data) {
		this.key = key;
		this.data = data;
		left = right = null;
	}
}