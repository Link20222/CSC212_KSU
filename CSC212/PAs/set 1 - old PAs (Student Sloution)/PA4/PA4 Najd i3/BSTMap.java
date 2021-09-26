public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
	public BSTNode<K, T> root; // Do not change this
	private int size;
   
	public BSTMap() {
		root = null;
      size = 0;
	}
   
   public int size(){
      return size;
   }
   
   public boolean full(){
      return false;
   }
   
   public void clear(){
      root = null;
      size = 0;
   }
   
   public boolean update(K k, T e){
      Pair<BSTNode<K, T>, BSTNode<K, T>> pair = findkey(k);
      BSTNode<K, T> pointer = pair.first;
      if (pointer != null){
         pointer.data = e;
         return true;
      }
     return false;
   }
   
   public Pair<Boolean, T> retrieve(K k){
      Pair<Boolean, T> pair = new Pair<Boolean, T>(false, null);
      Pair<BSTNode<K, T>, BSTNode<K, T>> pairN = findkey(k);
      BSTNode<K, T> pointer = pairN.first;
      if (pointer != null){
         pair.first = true;
         pair.second = pointer.data;
      }
      return pair;
   }
   
   public boolean insert(K k, T e){
      BSTNode<K, T> data = new BSTNode<K, T>(k, e);
      Pair<BSTNode<K, T>, BSTNode<K, T>> pair = findkey(k);
      BSTNode<K, T> pointer = pair.first;
      BSTNode<K, T> parent = pair.second;
      if (pointer != null) {
         return false;
      }
      if (size == 0){
         root = data;
         size++;
         return true;
      }
      else {
         if (k.compareTo(parent.key) == -1)
            parent.left = data;
         else
            parent.right = data;
          size++;
          return true;
      }
      
   }
   
   public boolean remove(K k){
      Pair<BSTNode<K, T>, BSTNode<K, T>> pair = findkey(k);
      BSTNode<K, T> pointer = pair.first;
      BSTNode<K, T> parent = pair.second;
      K key = k;
      if (pointer != null){
         if ((pointer.left != null) && (pointer.right != null)) { // Third case (Two children)
            BSTNode<K, T> min = pointer.right;
            parent = pointer;
            while (min.left != null){
               parent = min;
               min = min.left;
            }
            pointer.key = min.key;
            pointer.data = min.data;
            key = min.key;
            pointer = min;
         } // until this point we just duplicated the min key in the right subtree to the desired node, no node is removed yet
         if (pointer.left != null) // Second case (one child)
            pointer = pointer.left;
         else // one child or no children
            pointer = pointer.right;
         // we want to link the child of pointer to the parent of pointer, if the pointer has no children we will simply link the parent to null
         if (parent == null) 
            root = pointer;
         else { // here is the real deletion
            if (key.compareTo(parent.key) == -1){
               parent.left = pointer;
            }
            else {
               parent.right = pointer;
            }
         }
         size--;
         return true;
      }
      return false;
   } 
   
   public List<K> getKeys(){
      List<K> keys = new LinkedList<K>();
      recKey(keys, root);
      return keys;
   }
   
   // My methods
   
   private Pair<BSTNode<K, T>, BSTNode<K, T>> findkey(K tkey) {
      BSTNode<K, T> p = root, q = null;
      if(size == 0)
         return new Pair<BSTNode<K, T>, BSTNode<K, T>> (p, q);
      while(p != null) {
         if(p.key.equals(tkey)) {
            return new Pair<BSTNode<K, T>, BSTNode<K, T>> (p, q);
         }
         else if(tkey.compareTo(p.key) == -1){
            q = p;
            p = p.left;
            }
         else{
            q = p;
            p = p.right;
            }
         
      }
      return new Pair<BSTNode<K, T>, BSTNode<K, T>> (p, q); 
   }
      
   private void recKey(List<K> list, BSTNode<K, T> tmp){
      if (tmp == null)
         return;
      recKey(list, tmp.left);
      list.insert(tmp.key);
      recKey(list, tmp.right);
   }
}
