package mySpotify.controller.impl;

import java.util.List;
import mySpotify.controller.api.ArtistsReader;
import mySpotify.model.logs.ServiceLog;
import mySpotify.parser.ArtistsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistsReaderImpl implements ArtistsReader {

  @Autowired
  ArtistsParser artistsParser;

  @Autowired
  MongoTemplate mongoTemplate;

  @RequestMapping(value = "v1/artists")
  public List<String> getDefaultArtists() {

    String endPoint = "v1/artists";

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    List<String> artists = artistsParser.getDefaultArtistsFromSpotify();

    mongoTemplate.save(new ServiceLog(artists.toString(), endPoint, "OUT"));

    return artists;
  }

  @RequestMapping(value = "v1/artists", params = "timeRange")
  public List<String> getArtists(@RequestParam String timeRange) {

    String endPoint = "v1/artists?timeRange=" + timeRange;

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    List<String> artists = artistsParser.getArtistsFromSpotify(timeRange);

    mongoTemplate.save(new ServiceLog(artists.toString(), endPoint, "OUT"));

    return artists;
  }

  @RequestMapping(value = "v1/artists", params = "artistsNumber")
  public List<String> getArtists(@RequestParam int artistsNumber) {

    String endPoint = "v1/artists?artistsNumber=" + artistsNumber;

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    List<String> artists = artistsParser.getArtistsFromSpotify(artistsNumber);

    mongoTemplate.save(new ServiceLog(artists.toString(), endPoint, "OUT"));

    return artists;
  }

  @RequestMapping(value = "v1/artists", params = {"artistsNumber", "timeRange"})
  public List<String> getArtists(@RequestParam int artistsNumber, @RequestParam String timeRange) {

    String endPoint = "v1/artists?artistsNumber=" + artistsNumber + "&timeRange=" + timeRange;

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    List<String> artists = artistsParser.getArtistsFromSpotify(artistsNumber, timeRange);

    mongoTemplate.save(new ServiceLog(artists.toString(), endPoint, "OUT"));

    return artists;
  }
}