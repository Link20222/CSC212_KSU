package ADTS;

public class Dequeue<T>
{
    private Node<T> head,tail;
    private int size;

    public Dequeue()
    {
        head = tail = null;
        size = 0;
    }

    public boolean full()
    {
        return false;
    }

    public int length ()
    {
        return size;
    }

    public void addFirst(T e)
    {
        Node<T> temp = new Node<T>(e);
        temp.next = head;
        head = temp;

        if (size == 0)
                tail = temp;

        size++;
    }

    public void addLast(T e)
    {
        if (tail == null)
            head = tail = new Node<T>(e);
        else
        {
            tail.next = new Node<T>(e);
            tail = tail.next;
        }

        size++;
    }

    public T removeFirst()
    {
        T x = head.data;
        head = head.next;
        size--;

        if (size == 0)
                tail = null;

        size--;

        return x;
    }

    public T removeLast()
    {
        T x = tail.data;

        if (size == 1)
            head = tail = null;
        else
        {
            Node<T> prev = head;

            while(prev.next != tail)
                    prev = prev.next;

            prev.next = null;
            tail = prev;
        }

        size--;

        return x;
    }

    public T getFirst()
    {
        return head.data;
    }

    public T getLast()
    {
        return tail.data;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
}