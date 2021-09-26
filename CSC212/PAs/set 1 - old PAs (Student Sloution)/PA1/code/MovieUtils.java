public class MovieUtils {
	// Return the movie with the given id if found, null otherwise.
	public static Movie findMovieById(List<Movie> movies, int id) {
      if (!movies.empty()){
        movies.findFirst();
        while (!movies.last()){
         if (movies.retrieve().id == id)
            return movies.retrieve();
         movies.findNext();
        }
        if (movies.retrieve().id == id)
         return movies.retrieve();
        /* List<String> genres = new LinkedList<String>();
         genres.insert("najd");
         Movie toTest = new Movie (id, "", genres);
         if (movies.findFirstEle(new MovieEqualCond (toTest)))
            return movies.retrieve(); */
         } 
		return null; 
	}
	// Return the list of movies having a given title. If none is found, empty list is returned.
	public static List<Movie> findMovieByTitle(List<Movie> movies, String title) {
  /*  List<String> genres = new LinkedList<String>();
      genres.insert("najd");
      Movie toTest = new Movie (-1, title, genres); */
      List<Movie> list = new LinkedList<Movie>();
      if (!movies.empty()){
         movies.findFirst();
         while(!movies.last()){
            if (movies.retrieve().title.equals(title)){
               list.insert(movies.retrieve());
            }
            movies.findNext();
         }
         if (movies.retrieve().title.equals(title)){
            list.insert(movies.retrieve());
            }
      }
         // list = movies.findAllEle(new MovieEqualCond (toTest)); 
		return list;
	}
	// Return the list of movies of a given genre. If none is found, empty list is returned.
	public static List<Movie> findMoviesByGenre(List<Movie> movies, String genre) {
     /* List<String> genres = new LinkedList<String>();
      genres.insert(genre);
      Movie toTest = new Movie (-1, "", genres); */
      List<Movie> list = new LinkedList<Movie>(); 
      if (!movies.empty()){
         // list = movies.findAllEle(new MovieEqualCond (toTest));
         movies.findFirst();
         while (!movies.last()) {
            movies.retrieve().genres.findFirst();
            while (!movies.retrieve().genres.last()){
               if (movies.retrieve().genres.retrieve().equals(genre))
                  list.insert(movies.retrieve());
               movies.retrieve().genres.findNext();
            }
            if (movies.retrieve().genres.retrieve().equals(genre))
               list.insert(movies.retrieve());
            movies.findNext();
         }
         if (movies.retrieve().genres.retrieve().equals(genre))
               list.insert(movies.retrieve());
       }
		return list;
	}
	// Return the list of movies of given genres (a movie must have all genres to be in the list). If none is found, empty list is returned. Assume genres is not empty.
	public static List<Movie> findMoviesByGenres(List<Movie> movies, List<String> genres) {
      List<Movie> list = new LinkedList<Movie>();
      if (!movies.empty()){
         genres.findFirst();
         list = findMoviesByGenre(movies, genres.retrieve());
         while (!genres.last()){
            list = findMoviesByGenre(list, genres.retrieve());
            genres.findNext(); 
         }
         
         }
		return list;
	} 
}
