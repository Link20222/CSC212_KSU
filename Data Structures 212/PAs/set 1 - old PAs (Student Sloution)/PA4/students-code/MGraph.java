public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Map<K, List<K>> adj; // Do not change this
	
   public MGraph() {
		adj = new BSTMap<K, List<K>>();
	}
	
   public boolean addNode(K i){
      List<K> n = new LinkedList<K>();
      return adj.insert(i, n);
   }
   
   public boolean isNode(K i){
      List<K> keys = adj.getKeys();
      return keys.exists(i);
   }
   
   public boolean addEdge(K i, K j){
      List<K> keys = adj.getKeys();
      if (keys.exists(i) && keys.exists(j)){ // both nodes exist
         if (isEdge(i, j))
            return false;
         Pair<Boolean, List<K>> pI = adj.retrieve(i), pJ = adj.retrieve(j); // lists of neighbors
         pI.second.insert(j);
         pJ.second.insert(i);
         return true;
      }
      return false;
   }
   
   public boolean isEdge(K i, K j){
      List<K> keys = adj.getKeys();
      if (keys.exists(i) && keys.exists(j)){ // both nodes exist
         Pair<Boolean, List<K>> pI = adj.retrieve(i), pJ = adj.retrieve(j); // lists of neighbors
         if (pI.second.exists(j) && pJ.second.exists(i)) // edge exist
            return true;
         return false;
      }
      return false;
   }
   
   public List<K> neighb(K i){
      List<K> keys = adj.getKeys();
      List<K> n = new LinkedList<K>();
      if (keys.exists(i)){
         n = adj.retrieve(i).second;
         return n;
         }
      return null;
   }
   
   public int deg(K i){
      List<K> keys = adj.getKeys();
      if (keys.exists(i))
         return adj.retrieve(i).second.size();
      return -1;
   }
   
   public List<K> getNodes(){
      return adj.getKeys();
   }
   
}
