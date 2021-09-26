package Reveiw;

import ADTS.LinkStack;

public class TestStack <T>
{
	public static <T> void display(LinkStack <T> s1)
	{
		LinkStack <T> s2 = new LinkStack<T>();
		T x;

		while(! s1.empty())
		{
			x = s1.pop();
			System.out.print(x + " ");
			s2.push(x);
		}

		System.out.println();
		
		while(! s2.empty())
		{
			x = s2.pop();
			s1.push(x);
		}
	}

	public static <T> void reverse(LinkStack <T> s1,LinkStack <T> s2)
	{
		T x;

		while(! s1.empty())
		{
			x = s1.pop();
			s2.push(x);
		}
	}

	public static <T> void reverseKeepOriginal(LinkStack <T> s1,LinkStack <T> s2)
	{
		LinkStack <T> s3 = new LinkStack<T>();
		copyStack(s1,s3);

		T x;

		while(! s3.empty())
		{
			x = s3.pop();
			s2.push(x);
		}
	}

	public static <T> void copyStack(LinkStack <T> s1,LinkStack <T> s2)
	{
		LinkStack <T>s3 = new LinkStack<T>();
		T x;

		while(! s1.empty())
		{
			x = s1.pop();
			s3.push(x);
		}

		while(! s3.empty())
		{
			x = s3.pop();
			s1.push(x);
			s2.push(x);
		}
	}

	public static boolean equalStacks(LinkStack <Integer> s1,LinkStack <Integer> s2)
	{
		Integer x1 = null,x2 = null;
		LinkStack <Integer> s3,s4;
		
		s3 = new LinkStack<Integer>();
		s4 = new LinkStack<Integer>();

		boolean equal = true;

		while(! s1.empty() && !s2.empty() && equal)
		{
			x1 = s1.pop();
			x2 = s2.pop();

			s3.push(x1);
			s4.push(x2);

			if (x1 != x2)
				equal = false;
		}

		if (s1.empty() && ! s1.empty() || ! s1.empty() && s2.empty())
			equal = false;
		else if (x1 == x2)
			equal = true;
		else
			equal = false;

		while(! s3.empty())
			s1.push(s3.pop());

		while(! s4.empty())
			s2.push(s4.pop());

		return equal;
	}

	public static <T> void addLast(LinkStack <T> s1,T newX)
	{
		LinkStack <T> s2 = new LinkStack<T>();
		T x;

		while(! s1.empty())
		{
			x = s1.pop();
			s2.push(x);
		}

		s2.push(newX);

		while(! s2.empty())
			s1.push(s2.pop());
	}

	public static <T> void deleteTarget(LinkStack <T> s1,T d)
	{
		LinkStack <T> s2 = new LinkStack<T>();
		boolean found = false;
		T x;

		while(! s1.empty() && ! found)
		{
			x = s1.pop();
			
			if (x.equals(d))
				found = true;
			else
				s2.push(x);
		}

		while(! s2.empty())
			s1.push(s2.pop());
	}

	public static <T> void deleteAllTarget(LinkStack <T> s1,T d)
	{
		LinkStack <T> s2 = new LinkStack<T>();
		T x;

		while(! s1.empty())
		{
			x = s1.pop();

			if (! x.equals(d))
				s2.push(x);
		}

		while(! s2.empty())
			s1.push(s2.pop());
	}

	public static <T> void deleteLast(LinkStack<T> s1)
	{
		LinkStack <T> s2 = new LinkStack<T>();
		T x;

		while(! s1.empty())
		{
			x = s1.pop();
			s2.push(x);
		}

		s2.pop();

		while(! s2.empty())
			s1.push(s2.pop());		
	}
	
	public static <T> void swapFirstLast(LinkStack <T> s1)
	{
		T first;
		T last;
		T x;
		LinkStack <T> s2 = new LinkStack<T>();

		first = s1.pop();

		while(! s1.empty())
		{
			x = s1.pop();
			s2.push(x);
		}

		last = s2.pop();

		s1.push(first);
		
		while(! s2.empty())
			s1.push(s2.pop());

		s1.push(last);
	}

	public static Integer min(LinkStack<Integer> s1)
	{
		LinkStack <Integer> s2 = new LinkStack<Integer>();
		Integer x;

		Integer minimum = s1.pop();
		s2.push(minimum);

		while(! s1.empty())
		{
			x = s1.pop();

			if (x < minimum)
				minimum = x;

			s2.push(x);
		}

		while(! s2.empty())
			s1.push(s2.pop());

		return minimum;
	}

	public static void sort(LinkStack <Integer> s1)
	{
		LinkStack <Integer> s2 = new LinkStack<Integer>();
		Integer x;

		while(! s1.empty())
		{
			x = min(s1);
			deleteTarget(s1,x);

			s2.push(x);
		}

		while(! s2.empty())
			s1.push(s2.pop());
	}
	////////////////////////////////////////////

	public static <T> int countTarget(LinkStack<T> s1,T target)
	{
		int count = 0;
		LinkStack<T> s2 = new LinkStack<T>();
		T x;

		while(! s1.empty())
		{
			x = s1.pop();
			s2.push(x);

			if (x.equals(target))
				count++;
		}

		while(! s2.empty())
		{
			x = s2.pop();
			s1.push(x);
		}

		return count;
	}
	
	public static <T> void deleteLastAccurenec(LinkStack <T> s1,T target)
	{
		LinkStack<T> s2 = new LinkStack<T>();
		T x;
		
		while(! s1.empty())
		{
			x = s1.pop();
			s2.push(x);
		}

		boolean found = false;
		
		while(! s2.empty() && ! found)
		{
			x = s2.pop();
			
			if (x.equals(target))
				found = true;
			else
				s1.push(x);
		}
		
		while(! s2.empty())
			s1.push(s2.pop());
	}

	public static <T> boolean searchTarget(LinkStack<T> s1,T target)
	{
		LinkStack <T> s2 = new LinkStack<T>();
		boolean found = false;
		T x;

		while(! s1.empty() && ! found)
		{
			x = s1.pop();
			s2.push(x);

			if (x.equals(target))
				found = true;
		}

		while(! s2.empty())
			s1.push(s2.pop());

		return found;
	}

	public static <T> void deleteRepeated(LinkStack<T> s1)
	{
		LinkStack<T> s2 = new LinkStack<T>();
		T x;

		while(! s1.empty())
		{
			x = s1.pop();

			if (! searchTarget(s2, x))
				s2.push(x);
		}

		while(! s2.empty())
			s1.push(s2.pop());
	}

	public static <T> void insertIth(LinkStack<T> s1,int i,T newX)
	{
		LinkStack <T> s2 = new LinkStack<T>();
		T x;
		
		int c = 0;

		while(! s1.empty() && c < i)
		{
			x = s1.pop();
			s2.push(x);
			c++;
		}

		if (! s1.empty() || c == i)
			s2.push(newX);

		while(! s2.empty())
			s1.push(s2.pop());		
	}
	
///////////////////////////////////////////////////////////////
//  Q3 (ii) Page 18A
//////////////////////////////////////////////////////////////   /

	public static <T> int size(LinkStack <T> s1)
	{
		LinkStack <T> s2 = new LinkStack<T>();
		T x;
		int s = 0;

		while(! s1.empty())
		{
			x = s1.pop();
			s2.push(x);

			s++;
		}

		while(! s2.empty())
			s1.push(s2.pop());

		return s;
	}

///////////////////////////////////////////////////////////////
//  Q3 (a) Page 28
//////////////////////////////////////////////////////////////   /

	public static <T> T retreiveBottom(LinkStack <T> s1)
	{
		LinkStack <T> s2 = new LinkStack<T>();
		T x,y;

		while(! s1.empty())
		{
			x = s1.pop();
			s2.push(x);
		}

		y = s2.pop();
		s1.push(y);

		while(! s2.empty())
			s1.push(s2.pop());
		
		return y;
	}

	public static <T> T retreiveBottom2(LinkStack <T> s1)
	{
		LinkStack <T> s2 = new LinkStack<T>();
		T x,y = null;

		while(! s1.empty())
		{
			x = s1.pop();
			s2.push(x);
			
			if (s1.empty())
				y = x;
		}

		while(! s2.empty())
			s1.push(s2.pop());
		
		return y;
	}
	
	public static boolean isBalanced(char eq[])
	{
		LinkStack<Character> s1 = new LinkStack<Character>();
		
		for (int i = 0 ; i < eq.length ; i++)
		{
			if (eq[i] == '(' || eq[i] == '{' || eq[i] == '[')
				s1.push(eq[i]);
			else if (eq[i] == ']')
			{
				if (s1.empty())
					return false;

				char t = s1.pop();
				
				if (t != '[')
					return false;
			}
			else if (eq[i] == ')')
			{
				if (s1.empty())
					return false;
				
				char t = s1.pop();
				
				if (t != '(')
					return false;
			}
			else if (eq[i] == '}')
			{
				if (s1.empty())
					return false;
				
				char t = s1.pop();
				
				if (t != '{')
					return false;
			}
		}

		if (s1.empty())
			return true;
		else
			return false;
	}
	
	private static int calculatePostFix(String pf)
	{
		char c;
		LinkStack <Integer>s1 = new LinkStack<Integer>();

		for (int i = 0 ; i < pf.length() ; i++)
		{
			c = pf.charAt(i);

			if (Character.isDigit(c))
				s1.push(Integer.parseInt(String.valueOf(c)));
			else
			{
				int op2 = s1.pop();
				int op1 = s1.pop();
				int sum = 0;

				switch(c)
				{
					case '*' : 	sum = op1 * op2;
								break;
                                                
					case '+' : 	sum = op1 + op2;
								break;
                                                
					case '-' : 	sum = op1 - op2; 
								break;
                                                
					case '/' : 	sum = op1 / op2; 
								break;
                                                
					case '%' : 	sum = op1 % op2; 
                                break;
				}

				s1.push(sum);
			}
		}

		return s1.pop();
     }
}