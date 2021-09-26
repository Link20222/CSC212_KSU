public class PQNode<T, P extends Comparable<P>> {
   public T data;
   public P priority;
   public PQNode<T, P> next;

   public PQNode(T e, P p) {
      data = e;
      priority = p;
   }
}