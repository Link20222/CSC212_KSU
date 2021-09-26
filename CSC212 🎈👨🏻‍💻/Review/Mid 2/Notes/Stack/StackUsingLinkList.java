package Reveiw;

import ADTS.LinkList;

///////////////////////////////////////////////////////////////
//Q5 Page 2 , Q4 Page 10
///////////////////////////////////////////////////////////////

public class StackUsingLinkList <T>
{
	LinkList<T> s;
	
	public StackUsingLinkList()
	{
		s = new LinkList<T>();
	}

	public boolean empty()
	{
		return s.empty();
	}
	
	public boolean full()
	{
		return s.full();
	}

	public void push(T x)
	{
		if (s.empty())
			s.insert(x);
		else
		{
			s.findfirst();
			T e = s.retrieve();
			s.update(x);
			s.insert(e);
			s.findfirst();
		}
	}

	public T pop()
	{
		s.findfirst();
		T x = s.retrieve();
		s.remove();
		return x;
	}
}