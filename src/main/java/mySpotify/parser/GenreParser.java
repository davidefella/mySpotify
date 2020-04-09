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

  public Map<String, Integer> getGenresFromSpotify() {

    Map<String, Integer> stringIntegerMap = genreMapper
        .countGenreFromArtists(artistsParser.getItemsDefaultArtistsFromSpotify());

    return stringIntegerMap;

  }
}