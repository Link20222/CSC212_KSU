public class LinkedGT <T> implements GT<T> {

public GTNode<T> root;
public GTNode<T> current;

public boolean empty(){
   return root == null;
}

public boolean full(){
   return false;
}

public T retrieve(){
   return current.data;
}

public void update(T e){
   current.data = e;
}

public boolean insert(T e){
   if (root == null){
      current = root = new GTNode<T>(e, null);
      return true; 
      }
   else {
      GTNode<T> tmp = new GTNode<T>(e, current);
      current.children.insert(tmp);
      current = tmp;
      return true;   
      }    
}

public int nbChildren(){
   int size = 0;
   if (!current.children.empty()){
      current.children.findFirst();
      while (!current.children.last()){
         size++;
         current.children.current = current.children.current.next;
      } // end of while
      size++;
   } // end of if
   return size;
}
public boolean findChild(int i){
   GTNode<T> tmp = root;
   if (nbChildren()>i && i>-1){
      current.children.findFirst();
      for (int j = 0; j <= i; j++){
         tmp = current.children.retrieve();
         current.children.findNext();
      }
      current = tmp; 
      return true;     
   }
   return false;
}

public boolean findParent(){
   if (current.parent != null){
      current = current.parent;
      return true;
   }
   return false;
}

public void findRoot(){
   if (!empty())
      current = root;  
}

public void remove(){
   GTNode<T> tmp = current;
   if (current == root)
      current = root = null;
   else {
      current.children.findFirst();
      while (!current.children.last()){
         if (current.children.current.equals(tmp))
            current.children.remove();   
      }
      if (current.children.current.equals(tmp))
         current.children.remove();
   }
}

}