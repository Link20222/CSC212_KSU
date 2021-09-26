
public class Q1 {
   public static void main(String[] args) {
      int[] arr = { 0 };
      LinkedList<Integer> list = new LinkedList<Integer>();
      list.insert(1);
      list.insert(2);
      list.insert(33);
      list.insert(4);
      list.insert(5);
      ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(5);
      LinkedStack<Integer> stack1 = new LinkedStack<Integer>();
   
      System.out.println("\n ODDS:" + odd(stack1) );
      LinkedStack<Integer> stack2 = new LinkedStack<Integer>();
      stack2.push(9);
      stack2.push(8);
   
   
      LinkedQueue<String> q1 = new LinkedQueue<String>();
      q1.enqueue("A");
      q1.enqueue("B");
      q1.enqueue("C");		
      q1.enqueue("D");
      q1.enqueue("E");
      q1.enqueue("F");
      q1.enqueue("G");		
      q1.enqueue("H");
      LinkedQueue<String> q2 = firstHalf(q1);
   // 
   // 		LinkedQueue<String> q2 = new LinkedQueue<String>();
   // 		q2.enqueue("D");
   // 		q2.enqueue("E");
   // 		q2.enqueue("F");
   // 		q2.enqueue("G");
   // 		q2.enqueue("H");
   // 		LinkedQueue<String> q = merge2(q1, q2);
   // 		//reverse(q1);
   // 		
      int size = q1.length(); 
   	//   System.out.println(q1.length());
   // 		  System.out.println(q2.length()); 
   // 		  int size1 = q1.length(); 
      int size2 =q2.length(); 
      for (int i = 0; i < size; i++)
         System.out.print(q1.serve()); 
   	 //  System.out.println("///// q1");
   // 		  for (int i = 0; i < size1; i++) System.out.print(q1.serve());
      System.out.println("/////q1");
      for (int i = 0; i < size2; i++)
         System.out.print(q2.serve());
   	 
   	//removeLast(stack1);
   	// stack.reverse();
   	// InsertAtBottom(stack1, 10);
   	 //InsertAtBottom(stack1, 20);
   
   	 //System.out.print(list.recSearch(33));
   	//stack.reverse();
   //       moveAfter(stack1,stack2,1);
   // 		while (!stack1.empty())
   // 			System.out.print(stack1.pop() + ",");
   
   }
   
   
   
   
   
   public static <T> LinkedQueue<T> firstHalf (LinkedQueue<T> q){
      LinkedQueue<T> q1 = new LinkedQueue<T>();
      int n = q.length();
      for(int i=0; i<n/2 ; i++){
         T tmp = q.serve();
         q1.enqueue(tmp);
         q.enqueue(tmp);
      }
      for(int i = 0 ; i<n/2 ; i++)
         q.enqueue(q.serve());
   
      return q1;
   }
 
   public static int countOdds(LinkedStack<Integer> st){
      int count = 0;
      LinkedStack<Integer> tmp = new LinkedStack<Integer> ();
      while(!st.empty()){
         Integer a = st.pop();
         if(a % 2 != 0)
            count++;
         tmp.push(a);
      }
      while(!tmp.empty())
         st.push(tmp.pop());
   
      return count;
   }
   
   
   
   
   
	// problem 3.1
   public static boolean containsMult3(int[] list, int index) {
      if (index + 1 == list.length)
         return (list[index] % 3 == 0);
   
      if (list[index] % 3 == 0)
         return true;
   
      return containsMult3(list, index + 1);
   }

	// problem 3.2
   public static boolean sameSign(int[] list, int index) {
      if (index + 1 == list.length)
         return list[index] != 0;
   
      if ((list[index] > 0 && list[index + 1] < 0) || (list[index] < 0 && list[index + 1] > 0) || list[index] == 0)
         return false;
   
      return sameSign(list, index + 1);
   
   }

	// problem 2.1
   public static <T> void removeLast(LinkedStack<T> st) {
   
      LinkedStack<T> tmp = new LinkedStack<T>();
      while (!st.empty()) {
         tmp.push(st.pop());
      }
   
      if (!tmp.empty())
         tmp.pop();
      while (!tmp.empty())
         st.push(tmp.pop());
   
   }

	// problem 2.2
   public static <T> boolean topEqualsBottom(LinkedStack<T> st) {
      if (st.empty())
         return true;
   
      LinkedStack<T> tmp = new LinkedStack<T>();
      T top = st.pop();
      tmp.push(top);
      T bottom = null;
      while (!st.empty()) {
         bottom = st.pop();
         tmp.push(bottom);
      }
   
      while (!tmp.empty()) 
         st.push(tmp.pop());
   	
      return top.equals(bottom);
   }

	// problem 5.1
   public static <T> void InsertAtBottom(LinkedStack<T> st, T e) {
      if (st.empty()) {
         st.push(e);
         return;
      }
   
      T tmp = st.pop();
      InsertAtBottom(st, e);
      st.push(tmp);
   }

	// problem 5.2
   public static <T> void reverse(LinkedQueue<T> q) {
      if (q.length() == 0)
         return;
      T tmp = q.serve();
      reverse(q);
      q.enqueue(tmp);
   }

	// problem 5.3
   public static <T> LinkedQueue<T> merge(LinkedQueue<T> q1, LinkedQueue<T> q2) {
      return recMerge(q1, q2, new LinkedQueue<T>());
   }

   public static <T> LinkedQueue<T> recMerge(LinkedQueue<T> q1, LinkedQueue<T> q2, LinkedQueue<T> q) {
      if (q1.length() == 0 && q2.length() == 0)
         return q;
      if (q1.length() != 0)
         q.enqueue(q1.serve());
      if (q2.length() != 0)
         q.enqueue(q2.serve());
   
      return recMerge(q1, q2, q);
   
   }

	// problem 5.4
   public static <T> LinkedQueue<T> merge2(LinkedQueue<T> q1, LinkedQueue<T> q2) {
      return recMerge2(q1, q2, new LinkedQueue<T>(), 0, 0);
   }

   public static <T> LinkedQueue<T> recMerge2(LinkedQueue<T> q1, LinkedQueue<T> q2, LinkedQueue<T> q, int i, int j) {
      if (q1.length() == i && q2.length() == j)
         return q;
      T tmp1 = null, tmp2 = null;
      if (q1.length() != i) {
         tmp1 = q1.serve();
         q.enqueue(tmp1);
         q1.enqueue(tmp1);
         i++;
      }
   
      if (q2.length() != j) {
         tmp2 = q2.serve();
         q.enqueue(tmp2);
         q2.enqueue(tmp2);
         j++;
      }
      return recMerge2(q1, q2, q, i, j);
   }
   
   public static <T >void moveAfter(LinkedStack<T >st1, LinkedStack<T >st2 , int i){
      LinkedStack<T> tmp = new LinkedStack<T> ();
      for(int x=0 ; x<=i ; x++)
         tmp.push(st1.pop());
   
      while(!st2.empty() ) 
         tmp.push(st2.pop());
   
      while(!tmp.empty() ) 
         st1.push(tmp.pop());
   
   }

}
