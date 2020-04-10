package mySpotify.controller.impl;

import java.util.Map;
import mySpotify.controller.api.GenreReader;
import mySpotify.parser.GenreParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreReaderImpl implements GenreReader {

  @Autowired
  GenreParser genreParse;

  @RequestMapping(value = "v1/genres")
  public Map<String, Integer> getGenres() {
    return genreParse.getGenresFromDefault();
  }

  @RequestMapping(value = "v1/genres", params = "timeRange")
  public Map<String, Integer> getGenre(String timeRange) {
    return genreParse.getGenresFromSpotify(timeRange);
  }

  @RequestMapping(value = "v1/genres", params = "artistsNumber")
  public Map<String, Integer> getGenre(int artistsNumber) {
    return genreParse.getGenresFromSpotify(artistsNumber);
  }

  @RequestMapping(value = "v1/genres",params = {"artistsNumber", "timeRange"})
  public Map<String, Integer> getGenre(int artistsNumber, String timeRange) {
    return genreParse.getGenresFromSpotify(artistsNumber, timeRange);
  }
}