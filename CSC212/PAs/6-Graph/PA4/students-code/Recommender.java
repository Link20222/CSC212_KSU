import java.io.File;
import java.util.Scanner;

public class Recommender {

	// Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
		PQK<Double, K> popular = new PQKImp<Double, K>(k);
      List<K> keys = g.getNodes();
      if (g.isNode(i)){
         //List<K> neighbors = g.neighb(i);
         keys.findFirst();
         for (int h=0; h<keys.size(); h++){
            if (!g.isEdge(i, keys.retrieve()) && keys.retrieve().compareTo(i) != 0){
               double degree = g.deg(keys.retrieve());
               popular.enqueue(degree, keys.retrieve());
               }
            keys.findNext();
         }
         return popular;
      }
      return null;
	}

	// Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
		PQK<Double, K> common = new PQKImp<Double, K>(k);
      List<K> keys = g.getNodes();
      if (g.isNode(i)){
         List<K> neighbors = g.neighb(i);
         keys.findFirst();
         for (int h=0; h<keys.size(); h++){
            if (!g.isEdge(i, keys.retrieve()) && keys.retrieve().compareTo(i) != 0){
               neighbors.findFirst();
               double count = 0;
               for (int j=0; j<neighbors.size(); j++){
                  if(g.isEdge(neighbors.retrieve(), keys.retrieve())){
                     count++;
                  }
                  neighbors.findNext(); 
               }
               common.enqueue(count, keys.retrieve());
            }
            keys.findNext();
         }
         return common;
      }
      return null;
	}

	// Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
	public static Graph<Integer> read(String fileName) {

		try {
			Graph<Integer> g = new MGraph<Integer>();
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextInt()) {
				int i = scanner.nextInt();
				g.addNode(i);
				int j = scanner.nextInt();
				g.addNode(j);
				g.addEdge(i, j);
			}
			scanner.close();
			return g;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
