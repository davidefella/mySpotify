package mySpotify.parser;

import java.util.Map;
import mySpotify.mapper.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreParser {

  @Autowired
  ArtistsParser artistsParser;

  @Autowired
  GenreMapper genreMapper;

  public Map<String, Integer> getGenresFromDefault() {

    Map<String, Integer> stringIntegerMap = genreMapper
        .countGenreFromArtists(artistsParser.getItemsDefaultArtistsFromSpotify());

    return stringIntegerMap;
  }

  public Map<String, Integer> getGenresFromSpotify(int artistsNumber) {

    Map<String, Integer> stringIntegerMap = genreMapper
        .countGenreFromArtists(artistsParser.getItemsArtistsFromSpotify(artistsNumber));

    return stringIntegerMap;
  }

  public Map<String, Integer> getGenresFromSpotify(int artistsNumber, String timeRange) {

    Map<String, Integer> stringIntegerMap = genreMapper
        .countGenreFromArtists(artistsParser.getItemsArtistsFromSpotify(artistsNumber, timeRange));

    return stringIntegerMap;
  }

  public Map<String, Integer> getGenresFromSpotify(String timeRange) {

    Map<String, Integer> stringIntegerMap = genreMapper
        .countGenreFromArtists(artistsParser.getItemsArtistsFromSpotify(timeRange));

    return stringIntegerMap;
  }
}