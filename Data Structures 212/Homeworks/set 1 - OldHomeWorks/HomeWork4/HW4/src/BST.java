
public class BST<T> {

   public BSTNode<T> root, current;

   public BST() {
      current = root = null;
   }

   public void clear() {
      current = root = null;
   }

   public boolean empty() {
      return root == null;
   }

   public boolean full() {
      return false;
   }

   public T retrieve() {
      return current.data;
   }

   public boolean findKey(int k) {
   
      BSTNode<T> p = root;
      while (p != null) {
         current = p;
         if (k == p.key) {
            return true;
         } 
         else if (k < p.key) {
            p = p.left;
         } 
         else {
            p = p.right;
         }
      }
      return false;
   }

   public int nbComp(int k) {
   
      int nb = 0;
      BSTNode<T> p = root;
      while (p != null) {
         nb++;
         if (k == p.key) {
            break;
         } 
         else if (k < p.key) {
            p = p.left;
         } 
         else {
            p = p.right;
         }
      }
      return nb;
   }

   public boolean insert(int k, T val) {
      if (root == null) {
         current = root = new BSTNode<T>(k, val);
         return true;
      }
   
      BSTNode<T> p = current;
      if (findKey(k)) {
         current = p;
         return false;
      }
   
      BSTNode<T> tmp = new BSTNode<T>(k, val);
      if (k < current.key) {
         current.left = tmp;
      } 
      else {
         current.right = tmp;
      }
      current = tmp;
      return true;
   }

   public boolean removeKey(int k) {
   
   	// Search for k
      int k1 = k;
      BSTNode<T> p = root;
      BSTNode<T> q = null; // Parent of p
      while (p != null) {
      
         if (k1 < p.key) {
            q = p;
            p = p.left;
         } 
         else if (k1 > p.key) {
            q = p;
            p = p.right;
         } 
         else { // Found the key
         
         	// Check the three cases
            if ((p.left != null) && (p.right != null)) { // Case 3: two
            												// children
            
            	// Search for the min in the right subtree
               BSTNode<T> min = p.right;
               q = p;
               while (min.left != null) {
                  q = min;
                  min = min.left;
               }
               p.key = min.key;
               p.data = min.data;
               k1 = min.key;
               p = min;
            	// Now fall back to either case 1 or 2
            }
         
         	// The subtree rooted at p will change here
            if (p.left != null) { // One child
               p = p.left;
            } 
            else { // One or no children
               p = p.right;
            }
         
            if (q == null) { // No parent for p, root must change
               root = p;
            } 
            else {
               if (k1 < q.key) {
                  q.left = p;
               } 
               else {
                  q.right = p;
               }
            }
            current = root;
            return true;
         }
      }
   
      return false; // Not found
   }

   public boolean update(int key, T data) {
      removeKey(current.key);
      return insert(key, data);
   }

	// problem4.2
   public void print() {
      BSTNode<T> p = root;
      recprint(p);
   }

   public void recprint(BSTNode<T> p) {
      if (p == null)
         return;
      recprint(p.right);
      System.out.print(p.key + ",");
      recprint(p.left);
   
   }

	// problem 4.1
   private void swapData(int k) {
      BSTNode<T> p = root, q = null;
      while (p != null && p.key != k) {
         q = p;
         if (k < p.key)
            p = p.left;
         else
            p = p.right;
      }
      if (p == null || p == root)
         return;
      T tmp = p.data;
      p.data = q.data;
      q.data = tmp;
   
   }

	// problem 5.1
   public int nbInRange(int k1, int k2) {
      BSTNode<T> p = root;
      return nbInRange(k1, k2, p);
   }

   public int nbInRange(int k1, int k2, BSTNode<T> p) {
      if (p == null)
         return 0;
   
      if (p.key > k1 && p.key < k2)
         return 1 + nbInRange(k1, k2, p.left) + nbInRange(k1, k2, p.right);
   
      if (p.key <= k1) {
         if (p.key == k1)
            return 1 + nbInRange(k1, k2, p.right);
         else
            return nbInRange(k1, k2, p.right);
      }
      if (p.key == k2)
         return 1 + nbInRange(k1, k2, p.left);
      else
         return nbInRange(k1, k2, p.left);
   }

	//problem5.2
   public int deepestKey(BSTNode<T> t) {
      int value = 0, level = 0 , tmpLevel = 0;
      BSTNode<T> p = t;
      LinkedStack<Integer> Levels = new LinkedStack<Integer>();
      LinkedStack<BSTNode<T>> tmp = new LinkedStack<BSTNode<T>>();
   
      while (p != null) {
         if (p.left == null && p.right == null)
            if (tmpLevel < level) {
               tmpLevel = level;
               value = p.key;
            }
         if (p.right != null) {
            Levels.push(level + 1);
            tmp.push(p.right);
         }
         if (p.left != null) {
            p = p.left;
            level++;
         } 
         else {
            if (!tmp.empty()) {
               p = tmp.pop();
               level = Levels.pop();
            } 
            else
               p = null;
         }
      
      }
      return value;
   }
   public  boolean insub(int k1 , int k2){
      BSTNode<T> p = root;
      while(p!=null && p.key!=k1){
         if (p.key<k1)
            p = p.right;
         else
            p = p.left;
      }
      if ( p == null)
         return false;
      while ( p!=null && p.key != k2){
         if (p.key<k2)
            p = p.right;
         else
            p = p.left;
      }
      if ( p == null )
         return false;
   
      return true;
   }
}
