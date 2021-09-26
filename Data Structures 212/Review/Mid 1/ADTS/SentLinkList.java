public class SentLinkList <T>
{
    private Node<T> head,tail;
    private Node<T> current;

    public SentLinkList()
    {
    	head = current = new Node<T>();
    	tail = new Node<T>();
    	head.next = tail;
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
        Node<T> tmp = current.next;
        current.next = new Node<T> (val);
        current = current.next;
        current.next = tmp;
    }

    public void remove()
    {
    	Node<T> tmp = head;

    	while (tmp.next != current)
    		tmp = tmp.next;

    	tmp.next = current.next;

        if(empty())
        	current = head;
        else if (current.next == tail)
            current = head.next;
        else
            current = current.next;
    }

    public void insertAtFront(T val)
    {
    	Node<T> tmp = new Node<T>(val);
    	tmp.next = head.next;
    	head.next = current = tmp;
    }

    public void insertAtEnd(T val)
    {
    	current = head;

    	while(current.next != tail)
    		current = current.next;

    	current.next = new Node<T>(val);
    	current = current.next;
    	current.next = tail;
    }

    public void removeFront()
    {
    	current = head.next;
    	head.next = current.next;

    	if (empty())
    		current = head;
    	else
    		current = head.next;
    }

    public void removeEnd()
    {
    	Node<T> prev = head;
    	current = head.next;

    	while(current.next != tail)
    	{
    		prev = current;
    		current = current.next;
    	}

    	prev.next = tail;
    		
    	if (empty())
    		current = head;
    	else
    		current = head.next;
    }
}