
public interface BT<T> {
	boolean empty();

	boolean full();

	boolean find(Relative rel);

	T retrieve();

	void update(T val);

	boolean insert(T val, Relative rel);

	// Delete subtree at current. The parent, if it exists, becomes the current.
	void deleteSub();

	// Returns true if current is a leaf node.
	boolean isLeaf();

	// Return the root of the tree. This method is for testing purposes only. Do not
	// use it in your code.
	BTNode<T> getRoot();
}
