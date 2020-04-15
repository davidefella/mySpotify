package mySpotify.controller.impl;

import java.util.Map;
import mySpotify.controller.api.GenreReader;
import mySpotify.model.logs.ServiceLog;
import mySpotify.parser.GenreParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreReaderImpl implements GenreReader {

  @Autowired
  GenreParser genreParse;

  @Autowired
  MongoTemplate mongoTemplate;

  @RequestMapping(value = "v1/genres")
  public Map<String, Integer> getGenres() {

    String endPoint = "v1/genres";

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    Map<String, Integer> genres2count = genreParse.getGenresFromDefault();

    mongoTemplate.save(new ServiceLog(genres2count.toString(), endPoint, "OUT"));

    return genres2count;
  }

  @RequestMapping(value = "v1/genres", params = "timeRange")
  public Map<String, Integer> getGenre(String timeRange) {

    String endPoint = "v1/genres?timeRange" + timeRange;

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    Map<String, Integer> genres2count = genreParse.getGenresFromSpotify(timeRange);

    mongoTemplate.save(new ServiceLog(genres2count.toString(), endPoint, "OUT"));

    return genres2count;
  }

  @RequestMapping(value = "v1/genres", params = "artistsNumber")
  public Map<String, Integer> getGenre(int artistsNumber) {

    String endPoint = "v1/genres?artistsNumber" + artistsNumber;

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    Map<String, Integer> genres2count = genreParse.getGenresFromSpotify(artistsNumber);

    mongoTemplate.save(new ServiceLog(genres2count.toString(), endPoint, "OUT"));

    return genres2count;

  }

  @RequestMapping(value = "v1/genres", params = {"artistsNumber", "timeRange"})
  public Map<String, Integer> getGenre(int artistsNumber, String timeRange) {
    String endPoint = "v1/genres?artistsNumber" + artistsNumber + "&timeRange" + timeRange;

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    Map<String, Integer> genres2count = genreParse.getGenresFromSpotify(artistsNumber, timeRange);

    mongoTemplate.save(new ServiceLog(genres2count.toString(), endPoint, "OUT"));

    return genres2count;
  }
}