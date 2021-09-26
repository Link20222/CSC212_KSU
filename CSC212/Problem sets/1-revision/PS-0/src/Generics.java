
public class Generics {

	public static void main(String[] args) {
		// 1.6
		Integer[] exchangeArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		exchange(exchangeArray, 2, 3);

		for (int i = 0; i < exchangeArray.length; i++)
			System.out.print(exchangeArray[i] + " ");

		Integer[] countArray = { 2, 2, 1, 3, 4, 5, 2, 2, 2, 1, 4, 2 };

		System.out.println("\nThe Frequency is: " + countVar(countArray, 2, countArray.length - 1));

		Integer[] reverseArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		reverse(reverseArray, 4);
		for (int i = 0; i < reverseArray.length; i++)
			System.out.print(reverseArray[i] + " ");

		System.out.println("\n__________________________________");

		// 1.7
		GArray<Integer> genericArray = new GArray<>(2);
		genericArray.set(0, 1);
		genericArray.set(1, 2);

		System.out.println("The First Element is: " + genericArray.get(0));
		System.out.println("The second Element is: " + genericArray.get(1));

		System.out.println("\n__________________________________");

		// 1.8
		Integer[] A = { 1, 2, 3 };
		String[] B = { "one", "two", "three" };

		GArray<Pair<Integer, String>> pArray = pair(A, B, 3);

		System.out.println(pArray.get(0).getFirst().getClass().getName());

		System.out.println("\n__________________________________");

		// 1.9
		test();

		System.out.println("\n__________________________________");

		// 1.10

		Integer[] a = { 2, 4, 1 };
		Integer[] b = { 7, 2, 4, 9 };

		System.out.println("The Number of Common Elements is: " + commonElement(a, 3, b, 4));
		
		System.out.println("\n__________________________________");
		
		//1.11
		String [] str = {"C","F","A","A","B","A","A","C","S","A","A","C","A","A"};
		String [] tem ={"A","A","C"};
		
		
		System.out.println("The Index is: "+ subString(str, str.length, tem, tem.length));

	}

	/*
	 * 1.6 Write a generic method to exchange the positions of two different
	 * elements in an array.
	 */
	public static <T> void exchange(T[] A, T a, T b) {
		int indexOfa = 0, indexOfb = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i].equals(a))
				indexOfa = i;
			if (A[i].equals(b))
				indexOfb = i;
		}

		T temp;
		if (!(indexOfa == 0 && indexOfb == 0)) {
			temp = A[indexOfa];
			A[indexOfa] = A[indexOfb];
			A[indexOfb] = temp;
		}
	}

	/*
	 * Write a generic method for counting the number of times that a given variable
	 * occurs in an array
	 */
	public static <T> int countVar(T[] A, T var, int n) {

		if (n == 0)
			if (!A[n].equals(var))
				return 0;
			else
				return 1;

		if (A[n].equals(var))
			return 1 + countVar(A, var, n - 1);

		return countVar(A, var, n - 1);
	}

	/*
	 * Write the generic method that takes as input a generic array and reverse the
	 * order of its n first elements.
	 */
	public static <T> void reverse(T[] A, int n) {
		reverse(A, 0, n);
	}

	private static <T> void reverse(T[] A, int l, int r) {
		if (l >= r)
			return;

		T temp = A[l];
		A[l] = A[r];
		A[r] = temp;

		reverse(A, l + 1, r - 1);
	}

	/*
	 * 1.8 Write a method which creates a GArray of pairs from the first n elements
	 * of A and B by pairing each element from A with the element from B at the same
	 * index.
	 */
	public static <T, U> GArray<Pair<T, U>> pair(T[] A, U[] B, int n) {
		GArray<Pair<T, U>> pArray = new GArray<>(n);

		for (int i = 0; i < n; i++) {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			Pair<T, U> temp = new Pair(A[i], B[i]);
			pArray.set(i, temp);
		}
		return pArray;
	}

	/*
	 * 1.9 Write a method which sorts the n first elements of A in increasing order
	 * if incr is true, or decreasing order if incr is false.
	 */
	public static <T extends Comparable<T>> void sort(T[] A, int n, boolean incr) {

		if (incr) {
			increase(A, n);
		} else {
			increase(A, n);
			reverse(A, n - 1);
		}

	}

	private static <T extends Comparable<T>> void increase(T[] A, int n) {
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++) {
				if (A[i].compareTo(A[j]) > 0) {
					T temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
	}

	public static void test() {
		Integer[] A = { 2, 3, 5, 6, 0, 1, 4 };
		sort(A, A.length, true);

		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");

		sort(A, A.length, false);
		System.out.println();
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");

		System.out.println("\n__________________________________");

	}

	/*
	 * 1.10 Write a method that takes as input two arrays A and B of size n and m
	 * respectively. The method returns the number of common elements between the
	 * two arrays.
	 */
	public static <T> int commonElement(T[] A, int n, T[] B, int m) {
		int size = Math.min(n, m);

		int count = 0;

		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (A[i].equals(B[j]))
					count++;

		return count;
	}
		
		// 1.11

	/*public static <T> int subString(T[] str, int n, T[] tem, int m) {
		int j;
		for (int i = 0; i <= n - m; i++) {
			for (j = 0; j < m; j++)
				if (!tem[i + j].equals(str[j]))
					break;

			if (j == m)
				return i;
		}

		return -1;

	}*/
	
	/*public static <T> int subString(T[] str, int n, T[] tem, int m) {
		int k =0;
		int j;
		boolean flag = false;
		for(int i = 0; i < n - m +1; i++) {
			for(j = 0; j < m; j++) {
				if(!str[j+i].equals(tem[j])) {
					flag = false;
				}
				
				//else {
				//	k++;
				//	i++;
				//}
			}
			flag = true;
			if(true) {
				return i;
			}
		}
		return -1;
	}*/
	
	public static <T> int subString(T[] str, int n, T[] tem, int m) {
	 int i = 0;
     while(i < str.length)
     {
         int found = i;
          int j = 0;
         while(j < tem.length && i < str.length && tem[j] == str[i])
         {
             i++;
             j++;
         }

         if(j == n-1)
         {
             return found;
         }

         i = found + 1;
     }

     return -1;
 }
	

}

// 1.7
class GArray<T> {
	T[] data;

	@SuppressWarnings("unchecked")
	public GArray(int size) { // size is the length of the array
		data = (T[]) new Object[size];
	}

	public T get(int i) { // Return the element at position i
		return data[i];
	}

	public void set(int i, T e) { // Put e at index i
		data[i] = e;
	}
}

// 1.8
class Pair<T, U> {
	public T first;
	public U second;

	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}
}
