public class GTNode<T>{

   public T data; // for the node data
   public GTNode<T> next; // for the node siblings
   public LinkedList<GTNode<T>> children; // for the node' children
   public GTNode<T> parent;
   
   public GTNode(T data, GTNode<T> parent){
      this.data = data;
      this.parent = parent;
      next = null;
      children = new LinkedList<GTNode<T>>();
   }
   
   
}