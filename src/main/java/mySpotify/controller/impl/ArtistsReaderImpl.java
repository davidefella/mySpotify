package mySpotify.controller.impl;

import java.util.List;
import mySpotify.controller.api.ArtistsReader;
import mySpotify.parser.ArtistsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mySpotify.logging.LogManager;

@RestController
public class ArtistsReaderImpl implements ArtistsReader {

  @Autowired
  ArtistsParser artistsParser;

  @Autowired
  LogManager logManager;

  @RequestMapping(value = "v1/artists")
  public List<String> getDefaultArtists() {

    String endPoint = "v1/artists";

    logManager.save("", endPoint, "IN");

    List<String> artists = artistsParser.getDefaultArtistsFromSpotify();

    logManager.save(artists.toString(), endPoint, "OUT");

    return artists;
  }

  @RequestMapping(value = "v1/artists", params = "timeRange")
  public List<String> getArtists(@RequestParam String timeRange) {

    String endPoint = "v1/artists?timeRange=" + timeRange;

    logManager.save("", endPoint, "IN");

    List<String> artists = artistsParser.getArtistsFromSpotify(timeRange);

    logManager.save(artists.toString(), endPoint, "OUT");

    return artists;
  }

  @RequestMapping(value = "v1/artists", params = "artistsNumber")
  public List<String> getArtists(@RequestParam int artistsNumber) {

    String endPoint = "v1/artists?artistsNumber=" + artistsNumber;

    logManager.save("", endPoint, "IN");

    List<String> artists = artistsParser.getArtistsFromSpotify(artistsNumber);

    logManager.save(artists.toString(), endPoint, "OUT");

    return artists;
  }

  @RequestMapping(value = "v1/artists", params = {"artistsNumber", "timeRange"})
  public List<String> getArtists(@RequestParam int artistsNumber, @RequestParam String timeRange) {

    String endPoint = "v1/artists?artistsNumber=" + artistsNumber + "&timeRange=" + timeRange;

    logManager.save("", endPoint, "IN");

    List<String> artists = artistsParser.getArtistsFromSpotify(artistsNumber, timeRange);

    logManager.save(artists.toString(), endPoint, "OUT");

    return artists;
  }
}