package katas;

import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retriev title, e id,and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> rating = movieLists.stream()
                .map(MovieList::getVideos).
                flatMap(List::stream)
                .filter(m -> m.getBoxarts().stream().anyMatch(boxArt -> boxArt.getWidth() == 150 && boxArt.getHeight() == 200))
                .map((m) ->  ImmutableMap.of("id", m.getId(), "title", m.getTitle(), "boxart", m.getBoxarts())).map(ImmutableMap::copyOf).collect(Collectors.toList());
        return rating;
    }
}
