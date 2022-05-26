package katas;

import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> newList = movieLists.stream().map((MovieList::getVideos))
                .flatMap(c->c.stream())
                .map(movie -> ImmutableMap.of("id", movie.getId(), "title",movie.getTitle(), "time", movie.getInterestingMoments().stream().filter(a -> a.getType().equals("middle")), "url", movie.getBoxarts().stream().reduce((x,y)->x.getWidth()<y.getWidth()?x:y)))
                .collect(Collectors.toList());

        return newList;
    }
}
