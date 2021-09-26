package homeWork2;

public class Problem1 {

	/*public static <T> void fndIth(List<T> l, int i) { 

		if (!l.empty()) {
			l.findfirst();
			int count = 1;
			while (count != i && (!l.last())) {
				l.findnext();
				count++;
			}
		}
	}

	public static <T> void moveBack(List<T> l, int p) {
		int index = 1;
		while (!l.last()) {
			l.findnext();
			index++;
		}

		l.findfirst();
		int size = 1;
		while (!l.last()) {
			l.findnext();
			size++;
		}

		l.findfirst();
		for (int i = 0; i < size - index - p; i++)
			l.findnext();

	}
*/
	public static <T extends Comparable<T>> boolean areReversed(DoubleLinkedList<T> l1, DoubleLinkedList<T> l2) {

		l1.findFirst();
		l2.findFirst();
		int sizeL1 = 1, sizeL2 = 1;
		while (!l1.last()) {
			l1.findNext();
			sizeL1++;
		} // end while

		while (!l2.last()) {
			l2.findNext();
			sizeL2++;
		} // end while

		if (sizeL1 != sizeL2)
			return false;

		l1.findFirst();

		for (int i = 0; i < sizeL1; i++) {

			if (l1.retrieve().compareTo(l2.retrieve()) != 0)
				return false;
			if (!l1.last() && !l2.first()) {
				l1.findNext();
				l2.findPrevious();
			}
		}
		return true;

	}

	// problem4.1
	/*public static <T> void remove(Queue<T> q, int[] pos, int k) {
		
		int size = q.length();
		int index = 0;
		T data;

		for (int i = 0; i < size; i++) {
			data = q.serve();
			if (i != pos[index])
				q.enqueue(data);
			else if (index < k - 1)
				index++;

		}

	}*/

	// problem5
	// public static LinkedList<ItemPair> minPairing(LinkedList<Item> items) {
// 		LinkedPQ<Item> temp = new LinkedPQ<Item>();
// 		LinkedList<ItemPair> list = new LinkedList<ItemPair>();
// 		ItemPair b;
// 		int size;
// 
// 		items.findfirst();
// 		while (!items.last()) {
// 			temp.enqueue(items.retrieve(), items.retrieve().getPrice());
// 			items.findnext();
// 		}
// 		temp.enqueue(items.retrieve(), items.retrieve().getPrice());
// 
// 		size = temp.length();
// 
// 		for (int x = 0; x < size; x = x + 2) {
// 			b = new ItemPair(temp.serve().data, temp.serve().data);
// 			list.insert(b);
// 		}
// 		if (size % 2 != 0) {
// 			b = new ItemPair(temp.serve().data, null);
// 			list.insert(b);
// 		}
// 
// 		return list;
// 	}
// 
// 	public static LinkedList<ItemPair> maxPairing(LinkedList<Item> items) {
// 		LinkedPQ<Item> temp = new LinkedPQ<Item>();
// 		LinkedList<ItemPair> list = new LinkedList<ItemPair>();
// 		ItemPair b;
// 		int size;
// 
// 		items.findfirst();
// 		while (!items.last()) {
// 			temp.enqueue(items.retrieve(), items.retrieve().getPrice());
// 			items.findnext();
// 		}
// 		temp.enqueue(items.retrieve(), items.retrieve().getPrice());
// 		size = temp.length();
// 
// 		LinkedList<Item> tempList = new LinkedList<Item>();
// 		for (int i = 0; i < size; i++)
// 			tempList.insert(temp.serve().data);
// 
// 		Item item1, item2;
// 		while (!tempList.empty()) {
// 			tempList.findfirst();
// 			item1 = tempList.retrieve();
// 			tempList.remove();
// 			if (!tempList.empty()) {
// 				while (!tempList.last())
// 					tempList.findnext();
// 
// 				item2 = tempList.retrieve();
// 				tempList.remove();
// 			} else
// 				item2 = null;
// 
// 			b = new ItemPair(item1, item2);
// 			list.insert(b);
// 		}
// 
// 		return list;
// 
// 	}
// 
// 	public static LinkedList<ItemPair> maxPairing2(LinkedList<Item> items) {
// 		LinkedPQ<Item> temp = new LinkedPQ<Item>();
// 		LinkedList<ItemPair> list = new LinkedList<ItemPair>();
// 		ItemPair b;
// 		int size;
// 
// 		items.findfirst();
// 		while (!items.last()) {
// 			temp.enqueue(items.retrieve(), items.retrieve().getPrice());
// 			items.findnext();
// 		}
// 		temp.enqueue(items.retrieve(), items.retrieve().getPrice());
// 		size = temp.length();
// 		PQElement<Item>[] tempArr = (PQElement<Item>[]) new PQElement<?>[size];
// 
// 		for (int i = 0; i < size; i++)
// 			tempArr[i] = temp.serve();
// 
// 		for (int x = 0; x < size / 2; x++) {
// 			b = new ItemPair(tempArr[x].data, tempArr[tempArr.length - (x + 1)].data);
// 			list.insert(b);
// 		}
// 
// 		return list;
// 	}
   public static<T> void Reversed(DoubleLinkedList<T> l){
   DoubleLinkedList<T> R = l;
   while(!R.last())
   R.findNext();
   
   l.findFirst();
   while(!l.last() && !R.first()){
   T temp = R.retrieve();
   System.out.println(temp);
   R.update(l.retrieve());
   l.update(temp);
   l.findNext();
   R.findPrevious();
   }
   }

	public static void main(String[] args) {
		DoubleLinkedList<String> a = new DoubleLinkedList<String>();
		DoubleLinkedList<String> b = new DoubleLinkedList<String>();
		LinkedQueue<String> s = new LinkedQueue<String>();
		LinkedList<String> l = new LinkedList<String>();
		ArrayPQ<String> ar = new ArrayPQ<String>(5);
		// ar.enqueue("A", 3);

// 		ar.enqueue("B", 2);
// 		ar.enqueue("D", 4);
// 		ar.enqueue("E", 5);
// 		ar.enqueue("c", 3);
// 		ar.enqueue("R", 6);
// 		ar.serve();
// 		ar.serve();
// 		ar.enqueue("R", 7);
// 		ar.enqueue("S", 7);
// 		int size = ar.length();
// 		
// 		for (int i = 0; i <size ; i++)
// 			System.out.print(ar.serve());
// 
// 		int[] pos = { 1, 2, 7 };
// 		s.enqueue("A");
// 		s.enqueue("B");
// 		s.enqueue("C");
// 		s.enqueue("D");
// 		s.enqueue("E");
// 		s.enqueue("F");
// 		s.enqueue("G");
		s.enqueue("H");
		//remove(s, pos, 3);

	//	for (int i = 0; i < 5; i++)
		//	System.out.print(s.serve());
		a.insert("1");
		a.insert("2");
		a.insert("3");
		a.insert("4");
		a.insert("5");
      a.findFirst();
      Reversed(a);
      
      a.findFirst();
	for (int i = 0; i < 5; i++){
		System.out.print(a.retrieve());
      a.findNext();
      }

	// 	l.insert("A");
// 		l.insert("B");
// 		l.insert("C");
// 		l.insert("D");
// 		l.insert("E");
// 		l.insert("F");
// 		l.insert("G");
// 		l.insert("H");
// 		//fndIth(l, 1);
// 		// moveBack(l,4);
// 		// l.insertBeforeCurrent("c2");
// 		b.insert("H");
// 		b.insert("G");
// 		b.insert("F");
// 		b.insert("E");
// 		b.insert("D");
// 		b.insert("C");
// 		b.insert("B");
// 		b.insert("A");

		// System.out.println(areReversed(a,b));
		// System.out.print(l.retrieve());
		// l.findfirst();
		// for(int i=0 ; i<9 ;i++){
		// System.out.print(l.retrieve());
		// l.findnext();
		// }
	}

}
