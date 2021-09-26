public class LinkedStack<T> implements Stack<T>{

   public Node<T> top;
   
   public boolean empty(){
      return top == null;
   }
   
   public boolean full(){
      return false;
   }
   
   public void push(T e){
      Node tmp = new Node(e);
      tmp.next = top;
      top = tmp;
   }
   
   public T pop(){
      T e = top.data;
      top = top.next;
      return e;
   }
   
   public T peek(){
      return top.data;
   }
   
   public void reverse(){
      LinkedStack<T> s1 = new LinkedStack(), s2 = new LinkedStack();
      while (!empty()){
         s1.push(pop());
      }
      while (!s1.empty()){
         s2.push(s1.pop());
      }
      while (!s2.empty()){
         push(s2.pop());
      }   
   }
}