public class MovieEqualCond implements Cond<Movie> {
	
   private Movie data;
   
	public MovieEqualCond(Movie data) {
		this.data = data;
	}

	public boolean test(Movie data) { // initial version (list of genres is left)
      if (this.data.id == data.id)
         return true;
      if (this.data.title.equals(data.title))
         return true;
      if (data.genres != null){
      List<String> list = this.data.genres.findAllEle(new StringEqualCond(data.genres.retrieve()));
      if (list != null)
         return true;
         }
		return false;
	}
   
 /*  public boolean test(List<String> genres, String genre){ // initial version
      List<String> list = data.genres.findAllEle(new StringEqualCond(genre));
      if (genres != null)
         return true;
      return false;
   } */
}
