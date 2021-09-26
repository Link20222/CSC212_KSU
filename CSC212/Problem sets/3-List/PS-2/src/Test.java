
public class Test {

	public static void main(String[] args) {
		/*
		 * LinkedList<Integer> l1 = new LinkedList<>(); LinkedList<Integer> l2 = new
		 * LinkedList<>(); l1.insert(1); l1.insert(2); l1.insert(3); l1.insert(4);
		 * l2.insert(3); l2.insert(4);
		 * 
		 * // printList(l1); // printList(l2);
		 * 
		 * // insertAll(l1, l2, 1); // printList(l1);
		 * 
		 * LinkedList<Integer> c1 = new LinkedList<>(); commonE(l1, l2, c1);
		 * printList(c1);
		 * 
		 * LinkedList<Character> l = new LinkedList<>(); l.insert('a'); l.insert('c');
		 * l.insert('d'); l.insert('b'); l.insert('r'); l.insert('x');
		 * 
		 * moveToEnd(l,2); printList(l);
		 */

		/*
		 * LinkedList<Integer> l1 = new LinkedList<>(); l1.insert(1); l1.insert(2);
		 * l1.insert(3); l1.insert(4); l1.insert(2); l1.insert(5); l1.insert(3);
		 * 
		 * System.out.println(mfe(l1));
		 */
		LinkedList<Character> l1 = new LinkedList<>();
		LinkedList<Character> l2 = new LinkedList<>();

		l1.insert('a');
		l1.insert('b');
		l1.insert('c');
		//l1.insert('d');
		Character e = 'd';
		insertUnique(l1,e);

		l2.insert('c');
		l2.insert('x');
		l2.insert('b');

		printList(l1);
		printList(l2);

		System.out.print(check(l1, l2));

	}

	public static <T> void printList(List<T> l) {
		l.findFirst();

		int count = 1;
		while (!l.last()) {
			count++;
			l.findNext();
		}

		l.findFirst();
		for (int i = 1; i <= count; i++) {
			System.out.print(l.retrieve() + " ");
			l.findNext();
		}

		System.out.println();
	}

	// 3.1

	// 1
	public static <T> void clear(ArrayList<T> l) {
		l.findFirst();
		while (!l.empty()) // stops when size == 0 for an array and head == null
			l.remove();
	}

	// 2
	public static <T> void insertAll(List<T> l1, List<T> l2, int i) {
		if (l2.empty())
			return;

		l1.findFirst();

		for (int j = 0; j < i; j++) // find the ith element
			l1.findNext();

		l2.findFirst();

		while (!l2.last()) { // insert them into l1
			l1.insert(l2.retrieve());
			l2.findNext();
		}

		l1.insert(l2.retrieve());
	}

	// 3
	public static <T> void commonE(List<T> l1, List<T> l2, List<T> c1) {
		l1.findFirst();
		while (!l1.last()) {
			l2.findFirst();
			while (!l2.last()) {
				if (l1.retrieve().equals(l2.retrieve())) { // compares the element of l1 to every element of l2 besides
															// the last elements of both
					c1.insert(l2.retrieve());
				}
				l2.findNext();
			}

			if (l1.retrieve().equals(l2.retrieve())) // compares the last element of l2 to l1
				c1.insert(l2.retrieve());

			l1.findNext();
		}

		if (l1.retrieve().equals(l2.retrieve())) // compares the last element of l1 to the last element of l2
			c1.insert(l2.retrieve());

	}

	// 4
	public static <T> void moveToEnd(List<T> l, int i) {
		if (l.empty())
			return;

		l.findFirst();
		for (int j = 0; j < i; j++) // find the ith element
			l.findNext();

		T temp = l.retrieve(); // store it
		l.remove(); // remove it

		while (!l.last()) // reach the last element
			l.findNext();

		l.insert(temp);
	}

	// 5
	public static <T> T mfe(List<T> l) {
		int count = 1; // knowing the size of the list
		l.findFirst();
		while (!l.last()) {
			count++;
			l.findNext();
		}

		T freqEl = null; // the most frequent element is stored here
		int freq = 0; // the frequency of the element is stored here

		for (int i = 0; i < count; i++) { // loops through the entire list
			int curFreq = 0; // for comparison purposes
			T temp; // for comparison

			l.findFirst();
			for (int j = 0; j < i; j++) // to give temp a new value based on i
				l.findNext();

			temp = l.retrieve();

			l.findFirst();
			for (int j = 0; j < count; j++) { // loops through and compares every element to temp
				if (l.retrieve().equals(temp))
					curFreq++;
				l.findNext();
			}

			if (curFreq > freq) { // make the decision by comparing your current and maximum frequency
				freq = curFreq;
				freqEl = temp;
			}
		}

		return freqEl;
	}

	public static <T> boolean check(List<T> l1, List<T> l2) {
		l2.findFirst();
		while (!l2.last()) {
			l1.findFirst();
			while (!l1.retrieve().equals(l2.retrieve()) && (!l1.last()))
				l1.findNext();
			if (!l1.retrieve().equals(l2.retrieve()))
				return false;
			l2.findNext();
		}
		return true;
	}

	public static <T> void insertUnique(List<T> l, T e) {
		if (l.empty()) {
			l.insert(e);
			return;
		}
		
		l.findFirst();
		while (!l.last()) {
			if (l.retrieve().equals(e))
				return;
			l.findNext();
		}
		l.insert(e);
	}

}
