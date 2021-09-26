public class LinkedList<T> implements List<T>{

private Node<T> head;
private Node<T> current;


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
   current = current.getNext();
}

public boolean last(){
   if (current.getNext() == null)
      return true;
   return false;
}

public T retrieve(){
   return current.getData();
}

public void update(T e){
   current.setData(e);
}

public void insert(T e){
   Node<T> data = new Node<T>(e);
   if (empty())
      current = head = data;
    else{
      Node<T> temp = current.getNext();
      current.setNext(data);
      current = current.getNext();
      current.setNext(temp);
    }
}

public void remove(){
   if (current == head)
      head = head.getNext();
   else {
      Node<T> temp = head; 
      while (temp.getNext() != current)
         temp = temp.getNext();
      temp.setNext(current.getNext());
   } 
   if (current.getNext() == null)
      current = head;
   else
      current = current.getNext();
}

public boolean findFirstEle(Cond<T> cnd){
   Node<T> temp = head;
   while (temp != null){
      if (cnd.test(temp.getData())){
         current = temp;
         return true;
         }
      temp = temp.getNext();
   }
   return false;
}

public List<T> findAllEle (Cond<T> cnd){
   LinkedList<T> list = new LinkedList<T>();
   Node<T> temp = head;
   while (temp != null){
      if (cnd.test(temp.getData()))
         list.insert(temp.getData());
      temp = temp.getNext();
      }
   return list;
}

}