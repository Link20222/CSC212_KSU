public class PowerGridUtils {

	// Return the IDs of all elements in the power grid pg in pre-order.
	public static Queue<Integer> collectPreorder(GT<PGElem> pg){
      Queue<Integer> IDs = new LinkedQueue<Integer>();
      pg.findRoot();
      recPreorder(IDs, pg);
      return IDs;
   }

	// Searches the power grid pg for the element with ID id. If found, it is made current and true is returned, otherwise false is returned.
	public static boolean find(GT<PGElem> pg, int id){
      pg.findRoot();
      return recFind(pg, id);
   }

	// Add the generator element gen to the power grid pg. This can only be done if the grid is empty. If successful, the method returns true. If there is already a generator, or gen is not of type Generator, false is returned.
	public static boolean addGenerator(GT<PGElem> pg, PGElem gen){
      if (pg.empty() && gen.getType() == ElemType.Generator){
         pg.insert(gen);
         return true;
         }
      return false;
   }

	// Attaches pgn to the element id and returns true if successful. Note that a consumer can only be attached to a transmitter, and no element can be be attached to it. The tree must not contain more than one generator located at the root. If id does not exist, or there is already aelement with the same ID as pgn, pgn is not attached, and the method retrurns false.
	public static boolean attach(GT<PGElem> pg, PGElem pgn, int id){
      /*if (pg == null)
         return false;
      switch (pgn.getType()){
         case Generator: return addGenerator(pg, pgn); 
         case Consumer: if (find(pg, id)){
                                    if (pg.retrieve().getType() == ElemType.Generator || pg.retrieve().getType() == ElemType.Consumer) // don't add consumer to a generator or another consumer
                                       return false;
                                    else // id belongs to transmitter
                                       return pg.insert(pgn);
                                    } 
                                    break;
         case Transmitter: if (find(pg, id)){
                                       if (pg.retrieve().getType() == ElemType.Consumer) // don't add transmitter to a consumer
                                          return false;
                                       else // id belongs to either generator or another transmitter
                                          return pg.insert(pgn);   
                                    } 
                                    break;
         default: return false; 
      } */
      return false;
   }

	// Removes element by ID, all corresponding subtree is removed. If removed, true is returned, false is returned otherwise.
	public static boolean remove(GT<PGElem> pg, int id){
      if (pg != null && !pg.empty() && find(pg, id)){
         pg.remove();
         return true;
      }
      return false;
   }

	// Computes total power that consumed by an element (and all its subtree). If id is incorrect, -1 is returned.
	public static double totalPower(GT<PGElem> pg, int id){
      if(find(pg, id)){
         return recTotal(pg, id);
         }
      return -1;
   }

	// Checks if the power grid contains an overload. The method returns the ID of the first element preorder that has an overload and -1 if there is no overload.
	public static int findOverload(GT<PGElem> pg){    
      if (!pg.empty() && pg != null){
         pg.findRoot();
         return recOver(pg);
      }
      return -1;
   }
   
   private static void recPreorder(Queue<Integer> IDs, GT<PGElem> pg){
      IDs.enqueue(pg.retrieve().getId());
      if (pg.retrieve() == null)
         return;
      else{
         for (int i=0; i<pg.nbChildren(); i++){
            pg.findChild(i);
            recPreorder(IDs, pg);
            pg.findParent();  
         }
      }  
   }
   
   private static boolean recFind(GT<PGElem> pg, int id){
      /*if (pg.retrieve() == null)
         return false;*/
      if (pg.retrieve().getId() == id)
         return true; 
      for (int i=0; i<pg.nbChildren(); i++){
            pg.findChild(i);
            recFind(pg, id);
            pg.findParent();  
         }
         return false;    
   }
   
   private static double recTotal(GT<PGElem> pg, int id){
      if (pg.nbChildren()==0 && pg.retrieve().getType() == ElemType.Consumer){
         return pg.retrieve().getPower();
      }
      else if (pg.retrieve().getType() == ElemType.Transmitter || pg.retrieve().getType() == ElemType.Generator){
         return 0;
      }
      double total = 0;
      for (int i=0; i<pg.nbChildren(); i++){
         pg.findChild(i);
         total+=recTotal(pg, id);
         pg.findParent();  
         }  
       return total;
   }
   
   private static int recOver(GT<PGElem> pg){
      double total = totalPower(pg, pg.retrieve().getId()); 
      if (pg.retrieve().getPower() > total)
         return pg.retrieve().getId();
      for (int i=0; i<pg.nbChildren(); i++){
         pg.findChild(i);
         int over = recOver(pg);
         if (over > -1){
            return over;
            }
         pg.findParent();  
         }  
       return -1;     
   }
   
}
