public class LinearHash<T> {

   public enum Status {
      empty, occupied, deleted
   };

   private int maxSize;
   private int size;
   private int c;
   private int current;
   private int[] keys;
   private Status[] statusT;
   private T[] data;

   public LinearHash(int maxSize, int c) {
   
      this.maxSize = maxSize;
      this.c = c;
      size = 0;
      current = -1;
      keys = new int[maxSize];
      statusT = new Status[maxSize];
      data = (T[]) new Object[maxSize];
   
   	// Initialize all cells to empty
      for (int i = 0; i < maxSize; i++) {
         statusT[i] = Status.empty;
      }
   }

   public int size() {
      return size;
   }

   public boolean full() {
      return size == maxSize;
   }

   public T retrieve() {
      return data[current];
   }

   public void update(T val) {
      data[current] = val;
   }

   public void delete() {
      statusT[current] = Status.deleted;
      size--;
   }

   public int insert(int key, T val) {
      int p = key % maxSize;
      int prop = 1;
      while(statusT[p].equals(Status.occupied) && prop < maxSize){
         p = (p + c) % maxSize;
         prop++;
         
      }
   
      if( prop <maxSize){
         statusT[p]= Status.occupied;
         data[p] = val;
         keys[p] = key;
         current = p;
         size++;
         return prop;
      }
   
      return 0;
   }

   public boolean find(int key) {
      int pos = key % maxSize, count=0;
      while(!statusT[pos].equals(Status.empty)&& count<maxSize){
         if(keys[pos] == key){
         current = pos;
            return true;
            }
         pos = (pos + c) %  maxSize;
         count++;
         
      }
      return false;
   }
   

   public String toString(){
      String str="";
      for(int i=0; i<size ; i++)
         str += keys[i] + "\n";
   
   
      return str;
   }
   
}
