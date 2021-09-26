public class LinkedQueue<T> implements Queue<T> {

   public Node<T> head, tail;
   public int size;

   public int length(){
      return size;
   }

   public boolean full(){
      return false;
   }

   public void enqueue(T e){
      Node tmp = new Node (e);
      if (size == 0){
         head = tail = tmp;
         size++;
         }
      else {
         tail.next = tmp;
         tail = tmp;
         size++;
         }
   }

   public T serve(){
      T e = head.data;
      head = head.next;
      size--;
      return e;
   }

}