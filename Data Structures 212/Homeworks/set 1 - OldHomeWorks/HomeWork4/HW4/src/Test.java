
public class Test {
	public static void main(String[] args) {
	/*	BT<Integer> bt = new BT<Integer>();
		bt.insert(Relative.Root, 10);
		bt.insert(Relative.LeftChild, 8);
		bt.find(Relative.Parent);
		bt.insert(Relative.RightChild, 12);
		bt.insert(Relative.LeftChild, 11);
		bt.find(Relative.Parent);
		bt.insert(Relative.RightChild, 15);
		bt.insert(Relative.RightChild, 20);
		bt.print();
		System.out.println(isBST(bt));
		LinkedList<Integer> tmp = collectLeaves(bt);
		tmp.findFirst();
		while (!tmp.empty()) {
			System.out.println(tmp.retrieve() + ",");
			tmp.remove();
		}
		System.out.println();
		System.out.println(find(bt,14));
		System.out.println(bt.retrieve());
		//bt.swap(bt.root);
		
		//bt.print();
		System.out.println();
		BT<Integer> bt2 = new BT<Integer>();
		bt2.insert(Relative.Root, 10);
		bt2.insert(Relative.RightChild, 8);
		bt2.find(Relative.Parent);
		bt2.insert(Relative.LeftChild, 12);
		bt2.insert(Relative.RightChild, 15);
		/// System.out.println(bt.areMirror(bt.root, bt2.root));
		 tmp = collectLeaves(bt);
		tmp.findFirst();
		while (!tmp.empty()) {
			System.out.println(tmp.retrieve() + ",");
			tmp.remove();
		}*/
		BST<Integer> bst = new BST<Integer>();


		//bst.print();
		System.out.println(bst.deepestKey(bst.root));
		System.out.println();
		
	//	bst.swapData(5);
		//bst.print();
      		System.out.println("Found:" + bst.insub(10,80));
	}

	// problem 2.1
	public static <T> LinkedList<T> collectLeaves(BT<T> bt) {
		LinkedList<T> tmp = new LinkedList<T>();
		bt.find(Relative.Root);
		return collectLeaves(bt, tmp);
	}

	private static <T> LinkedList<T> collectLeaves(BT<T> bt, LinkedList<T> tmp) {
		boolean flag = true;
		if (bt.find(Relative.LeftChild)) {
			flag = false;
			collectLeaves(bt, tmp);
			bt.find(Relative.Parent);
		}
		if (bt.find(Relative.RightChild)) {
			flag = false;
			collectLeaves(bt, tmp);
			bt.find(Relative.Parent);
		}

		if (flag)
			tmp.insert(bt.retrieve());

		return tmp;
	}
//problem 3.1
	public static boolean isBST(BT<Integer> bt){
		bt.find(Relative.Root);
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		isBST(bt,tmp);
		tmp.findFirst();
		Integer cur = null,p=null;
		while(!tmp.last()){
			cur=tmp.retrieve();
			if(p!= null)
				if(cur < p)
					return false;
			tmp.findNext();
			p=cur;
		}
		cur=tmp.retrieve();
		if(p!= null)
			if(cur<p)
				return false;
		
		return true;
	}
	public static void isBST(BT<Integer> bt, LinkedList<Integer> tmp){
		if (bt.find(Relative.LeftChild)) {
			isBST(bt, tmp);
			bt.find(Relative.Parent);
		}
		
		tmp.insert(bt.retrieve());
		
		if (bt.find(Relative.RightChild)) {
			isBST(bt, tmp);
			bt.find(Relative.Parent);
		}
	}
	// problem3.2
	public static boolean find(BT<Integer> bt, int k) {
		if (bt.empty())
			return false;
		bt.find(Relative.Root);

		return recFind(bt, k);
	}

	private static boolean recFind(BT<Integer> bt, int k) {

		if (bt.retrieve().equals(k))
			return true;

		if (bt.retrieve() > k) {
			if (bt.find(Relative.LeftChild)) {
				if (recFind(bt, k))
					return true;
			}
		} else {
			if (bt.find(Relative.RightChild)) {
				if (recFind(bt, k))
					return true;

			}
		}
		return false;
	}
	
	

}
