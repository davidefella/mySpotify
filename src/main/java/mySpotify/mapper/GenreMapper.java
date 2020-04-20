package mySpotify.mapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import mySpotify.MySpotifyApplication;
import mySpotify.model.Artists.Items;
import mySpotify.util.CountingGenreComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GenreMapper {

  Logger logger = LoggerFactory.getLogger(MySpotifyApplication.class);

  public Map<String, String> countGenreFromArtists(List<Items> artists) {
    Map<String, String> countPercentage = new HashMap<>();

    countPercentage = genresCountingToPercentage(countAllGenresFromArtists(artists));

    return countPercentage;

  }

  public Map<String, String> genresCountingToPercentage(Map<String, Integer> allGenreToCounting) {
    Map<String, String> mapsPercentage = new HashMap<>();

    Map<String, Integer> genreGrouped = groupMusicGenre(allGenreToCounting);

    int tot = sumAllGenreCount(genreGrouped);

    int genrePercentage;
    for (String s : genreGrouped.keySet()) {
      genrePercentage = (genreGrouped.get(s) * 100) / tot;

      mapsPercentage.put(s, (String.valueOf(genrePercentage).concat("%")));
    }

    return mapsPercentage;
  }

  private int sumAllGenreCount(Map<String, Integer> mapsGrouped) {
    int sum = 0;

    Collection<Integer> counts = mapsGrouped.values();

    for (Integer i : counts) {
      sum = sum + i;
    }

    return sum;
  }

  public Map<String, Integer> countAllGenresFromArtists(List<Items> artists) {
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

    Map<String, Integer> newMap = new TreeMap<>(countingGenreComparator);
    newMap.putAll(genreToCounting);

    return newMap;

  }

  private Map<String, Integer> groupMusicGenre(Map<String, Integer> allGenreToCounting) {
    Map<String, Integer> countMusicGenres = new HashMap<>();
    String superGenre;

    Set<Entry<String, Integer>> setFromTreeMaps = allGenreToCounting.entrySet();
    for (Map.Entry<String, Integer> entry : setFromTreeMaps) {

      superGenre = getGenreGrouped(entry.getKey());

      if (countMusicGenres.containsKey(superGenre)) {
        countMusicGenres
            .put(superGenre, (countMusicGenres.get(superGenre) + entry.getValue()));
      } else {
        countMusicGenres.put(superGenre, entry.getValue());
      }
    }

    return countMusicGenres;
  }

  /*@TODO: Improve this function*/
  private String getGenreGrouped(String genre) {
    String superGenre = "other";

    if (genre.contains("rock")) {
      return "rock";
    } else if (genre.contains("metal") || genre.equals("neue deutsche harte") || genre
        .equals("wrestling") || genre.equals("old school thrash") || genre.equals("industrial")
        || genre.equals("slayer")) {
      return "metal";
    } else if (genre.contains("grunge")) {
      return "grunge";
    } else if (genre.contains("hip hop")) {
      return "hip pop";
    } else if (genre.contains("pop") || genre.equals("italian alternative") || genre
        .equals("italian reggae")) {
      return "pop";
    } else if (genre.contains("punk") || genre.equals("chicago hardcore") || genre
        .equals("permanent wave")) {
      return "punk";
    } else if (genre.contains("indie")) {
      return "indie";
    } else if (genre.contains("rap")) {
      return "rap";
    }

    logger.warn(genre);

    return superGenre;
  }
}