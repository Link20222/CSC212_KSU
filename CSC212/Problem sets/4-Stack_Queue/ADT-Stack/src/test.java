
public class test {

	public static void main(String[] args) {
		LinkedStack<Integer> st1 = new LinkedStack<>();
		st1.push(7);
		st1.push(5);
		st1.push(10);
		st1.push(11);
		st1.push(3);
		st1.push(7);
		print(st1);
		System.out.println(topEqualsBottom(st1));
	}

	public static <T> void print(Stack<T> st) {
		if (st.empty())
			return;
		T e = st.pop();
		System.out.println(e);
		print(st);
		st.push(e);
	}
	// Tutorial 6 P1:

	public static <T> void replace(Stack<T> st, T e1, T e2) {
		LinkedStack<T> st1 = new LinkedStack<>();
		while (!st.empty()) {
			T temp = st.pop();
			if (temp.equals(e1))
				st1.push(e2);
			else
				st1.push(temp);
		}
		while (!st.empty())
			st.push(st1.pop());
	}

	public static <T> void copy(Stack<T> st1, Stack<T> st2) {
		if (st1.empty())
			return;
		T e = st1.pop();
		copy(st1, st2);
		st2.push(e);
		st1.push(e);
	}

	public static <T> boolean search(Stack<T> st, T target) {
		if (st.empty())
			return false;
		T e = st.pop();
		if (!e.equals(target))
			search(st, target);
		st.push(e);
		return true;
	}

	/*
	 * PS SOLUTIONS P.4.6
	 */

	// 1)
	public static <T> Stack<T> concat(Stack<T> st1, Stack<T> st2) {
		LinkedStack<T> result = new LinkedStack<>();
		LinkedStack<T> temp = new LinkedStack<>();

		while (!st1.empty()) // push the first stack in temp
			temp.push(st1.pop());

		while (!temp.empty()) {
			T e = temp.pop();
			st1.push(e); // return the elements to st1
			result.push(e); // concat
		}

		while (!st2.empty()) // push the second stack in temp
			temp.push(st2.pop());

		while (!temp.empty()) {
			T e = temp.pop();
			st2.push(e); // return the elements to st2
			result.push(e); // concat
		}
		return result;
	}

	// 2)
	public <T> void pushBack(Stack<T> st, int p) {
		LinkedStack<T> temp = new LinkedStack<>();
		for (int i = 1; i < p; i++)
			temp.push(st.pop());
		for (int i = 1; i < p; i++)
			st.push(temp.pop());
	}

	// 3)
	public boolean checkTotalTop(Stack<Integer> st) {
		int top = st.pop(), sum = 0;
		LinkedStack<Integer> temp = new LinkedStack<>();

		while (!st.empty())
			temp.push(st.pop());

		while (!temp.empty()) {
			int e = temp.pop();
			sum += e;
			st.push(e);
		}

		st.push(top);
		return sum == top;
	}

	// 4)
	public static <T> void moveAfter(Stack<T> st1, Stack<T> st2, int i) {
		LinkedStack<T> temp = new LinkedStack<>();
		for (int j = 0; j <= i; j++)
			temp.push(st1.pop());

		while (!st2.empty())
			temp.push(st2.pop());

		while (!temp.empty())
			st1.push(temp.pop());
	}

	// 5)
	public static <T> int countEquals(Stack<T> st, T e) {
		LinkedStack<T> temp = new LinkedStack<>();
		int sum = 0;

		while (!st.empty()) {
			T f = st.pop();
			if (f.equals(e))
				sum++;
			temp.push(f);
		}

		while (!temp.empty())
			st.push(temp.pop());

		return sum;
	}

	// 6)
	public static <T> void removeLast(Stack<T> st) {
		LinkedStack<T> temp = new LinkedStack<>();
		while (!st.empty())
			temp.push(st.pop());

		temp.pop(); // remove the last element

		while (!temp.empty())
			st.push(temp.pop());
	}

	// 7)
	public static boolean topEqualsBottom(Stack<Integer> st) {
		LinkedStack<Integer> temp = new LinkedStack<>();
		Integer e = st.pop();
		temp.push(e);
		while (!st.empty())
			temp.push(st.pop());

		Integer p = temp.pop();
		st.push(p);

		while (!temp.empty())
			st.push(temp.pop());

		return e.equals(p);
	}

	// 8)
	public <T> void pullUpBottom(Stack<T> st) {
		LinkedStack<T> temp = new LinkedStack<>();
		while (!st.empty())
			temp.push(st.pop());

		T e = temp.pop();

		while (!temp.empty())
			st.push(temp.pop());

		st.push(e);
	}

	// 9)
	public static Stack<Character> replace(Stack<Character> st, char a, char b) {
		LinkedStack<Character> result = new LinkedStack<>();
		LinkedStack<Character> temp = new LinkedStack<>();

		while (!st.empty())
			temp.push(st.pop());

		while (!temp.empty()) {
			char e = temp.pop();
			st.push(e);
			if (e == a)
				result.push(b);
			else
				result.push(e);
		}

		return result;
	}

	// 10)
	public static <T> int nbCommon(Stack<T> st1, Stack<T> st2) {
		LinkedStack<T> temp1 = new LinkedStack<>();
		LinkedStack<T> temp2 = new LinkedStack<>();
		int count = 0;

		while (!st1.empty()) {
			T e = st1.pop();
			temp1.push(e);
			while (!st2.empty()) {
				T f = st2.pop();
				if (e.equals(f))
					count++;
				temp2.push(f);
			}
		}
		while (!st1.empty())
			st1.push(temp1.pop());

		while (!st2.empty())
			st2.push(temp2.pop());

		return count;
	}

	/*
	 * P.4.7
	 */

	// 1)
	public static <T> void removeAll(Stack<T> st) {
		if (st.empty())
			return;
		st.pop();
		removeAll(st);
	}

	// 3)
	public static <T> void removeEle(Stack<T> st, T e) {
		if (st.empty())
			return;
		T f = st.pop();
		removeEle(st, e);
		if (!e.equals(f))
			st.push(e);
	}

	// 4)
	public static int stackSum(Stack<Integer> st) {
		if (st.empty())
			return 0;
		
		int e = st.pop();
		int sum = e + stackSum(st);
		st.push(e);
		return sum;
	}
	
	// 5)  -- :)
	
	public static<T> int searchElm(Stack<T> st, T e) {
		int index = -1, i = 1;
		LinkedStack<T> temp = new LinkedStack<>();
		while(!st.empty()) {
			T f = st.pop();
			if(f.equals(e)) {
				index = i;
				st.push(f);
				break;
			}
			temp.push(f);
			i++;
		}
		while(!temp.empty())
			st.push(temp.pop());
		return index;
	}

}
