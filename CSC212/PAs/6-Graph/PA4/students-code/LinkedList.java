public class LinkedList<T> implements List<T>{

private Node<T> head;
private Node<T> current;
private int size;

public boolean empty(){
   if (head == null)
      return true;
   return false;
}

public boolean full(){
   return false;
}

public void findFirst(){
   current = head;
}

public void findNext(){
   current = current.next;
}

public boolean last(){
   if (current.next == null)
      return true;
   return false;
}

public T retrieve(){
   return current.data;
}

public void update(T e){
   current.data = e;
}

public void insert(T e){
   Node<T> data = new Node<T>(e);
   if (empty())
      current = head = data;
    else{
      Node<T> temp = current.next;
      current.next = data;
      current = current.next;
      current.next = temp;
    }
    
    size++;
}

public void remove(){
   if (current == head)
      head = head.next;
   else {
      Node<T> temp = head; 
      while (temp.next != current)
         temp = temp.next;
      temp.next = current.next;
   } 
   if (current.next == null)
      current = head;
   else
      current = current.next;
      
   size--;
}

public int size(){
   return size;
}

public boolean exists(T e){
   Node<T> tmp = head;
   while (tmp != null){
      if (tmp.data.equals(e))
         return true;
      tmp = tmp.next;
   }
   return false;
}

}