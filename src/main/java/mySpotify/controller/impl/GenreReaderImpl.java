package mySpotify.controller.impl;

import java.util.Map;
import mySpotify.controller.api.GenreReader;
import mySpotify.parser.GenreParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mySpotify.logging.LogManager;

@RestController
public class GenreReaderImpl implements GenreReader {

  @Autowired
  GenreParser genreParse;

  @Autowired
  LogManager logManager;

  @RequestMapping(value = "v1/genres")
  public Map<String, String> getGenres() {

    String endPoint = "v1/genres";

    logManager.save("", endPoint, "IN");

    Map<String, String> genres2count = genreParse.getGenresFromDefault();
    
    logManager.save(genres2count.toString(), endPoint, "OUT");

    return genres2count;
  }

  @RequestMapping(value = "v1/genres", params = "timeRange")
  public Map<String, String> getGenre(String timeRange) {

    String endPoint = "v1/genres?timeRange" + timeRange;

    logManager.save("", endPoint, "IN");

    Map<String, String> genres2count = genreParse.getGenresFromSpotify(timeRange);

    logManager.save(genres2count.toString(), endPoint, "OUT");

    return genres2count;
  }

  @RequestMapping(value = "v1/genres", params = "artistsNumber")
  public Map<String, String> getGenre(int artistsNumber) {

    String endPoint = "v1/genres?artistsNumber" + artistsNumber;

    logManager.save("", endPoint, "IN");

    Map<String, String> genres2count = genreParse.getGenresFromSpotify(artistsNumber);

    logManager.save(genres2count.toString(), endPoint, "OUT");

    return genres2count;

  }

  @RequestMapping(value = "v1/genres", params = {"artistsNumber", "timeRange"})
  public Map<String, String> getGenre(int artistsNumber, String timeRange) {
    String endPoint = "v1/genres?artistsNumber" + artistsNumber + "&timeRange" + timeRange;

    logManager.save("", endPoint, "IN");

    Map<String, String> genres2count = genreParse.getGenresFromSpotify(artistsNumber, timeRange);

    logManager.save(genres2count.toString(), endPoint, "OUT");

    return genres2count;
  }
}