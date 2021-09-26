
public class Review {

	public static void main(String[] args) {
		// 1.1
		Integer number = -2;

		if (checkModify(number))
			System.out.println(number);
		else
			System.out.println("The Number is Already in Absolute Form");

		System.out.println("\n__________________________________");

		// 1.2
		double[] coefficients = { 0, 1, 2, 9, 0, 3 };
		double x = 5;
		int degree = 5;

		System.out.println("The Solution is: " + evalPol(coefficients, degree, x));

		System.out.println("\n__________________________________");

		// 1.3
		int[] arr = { 2, 5, 1, 0, 7, 3 };
		int n = 6;

		System.out.println("The Original Array: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		System.out.println("\nReturn Value:" + func(arr, 5));

		System.out.println("The Proccessed Array: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		System.out.println("\n__________________________________");

		// 1.4
		int[] A = { 1, 0, 1, 0, 1, 0, 1, 0 };
		n = 4;

		System.out.println("The Original Array: ");
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");

		// f(A, n);
		f(A, 0, 7, n);

		System.out.println("\nThe Proccessed Array: ");
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");

		System.out.println("\n__________________________________");

		// 1.5
		int[] negToPos = { 1, 2, -2, 0, 27, -29, 2 };

		System.out.println("The Original Array: ");
		for (int i = 0; i < negToPos.length; i++)
			System.out.print(negToPos[i] + " ");

		rearrange(negToPos, negToPos.length);

		System.out.println("\nThe Proccessed Array: ");
		for (int i = 0; i < negToPos.length; i++)
			System.out.print(negToPos[i] + " ");

		System.out.println();

	}

	// 1.1
	public static boolean checkModify(Integer n) {
		if (n > 0)
			return false;
		n *= -1;
		return true;
	}

	// 1.2
	public static double evalPol(double[] A, int n, double x) {
		if (n < 0)
			throw new RuntimeException("A Polynomial Cannot Have a Negative Exponent");

		if (n == 0)
			return A[0];

		return A[n] * Math.pow(x, n) + evalPol(A, n - 1, x);
	}

	// 1.3
	public static int func(int A[], int n) {
		int p = A[0];
		int i = 1;
		int j = n - 1;
		while (i < j) {
			while ((A[i] <= p) && (i < j))
				i++;
			while ((A[j] > p) && (i < j))
				j--;
			int tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
		}
		if (A[i] <= p) {
			int tmp = A[i];
			A[i] = A[0];
			A[0] = tmp;
			return i;
		} else {
			int tmp = A[i - 1];
			A[i - 1] = A[0];
			A[0] = tmp;
			return i - 1;
		}
	}

	// 1.4
	public static void f(int[] A, int n) {
		for (int i = 0; i < n; i++) {
			if (A[i] == 0)
				continue;
			else
				A[i] = 0;
		}

		for (int i = n; i < 8; i++)
			A[i] = 1;
	}

	public static void f(int[] A, int l, int r, int n) {
		if (l == n)
			return;

		if (A[l] == 1 && A[r] == 0) {
			int temp = A[l];
			A[l] = A[r];
			A[r] = temp;
		}

		f(A, l + 1, r - 1, n);

	}

	// 1.5
	public static void rearrange(int[] A, int n) {
		int i = 0, j = 0;

		for (; i < n; i++) {
			if (A[i] < 0) {
				if (i != j) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
				j++;
			}

		}
	}
	
}
