public class SentDLinkList <T>
{
    private DNode<T> head,tail;
    private DNode<T> current;

    public SentDLinkList()
    {
    	head = current = new DNode<T>();
    	tail = new DNode<T>();
    	head.next = tail;
    	tail.prev = head;
    }

    public boolean empty()
    {
    	return head.next == tail;
    }

    public boolean last()
    {
    	return current.next == tail;
    }

    public boolean full()
    {
    	return false;
    }

    public void findfirst()
    {
        current = head.next;
    }

    public void findnext() 
    {
        current = current.next;
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
    	tmp.next = current.next;
    	tmp.prev = current;
    	current.next.prev = tmp;
    	current.next = tmp;
    	current = tmp;
    }

    public void remove()
    {
    	DNode<T> tmp = current.prev;
    	tmp.next = current.next;
    	current.next.prev = tmp;

        if (empty())
        	current = head;
        else if (current.next == tail)
            current = head.next;
        else
            current = current.next;
    }

    public void insertAtFront(T val)
    {
		DNode<T> tmp = new DNode<T>(val);
		tmp.next = head.next;
		tmp.prev = head;
		head.next.prev = tmp;
		head.next = current = tmp;
    }

    public void insertAtEnd(T val)
    {
    	DNode <T> tmp = tail.prev;
    	tail.prev = new DNode<T>(val);
    	current = tail.prev;
    	current.next = tail;
    	current.prev = tmp;
    	tmp.next = current;
    }

    public void removeFront()
    {
    	current = head.next;
    	head.next = current.next;
    	head.next.prev = head;
    	
    	if (empty())
    		current = head;
    	else
    		current = head.next;
    }

    public void removeEnd()
    {
    	DNode <T> tmp = tail.prev;
    	tail.prev = tmp.prev;
    	tmp.prev.next = tmp.next;

    	if (empty())
    		current = head;
    	else
    		current = head.next;
    }
}