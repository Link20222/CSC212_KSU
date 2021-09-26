package recursive;

public class TestRecursive
{
	public static void main(String[] args)
	{
/*		LinkList<Character> l = new LinkList<Character>();
		l.insert('a');
		l.insert('b');
		l.insert('c');
		l.insert('d');
		l.insert('e');

		//l.findfirst();
		System.out.println(SearchList(l,'q'));
		*/
		
		ArrayQueue<Integer> q1 = new ArrayQueue<Integer>(10);
		q1.enqueue(1);
		q1.enqueue(2);
		q1.enqueue(3);
		q1.enqueue(4);
		q1.enqueue(5);
		q1.enqueue(6);
		q1.enqueue(7);

		q1.PrintQueue2();
	}

	public static int power(int base, int exponent)
	{
		if(exponent == 0)
			return 1;
		
		if(exponent == 1)
			return base;

		return base * power(base, exponent -1);
	}
	
	public static int fact(int n)
	{
		if (n == 1)
			return 1;
		else
			return n * fact(n - 1);
	}

	public static int sumArray(int a[],int n)
	{
		if (n == 0)
			return a[n];
		else
			return a[n] + sumArray(a, n-1);
	}

	public static <T> boolean recSearch(LinkList<T> l, T e)
	{
		if(l.empty())
			return false;

		if (! l.last())
		{
			if(l.retrieve().equals(e))
				return true;
		
			l.findnext();
	
			return recSearch(l, e);
		}
		else
		{
			if(l.retrieve().equals(e))
				return true;
			else
				return false;
		}
	}

	public static <T> boolean SearchList(LinkList<T> l, T e)
	{
		if(l.empty())
			return false;

		l.findfirst();

		return recSearch2(l, e);
	}

	private static <T> boolean recSearch2(LinkList<T> l, T e)
	{
		if(l.last())
			return l.retrieve().equals(e);

		if(l.retrieve().equals(e))
			return true;

		l.findnext();

		return recSearch2(l, e);	
	}
	
	public static <T> void PrintQueue(LinkQueue<T> q)
	{
		recPQ(q, q.length());
	}
	
	private static <T> void recPQ(LinkQueue<T> q, int n)
	{
		if(n == 0)
			return;
		
		T x = q.serve();
		q.enqueue(x);
		
		System.out.println(x);
		
		recPQ(q, n-1);
	}
	
	public static <T> void PrintQueueReverse(LinkQueue<T> q)
	{
		recPQReverse(q, q.length());
	}

	private static <T> void recPQReverse(LinkQueue<T> q, int n)
	{
		if(n == 0)
			return;
		
		T x = q.serve();
		q.enqueue(x);

		recPQReverse(q, n-1);
		
		System.out.println(x);		
	}
	
	public static <T> void PrintQueue2(LinkQueue<T> q)
	{
		if(q.length() == 0)
			return;

		T x = q.serve();

		System.out.println(x);

		PrintQueue(q);

		q.enqueue(x);
		
		for(int i = 0; i < q.length() - 1; i++)
			q.enqueue(q.serve());
	}
	
	public static <T> void ReverseQueue(LinkQueue<T> q)
	{
		if(q.length() == 0)
			return;

		T x = q.serve();

		ReverseQueue(q);

		q.enqueue(x);
	}
}