public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {
	
   private PQNode<T, P> head, tail;
   private int maxSize, length;
   
   public PQKImp(int k) {
		maxSize = k;
      head = tail = null;
      length = 0;
	}
   
   public int length(){
      return length;
   }
   
   public void enqueue(P pr, T e){

   PQNode<T, P> data = new PQNode<T, P>(e, pr);
      
   if ((length == 0) || (pr.compareTo(head.priority) == 1)){ // Case the queue was empty or the priority of the new element is higher than head
      data.next = head;
      head = data;
      length++;
            }
         
    else {
      PQNode<T, P> p = head;
      PQNode<T, P> q = null;
      for (int i=0; i<length; i++){
         if (p.priority.compareTo(pr) == -1)
            break;
          q = p;
          p = p.next;
               } // end of for
       q.next = data;
       data.next = p;
       length++;
         } // end of inner else
         
    if (length > maxSize){ // case the queue reached its maximum size (we should remove the tail)
      PQNode<T, P> tmp = head;
      for (int i=0; i<length-1; i++){
         tmp = tmp.next;
      }
      tmp.next = null;
      tail = tmp;
      length--;
    }  
   } // end of enqueue
   
   public Pair<P, T> serve(){
      Pair<P, T> data = new Pair<P, T>(head.priority, head.data);
      head = head.next;
      length--;
      return data;
   }
   
}
