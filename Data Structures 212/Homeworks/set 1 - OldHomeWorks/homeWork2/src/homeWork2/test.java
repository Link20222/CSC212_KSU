package homeWork2;

public class test {
   public static void main(String[] args) {
      LinkedList<String> l1 = new LinkedList<String>();
      LinkedList<String> l2 = new LinkedList<String>();
   
      l1.insert("A");
       l1.insert("B");
   //       l1.insert("C");
   //       l1.insert("D");
   //       l1.insert("E");
   //       l1.insert("F");
   //       l1.insert("G");
   //       l1.insert("H");
   //       
          l2.insert("B");
      //  l2.insert("A");
//       l2.insert("D");
//       l2.insert("B");
//       
      System.out.print(compare(l1,l2));
   
   }
   public static <T> int compare ( LinkedList<T> l1 , LinkedList<T> l2){
      if(l1.empty() || l2.empty())
         return 0;
   
      l1.findFirst();
      l2.findFirst();
      T data;
      int count=0;
      while(!l1.last()){
         data = l1.retrieve();
         while(!l2.last()){
            if ( data .equals( l2.retrieve()) )
               count++;
            l2.findNext();
         }
         if ( data .equals( l2.retrieve()) )
            count++;
         l2.findFirst();
         l1.findNext();
      }
       //  l2.findFirst();
      data = l1.retrieve();
      while(!l2.last()){
         if ( data .equals( l2.retrieve()) )
            count++;
         l2.findNext();
      }
      if ( data .equals( l2.retrieve()) )
         count++;
      l2.findFirst();
      l1.findNext();
       
      return count;  
   }
}
