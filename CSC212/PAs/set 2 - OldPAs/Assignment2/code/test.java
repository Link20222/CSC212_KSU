public class test {
   public static void main (String [] args) {
      LinearHash<Integer> a = new LinearHash<Integer> ( 7, 2);
      System.out.println(a.insert(407,407));
      System.out.println(a.insert(801,801));
      System.out.println(a.insert(815,815));
      System.out.println(a.insert(704,704));
      System.out.println(a.insert(814,814));
      System.out.println(a.insert(721,721));
      System.out.println(a.insert(935,935));
      System.out.println(a.find(401));

      System.out.println(a.retrieve());
   
   }
}