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

  public Map<String, String> getGenresFromDefault() {

    Map<String, String> stringIntegerMap = genreMapper
        .countGenreFromArtists(artistsParser.getItemsDefaultArtistsFromSpotify());

    return stringIntegerMap;
  }

  public Map<String, String> getGenresFromSpotify(int artistsNumber) {

    Map<String, String> stringIntegerMap = genreMapper
        .countGenreFromArtists(artistsParser.getItemsArtistsFromSpotify(artistsNumber));

    return stringIntegerMap;
  }

  public Map<String, String> getGenresFromSpotify(int artistsNumber, String timeRange) {

    Map<String, String> stringIntegerMap = genreMapper
        .countGenreFromArtists(artistsParser.getItemsArtistsFromSpotify(artistsNumber, timeRange));

    return stringIntegerMap;
  }

  public Map<String, String> getGenresFromSpotify(String timeRange) {

    Map<String, String> stringIntegerMap = genreMapper
        .countGenreFromArtists(artistsParser.getItemsArtistsFromSpotify(timeRange));

    return stringIntegerMap;
  }
}