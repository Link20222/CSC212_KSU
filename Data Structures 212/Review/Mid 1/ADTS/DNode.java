package ADTS;

public class DNode<T>
{
	public T data;
	public DNode<T> next;
	public DNode<T> previous;

	public DNode()
	{
		data = null;
		next = null;
		previous = null;
	}

	public DNode(T val)
	{
		data = val;
		next = null;
		previous= null;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public DNode<T> getNext()
	{
		return next;
	}

	public void setNext(DNode<T> next)
	{
		this.next = next;
	}

	public DNode<T> getPrevious()
	{
		return previous;
	}

	public void setPrevious(DNode<T> previous)
	{
		this.previous = previous;
	}
}