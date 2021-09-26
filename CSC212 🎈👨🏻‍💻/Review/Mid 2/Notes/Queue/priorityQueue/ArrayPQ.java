package priorityQueue;

public class ArrayPQ<T>
{
	private int size;
	public  int head,tail;
	private int maxSize;
	private PElementArray<T> nodes[];

	public ArrayPQ(int n)
	{
		maxSize = n;
		size = 0;
		head = 0;
		tail = 0;
		nodes = new PElementArray[n];
	}

	public int length()
	{
		return size;
	}

	int inc(int a)
	{
		return (a + 1)% maxSize;
	}

	int dec(int a)
	{
		if (a == 0) 
			return maxSize;
		else 
			return a - 1;
	}

	public boolean full()
	{
		return size == maxSize;
	}


	void enqueue(T e, int pty)
	{
		if (full())
			return;
		else
		{
			int loc = head;
			int all = length();
			boolean stop = false;
			int k;

			while (all != 0 && !stop)
			{
				if (nodes[loc].getPriority() > pty)
					stop = true;
				else
				{
					all--;
					loc = inc(loc);
				}
			}

			for (int j = inc(tail); j != loc; j = dec(j))
			{
				k = dec(j);
				nodes[j] = nodes[k];
			}

			nodes[loc] = new PElementArray<T>(e, pty);
			size++;
			tail = inc(tail);
		}
	}

	public PElementArray<T> serve()
	{
		PElementArray<T> e = nodes[head];

		head = (head + 1) % maxSize;
		size--;

		return e;
	}
}