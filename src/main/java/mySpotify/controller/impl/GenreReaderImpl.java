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
    return genreParse.getGenresFromSpotify();
  }
}
