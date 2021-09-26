package recursive;

public class ArrayQueue <T>
{
    private int maxsize;
    private int size;
    private int head, tail;
    private T[] nodes;

    public ArrayQueue(int n)
    {
    	maxsize = n;
        size = 0;
        head = tail = 0;
        nodes = (T[]) new Object[n];
    }

    public boolean full ()
    {
    	return size == maxsize ? true : false;
    }

    public int length ()
    {
    	return size;
    }

    public void enqueue(T e)
    {
        nodes[tail] = e;
        tail = (tail + 1) % maxsize;
        size++;
    }

    public T serve ()
    {
    	T e = nodes[head];
    	head = (head + 1) % maxsize;
    	size--;

    	return e;
    }

	public void PrintQueue()
	{
		recPrintQueue(head, size);
	}

	private void recPrintQueue(int i, int n)
	{
		if(n == 0)
			return;
		
		System.out.println(nodes[i % maxsize]);
		
		recPrintQueue(i+1,n-1);
	}

	public void PrintQueue2()
	{
		recPrintQueueReverse(head, size);
	}

	private void recPrintQueueReverse(int i, int n)
	{
		if(n == 0)
			return;
		
		recPrintQueueReverse(i+1,n-1);
	
		System.out.println(nodes[i % maxsize]);
	}
}