
public class Box<T> {
	   private T data;
	   public Box ( T data ) {
	      this.data=data;
	   }

	   public T get(){
	      return data;
	   }

	   public void update ( T data ){
	      this.data=data;
	   }

}
