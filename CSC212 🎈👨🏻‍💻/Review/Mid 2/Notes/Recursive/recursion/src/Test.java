import java.util.Scanner;

public class Test
{
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args)
	{
	}

	public static int reverseNumberRec(int n)
	{
		return reverseNumberRec(n,0);
	}

	public static int reverseNumberRec(int n,int reverse)
	{
		if (n != 0)
		{
			reverse = reverse * 10;
			reverse = reverse + n % 10;
			return reverseNumberRec(n / 10,reverse);
		}
		else
			return reverse;
	}

	/*public static int reverseNumber(int n)
	{
		int reverse = 0;

		while (n != 0)
		{
			reverse = reverse * 10;
			reverse = reverse + n % 10;
			n = n / 10;
		}

		return reverse;
	}*/

	public static boolean prime(int n)
	{
		return prime(n,2);
	}

	public static boolean prime(int n,int i)
	{
		if (n <= 3)
			return true;
		else if (n % i == 0)
			return false;
		else if (i <= n/2)
			return prime(n,i+1);
		else
			return true;
	}

	public static int countDigits(int n)
	{
		if (n == 0)
			return 0;
		else
			return 1 + countDigits(n/10);
	}

	public static int fib(int no)
	{
		if (no <= 1)
			return 1;
		else
			return fib(no - 1) + fib(no - 2);
	}

	public static int fact(int no)
	{
		if (no == 1)
			return 1;
		else
			return no * fact(no - 1);
	}

	public static void printNumbersReverse()
	{
		int no;
		no = kb.nextInt();

		if (no != -1)
		{
			printNumbersReverse();
			System.out.println(no);
		}
		else
			System.out.println("Done");
	}

	public static int total(int x[], int n)
	{

		if (n == 0)
			return x[0];
		else
			return x[n] + total(x, n - 1);
	}

	public static int totalTry(int x[], int n)
	{
		try
		{
			if (n == 0)
				return x[0];
			else
				return x[n] + totalTry(x, n-1);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return 0;
		}
	}

	public static int totalTry2(int x[], int n)
	{
		try
		{
			return x[n] + totalTry2(x, n-1);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return 0;
		}
	}
	public static void printArray(int a[] , int n)
	{
		if (n >= 0)
		{
			printArray(a, n-1);
			System.out.print(a[n] + " ");
		}
	}
	
	public static void printArrayReverse(int a[] , int n)
	{
		if (n >= 0)
		{
			System.out.println(a[n]);
			printArrayReverse(a, n-1);
		}
	}
	
	public static boolean isPalndrom(int x[], int i, int j)
	{
		if (i < j)
		{
			if (x[i] != x[j])
				return false;
			
			return isPalndrom(x, i+1, j-1);
		}
		else
			return true;
	}
	
	public static void reverse(int x[], int i, int j)
	{
		if (i < j)
		{
			int temp = x[i];
			x[i] = x[j];
			x[j] = temp;
			
			reverse(x, i+1, j-1);
		}
	}

	public static int search(int x[], int n, int target)
	{
		if(n >= 0)
		{
			if(x[n] == target)
				return n;
			
			return search(x, n-1, target);
		}
		else
			return -1;
	}
}