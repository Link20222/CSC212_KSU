
public class Util {
		   public static <T extends Comparable<T> > int search ( T[] data , int n , T e) {
		      for ( int i=0 ; i<n ; i++)
		         if ( data[i].compareTo(e)== 0)
		            return i;
		   
		      return -1;
		   }
}
