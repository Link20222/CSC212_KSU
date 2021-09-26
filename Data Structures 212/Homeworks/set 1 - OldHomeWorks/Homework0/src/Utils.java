
public class Utils {
	   public static <T> int search (T[] data , int n , Condition<T> cond) {
		      for ( int i=0 ; i<n ; i++)
		         if (cond.test(data[i]))
		            return i;
		   
		      return -1;
		   }
		   
		   
		   public static int searchEven(Integer[] data, int n ){
		      Condition<Integer> cond = new Even();
		      int index = search(data,n,cond);
		      if(index!= -1)
		         return data[index];
		   
		      return -1;
		   
		   }
}

