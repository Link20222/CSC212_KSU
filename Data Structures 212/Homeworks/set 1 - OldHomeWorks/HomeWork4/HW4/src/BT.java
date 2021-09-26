
public class BT<T> {
	public BTNode<T> root, current;

	public BT() {
		root = current = null;
	}

	public boolean empty() {
		return root == null;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T val) {
		current.data = val;
	}

	public boolean insert(Relative rel, T val) {
		switch (rel) {
		case Root:
			if (!empty())
				return false;
			current = root = new BTNode<T>(val);
			return true;
		case Parent:
			return false;
		case LeftChild:
			if (current.left != null)
				return false;
			current.left = new BTNode<T>(val);
			current = current.left;
			return true;
		case RightChild:
			if (current.right != null)
				return false;
			current.right = new BTNode<T>(val);
			current = current.right;
			return true;
		default:
			return false;

		}
	}

	public void deletSubtree() {
		if (current == root)
			current = root = null;
		else {
			BTNode<T> p = current;
			find(Relative.Parent);
			if (current.left == p)
				current.left = null;
			else
				current.right = null;
			current = root;

		}
	}

	public boolean find(Relative rel) {
		switch (rel) {
		case Root:
			current = root;
			return true;
		case Parent:
			if (current == root)
				return false;
			current = findparent(current, root);
			return true;
		case LeftChild:
			if (current.left == null)
				return false;
			current = current.left;
			return true;
		case RightChild:
			if (current.right == null)
				return false;
			current = current.right;
			return true;
		default:
			return false;

		}

	}

	private BTNode<T> findparent(BTNode<T> p, BTNode<T> t) {
		LinkedStack<BTNode<T>> stack = new LinkedStack<BTNode<T>>();
		BTNode<T> q = t;
		while (q.right != p && q.left != p) {
			if (q.right != null)
				stack.push(q.right);
			if (q.left != null)
				q = q.left;
			else
				q = stack.pop();

		}
		return q;
	}

	// problem1.1
	private boolean areMirror(BTNode<T> t1, BTNode<T> t2) {
		if ((t1 == null) != (t2 == null))
			return false;
		if (t1 == null)
			return true;
		return (t1.data.equals(t2.data) && areMirror(t1.left, t2.right) && areMirror(t1.right, t2.left));
	}

	//problem 1.2
	private void swap(BTNode<T> t) {
		LinkedStack<BTNode<T>> stack = new LinkedStack<BTNode<T>>();
		BTNode<T> q = t;
		T tmp;
		while (q != null) {
			if (q.right != null)
				stack.push(q.right);
			if (q.left != null) {
				tmp = q.data;
				q.data = q.left.data;
				q.left.data = tmp;
				q = q.left;
			} else {
				if (q.right != null) {
					tmp = q.data;
					q.data = q.right.data;
					q.right.data = tmp;
				}
				if (!stack.empty())
					q = stack.pop();
				else
					q = null;
			}//end outer else
		}//end while
	}//end swap

	//problem 2.2
	public LinkedList<T> collectLeaves(){
		LinkedList<T> tmp = new LinkedList<T>();
		BTNode<T> p = root;
		return collectLeaves(tmp,p);
	}
	public LinkedList<T> collectLeaves(LinkedList<T> tmp , BTNode<T>p){
		if (p == null)
			return tmp;
		if(p.left==null && p.right == null)
			tmp.insert(p.data);
		collectLeaves(tmp,p.left);
		collectLeaves(tmp,p.right);
		return tmp;
	}
	
	 public void print(){
		 recprint(root);
	 }
	 
	 public void recprint(BTNode<T> p){
		 if (p==null)
			 return;
		 recprint(p.left);
		 System.out.print(p.data + ",");
		 recprint(p.right);

	}
}