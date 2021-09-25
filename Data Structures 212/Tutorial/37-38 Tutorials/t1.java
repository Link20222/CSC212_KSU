public class t1{
   public static  void sort( int[] n ) {
      int temp;
      for (int i=0 ; i<n.length ; i++)
         for (int j=i+1; j<n.length ; j++)
            if ( n[i] > n[j]){
               temp= n[i];
               n[i]=n[j];
               n[j]=temp;
            }
   }
   public static boolean distinct ( int[] a) {
   for (int i=0; i<a.length; i++)
   for (int j=i+1; j<a.length; j++)
   if ( a[i] == a[j] )
   return false;
   
   return true;
   }
     public static void main (String [] args ) {
      int a[] = {12,5,8,16,9,31, 31};
      sort(a);
      for (int i=0; i<a.length ; i++)
         System.out.print (a[i]+ " ");
         
         System.out.println(distinct(a));
   }
}
