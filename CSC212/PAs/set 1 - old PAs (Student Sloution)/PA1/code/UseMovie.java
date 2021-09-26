public class UseMovie {
public static void main (String[] args){
List<Movie> movies = new LinkedList<Movie>();
List<String> genres = new LinkedList<String>();
genres.insert("Adventure");
genres.insert("Animation");
genres.insert("Children");
genres.insert("Comedy");
genres.insert("Fantasy");
movies.insert(new Movie(1, "Toy Story (1995)", genres));
}
}
