package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        Optional<BoxArt> someUrl = movies.stream()
                .map(movie -> movie.getBoxarts())
                .flatMap(c->c.stream())
                .reduce((e,f) -> e.getWidth()>f.getWidth()?e:f);

        return someUrl.get().getUrl();
    }
}
