package queue;

public class TestQueue
{
	public static void main(String[] args)
	{
		LinkQueue<Integer> q1 = new LinkQueue<Integer>();
		for (int i = 1 ; i <= 10 ; i++)
			q1.enqueue(i);

		displayQueue(q1);
		addFirstRec(q1, 33, q1.length());
		displayQueue(q1);
	}

	public static <T> void addFirst(LinkQueue<T> q, T e)
	{
		q.enqueue(e);
	
		for(int i = 0; i < q.length() - 1; i++)
			q.enqueue(q.serve());
	}

	public static <T> void addFirstRec(LinkQueue<T> q, T e, int n)
	{
		if (n == 0)
			return;

		if(n == q.length())
			q.enqueue(e);

		T x = q.serve();
		q.enqueue(x);

		addFirstRec(q,e, n-1);
	}

	public static <T> void displayQueue(LinkQueue<T> q1)
	{
		T x;

		for (int i = 1 ; i <= q1.length() ; i++)
		{
			x = q1.serve();
			q1.enqueue(x);

			if (i == q1.length())
				System.out.println(x);
			else
				System.out.print(x + ", ");		
		}
	}
	/*
	public void addLast(T e) {
	q.enqueue(e);
	n++;
	}
	public T removeFirst() {
	n−−;
	return q.serve();
	}
	public T getFirst() {
	T x = q.serve();
	q.enqueue(x);
	for(int i = 0; i < q.length() − 1; i++)
	q.enqueue(q.serve());
	return x;
	}
	public T getLast() {
	for(int i = 0; i < q.length() − 1; i++)
	q.enqueue(q.serve());
	T x = q.serve();
	q.enqueue(x);
	return x;
	}
	public int size() {
	return n;
	}
	}
	public boolean isEmpty() {
	return n == 0;
	}
	public static<T> void removeEquals(Queue<T> q, T e) {
	int n = q.length();
	for(int i = 0; i < n; i++) {
	T x = q.serve();
	if(!x.equals(e))
	q.enqueue(x);
	}
	}
	public static<T> boolean find(Queue<T> q, T e) {
	boolean found = false;
	int n = q.length();
	for(int i = 0; i < n; i++) {
	T x = q.serve();
	if(x.equals(e))
	found = true;
	q.enqueue(x);
	}
	}
	return found;*/
}