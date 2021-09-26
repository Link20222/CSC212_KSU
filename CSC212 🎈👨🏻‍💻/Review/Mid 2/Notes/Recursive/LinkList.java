package recursive;

public class LinkList<T>
{
    private Node<T> head;
    private Node<T> current;
    
    public LinkList()
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
        	current = head = new Node<T> (val);
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
        if (current == head)
            head = head.next;
        else
        {
            Node<T> tmp = head;

            while (tmp.next != current)
            	tmp = tmp.next;

            tmp.next = current.next;
        }

        if (current.next == null)
            current = head;
        else
            current = current.next;
    }
    
    public boolean search(T e)
    {
    	return recSearch(head, e);
    }
    
    private boolean recSearch(Node<T> p, T e)
    {
    	if(p == null)
    		return false;

    	if(p.data.equals(e))
    		return true;

    	return recSearch(p.next, e);
    }
}