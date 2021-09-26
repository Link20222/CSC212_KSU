import java.util.*;
public class TestPile {

   public static<T extends Comparable<T> > boolean compare(Pile<T> p1, Pile<T> p2){
      Pile<T> p3 = new Pile<T> (1000);
      Pile<T> p4 = new Pile<T> (1000);
      int p1Siza =0, p2Size = 0;
      T temp1, temp2;
      boolean flag = true;
   
      while (!p1.empty()){
         p3.add(p1.remove());
         p1Siza++;
      }
      while (!p2.empty()){
         p4.add(p2.remove());
         p2Size++;
      }
   
      if ( p2Size != p1Siza )//since they have different number of elements so they aren't equals
         return false;
   
      for (int i=0 ; i<p1Siza ; i++){
         temp1 = p3.remove();
         temp2 = p4.remove();
         if (!(temp1.compareTo(temp2)==0) )
            flag = false;
         p1.add(temp1);
         p2.add(temp1);
      }
   
      return flag;
   	
   	
   	
   }
}
