package ADTS;

public class DoubleLinkedList<T>
{
	private DNode<T> head;
	private DNode<T> current;
	
	public DoubleLinkedList()
	{
		head = current = null;
	}

	public boolean empty()
	{
		return head == null;
	}
	
	public boolean last()
	{
		return current.next == null;
	}

	public boolean full()
	{
		return false;
	}

	public boolean first()
	{
		return current.previous == null;
	}

	public void findFirst()
	{
		current = head;
	}
	
	public void findNext()
	{
		current = current.next;
	}
	
	public void findPrevious()
	{
		current = current.previous;
	}

	public T retrieve()
	{
		return current.data;
	}

	public void update(T val)
	{
		current.data = val;
	}
	
	public void insert(T val)
	{
		DNode<T> tmp = new DNode<T>(val);
		
		if(empty())
		{
			current = head = tmp;
		}
		else
		{
			tmp.next = current.next;
			tmp.previous = current;
		
			if(current.next != null)
				current.next.previous = tmp;
			
			current.next = tmp;
			current = tmp;
		}
	}
}