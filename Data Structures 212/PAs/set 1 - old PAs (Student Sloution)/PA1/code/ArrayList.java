public class ArrayList<T> implements List<T>{

private int current;
private int maxsize;
private int size;
private T[] nodes;

public ArrayList(int n){
   maxsize = n;
   nodes = (T[]) new Object [n];
   size = 0;
   current = -1;
}

public boolean empty(){
   if (size == 0)
      return true;
   return false;
}

public boolean full(){
   if (maxsize == size)
      return true;
   return false;
}

public void findFirst(){
   current = 0;
}

public void findNext(){
   current++;
}

public boolean last(){
   if (current == size-1)
      return true;
   return false;
}

public T retrieve(){
   return nodes[current];
}

public void update(T e){
   nodes[current] = e;
}

public void insert(T e){
   for (int i = size-1; i > current; i--)
      nodes[i+1] = nodes[i];
   nodes[++current] = e;
   size++;
}

public void remove(){
   for (int i = current+1; i < size; i++)
      nodes[i-1] = nodes[i];
   size--;
   if (size==0)
      current = -1;
   else if (current == size)
      current = 0;
}

public boolean findFirstEle(Cond<T> cnd){
   for (int i = 0; i < size; i++)
      if (cnd.test(nodes[i])){
         current = i;
         return true;
      }
   return false;     
}

public List<T> findAllEle (Cond<T> cnd){
   ArrayList<T> list = new ArrayList<T>(size);
   for (int i = 0; i < size; i++){
      if (cnd.test(nodes[i]))
         list.insert(nodes[i]);
      }
   return list;
}

}