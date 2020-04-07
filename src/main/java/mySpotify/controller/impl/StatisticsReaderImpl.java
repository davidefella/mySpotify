package mySpotify.controller.impl;

import java.util.List;
import mySpotify.controller.api.StatisticsReader;
import mySpotify.parser.ArtistsParser;
import mySpotify.parser.TracksParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsReaderImpl implements StatisticsReader {

  @Autowired
  ArtistsParser artistsParser;

  @Autowired
  TracksParser tracksParser;

  @RequestMapping(value = "v1/artists")
  public List<String> getArtistsStatistics() {

    return artistsParser.getDefaultArtistsFromSpotify();
  }

  @RequestMapping(value = "v1/artists", params = "timeRange")
  public List<String> getArtistsStatistics(@RequestParam String timeRange) {

    return artistsParser.getArtistsFromSpotify(timeRange);
  }

  @RequestMapping(value = "v1/artists", params = "artistsNumber")
  public List<String> getArtistsStatistics(@RequestParam int artistsNumber) {

    return artistsParser.getArtistsFromSpotify(artistsNumber);
  }

  @RequestMapping(value = "v1/artists", params = {"artistsNumber", "timeRange"})
  public List<String> getArtistsStatistics(@RequestParam int artistsNumber,
      @RequestParam String timeRange) {

    return artistsParser.getArtistsFromSpotify(artistsNumber, timeRange);
  }

  @GetMapping("/getTracksStats")
  public List<String> getTracksStatistics() {
    List<String> res = tracksParser.getTracksFromSpotify();

    return res;
  }
}