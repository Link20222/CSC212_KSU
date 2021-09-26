public class CircleLinkList<T>
{
    private Node<T> head;
    private Node<T> current;
    
    public CircleLinkList()
    {
    	head = current = null;
    }

    public boolean empty()
    {
    	return head == null;
    }

    public boolean last()
    {
    	return current.next == head;
    }

    public boolean full()
    {
    	return false;
    }

    public void findfirst()
    {
        current = head;
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
        Node<T> tmp;

        if (empty())
        {
        	current = head = new Node<T> (val);
        	current.next = head;
        }
        else
        {
        	tmp = current.next;
        	current.next = new Node<T> (val);
        	current = current.next;
        	current.next = tmp;
        }
    }

    public void remove()
    {
    	if (head.next == head)
    		head = current = null;
    	else if (current == head)
    	{
    		Node<T> tmp = head;
            head = head.next;

            current = head;
            
            while(current.next != tmp)
            	current = current.next;

            current.next = head;
            current = head;
    	}
        else
        {
            Node<T> tmp = head;

            while (tmp.next != current)
            	tmp = tmp.next;

            tmp.next = current.next;
            current = current.next;
        }
    }
}