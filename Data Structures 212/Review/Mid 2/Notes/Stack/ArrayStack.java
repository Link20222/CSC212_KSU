package stack;

public class ArrayStack<T>
{
	private int maxsize;
	private int top;
	private T[] nodes;

    public ArrayStack(int n)
    {
    	maxsize = n;
    	top = 0;
    	nodes = (T[]) new Object[n];
    }

    public boolean empty()
    {
    	return top == 0;
    }

    public boolean full()
    {
    	return top == maxsize;
    }

    public void push(T e)
    {
    	nodes[top++] = e;
    }

    public T pop()
    {
    	return nodes[--top];
    }
}