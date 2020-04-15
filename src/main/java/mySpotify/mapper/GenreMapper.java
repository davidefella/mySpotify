package mySpotify.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import mySpotify.MySpotifyApplication;
import mySpotify.model.Artists.Items;
import mySpotify.util.CountingGenreComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GenreMapper {

  public Map<String, Integer> countGenreFromArtists(List<Items> artists) {
    Map<String, Integer> genreToCounting = new HashMap<>();
    CountingGenreComparator countingGenreComparator = new CountingGenreComparator(genreToCounting);

    List<String> genresForArtists;

    for (int i = 0; i < artists.size(); i++) {
      genresForArtists = artists.get(i).getGenres();

      for (String s : genresForArtists) {
        if (genreToCounting.containsKey(s)) {
          genreToCounting.put(s, (genreToCounting.get(s) + 1));
        } else {
          genreToCounting.put(s, 1);
        }
      }
    }

    Map<String, Integer> newMap = new TreeMap<String, Integer>(countingGenreComparator);
    newMap.putAll(genreToCounting);

    return newMap;
  }
}