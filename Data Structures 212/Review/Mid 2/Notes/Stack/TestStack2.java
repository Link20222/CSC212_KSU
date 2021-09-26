package stack;

public class TestStack
{
	public static void main(String[] args)
	{
		LinkStack<Integer> s1 = new LinkStack<Integer>();

		for (int i = 1; i <= 10; i++)
		{
			s1.push(i);
		}

		display(s1);
		removeLastRec(s1);
		display(s1);
	}
	
	public static<T> void display(LinkStack<T> s)
	{
		LinkStack<T> s2 = new LinkStack<T>();

		while(!s.empty())
		{
			T x = s.pop();
			if (s.empty())
				System.out.println(x);
			else
				System.out.print(x + ", ");

			s2.push(x);
		}
	
		while(!s2.empty())
		{
			s.push(s2.pop());
		}
	}
	
	public static<T> void displayIth(LinkStack<T> s, int i)
	{
		LinkStack<T> s2 = new LinkStack<T>();
		int count = 1;
		boolean finished = false;

		while(! s.empty() && ! finished)
		{
			T x = s.pop();
		
			if(count == i)
			{
				System.out.println(x);
				finished = true;
			}

			s2.push(x);
			count++;
		}

		if (! finished)
			System.out.println(i + " is larger than the size of the stack");

		while(!s2.empty())
		{
			s.push(s2.pop());
		}
	}
	
	public static<T> void removeIth(LinkStack<T> s, int i)
	{
		LinkStack<T> s2 = new LinkStack<T>();
		int count = 1;
		boolean finished = false;

		while(! s.empty() && ! finished)
		{
			T x = s.pop();

			if(count < i)
				s2.push(x);
			else
				finished = true;

			count++;
		}

		if (! finished)
			System.out.println(i + " is larger than the size of the stack");

		while(! s2.empty())
		{
			s.push(s2.pop());
		}
	}
	
	public static <T> void replace(LinkStack<T> st, T x, T y)
	{
		LinkStack<T> temp = new LinkStack<T>();
		T e;

		while(!st.empty())
		{
			e = st.pop();
		
			if(e.equals(x))
				e = y;

			temp.push(e);
		}

		while(!temp.empty())
			st.push(temp.pop());
	}

	public static<T> void replaceRec(LinkStack<T> st, T x, T y)
	{
		if(st.empty())
			return;
		
		T temp = st.pop();
		
		replace(st,x,y);
		
		if(x.equals(temp))
			st.push(y);
		else
			st.push(temp);
	}

	public static <T> void insertAfter(LinkStack<T> st, int i, T e)
	{
		LinkStack<T> temp = new LinkStack<T>();
		int c = 0;

		while(! st.empty())
		{
			T x = st.pop();
			temp.push(x);

			if(c == i)
				temp.push(e);

			c++;
		}

		while(!temp.empty())
			st.push(temp.pop());
	}
	
	public static<T> void insertAfterRec(LinkStack<T> st, int i, T e)
	{
		if(i == 0)
		{
			st.push(e);

			return;
		}

		T x = st.pop();

		insertAfterRec(st, i-1, e);

		st.push(x);
	}
	
	public static <T> void removeLast(LinkStack<T> st)
	{
		LinkStack<T> temp = new LinkStack<T>();

		while(!st.empty())
			temp.push(st.pop());
		
		if(! temp.empty())
			temp.pop();

		while(! temp.empty())
			st.push(temp.pop());
	}

	public static<T> void removeLastRec(LinkStack<T> st)
	{
		if(st.empty())
			return;
		
		T x = st.pop();
		
		if(st.empty())
			return;
		
		removeLastRec(st);
		
		st.push(x);
	}

	public static <T> void insertLast(LinkStack<T> st,T e)
	{
		LinkStack<T> temp = new LinkStack<T>();

		while(!st.empty())
			temp.push(st.pop());

		if(! temp.empty())
			st.push(e);

		while(! temp.empty())
			st.push(temp.pop());
	}
	
	public static<T> void removeTarget(LinkStack<T> s, T e)
	{
		LinkStack<T> s2 = new LinkStack<T>();
		boolean finished = false;

		while(! s.empty() && ! finished)
		{
			T x = s.pop();

			if (! x.equals(e))
				s2.push(x);
			else
				finished = true;
		}

		if (! finished)
			System.out.println(e + " is not found in the stack");

		while(! s2.empty())
		{
			s.push(s2.pop());
		}
	}

	public static<T> void removeAllTarget(LinkStack<T> s, T e)
	{
		LinkStack<T> s2 = new LinkStack<T>();
		boolean found = false;

		while(! s.empty())
		{
			T x = s.pop();

			if (! x.equals(e))
				s2.push(x);
			else
				found = true;
		}

		if (! found)
			System.out.println(e + " is not found in the stack");

		while(! s2.empty())
		{
			s.push(s2.pop());
		}
	}

	public static <T> boolean SearchStack(LinkStack<T> s, T e)
	{
		if(s.empty())
			return false;

		T X = s.pop();

		if(X.equals(e))
		{
			s.push(X);
			return true;
		}

		boolean result = SearchStack(s,e);
		s.push(X);

		return result;
	}
	
	public static <T> void copyStack(LinkStack<T> s1, LinkStack<T> s2)
	{
		if(s1.empty())
			return;

		T X = s1.pop();
		copyStack(s1,s2);

		s1.push(X);
		s2.push(X);
	}
	
	
}