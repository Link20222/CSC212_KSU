
public class GenericArray<T> {
	   private T[] list;
	   
	   public GenericArray ( int n ) {
	      list = (T[])new Object [n];
	   }

	   public T get ( int i ) {
	      if ( i>=0 && i< list.length)
	         return list[i];
	   
	      return null;
	   }

	   public void set ( int i , T val) {
	      if ( i>=0 && i< list.length)
	         list[i] = val;
	   }

}
