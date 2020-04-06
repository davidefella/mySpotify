package mySpotify.controller.impl;

import java.util.List;
import mySpotify.controller.api.StatisticsReader;
import mySpotify.parser.ArtistsParser;
import mySpotify.parser.TracksParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsReaderImpl implements StatisticsReader {
  final String v1 = "v1";

  @Autowired
  ArtistsParser artistsParser;

  @Autowired
  TracksParser tracksParser;

  @GetMapping(v1 + "/artists")
  public List<String> getArtistsStatistics() {

    return artistsParser.getDefaultArtistsFromSpotify();
  }

  @GetMapping(v1 + "/artists/number/{artistsNumber}")
  public List<String> getArtistsStatistics(@PathVariable int artistsNumber) {

    return artistsParser.getArtistsFromSpotify(artistsNumber);
  }

  @GetMapping(v1 + "/artists/term/{timeRange}")
  public List<String> getArtistsStatistics(@PathVariable String timeRange) {

    return artistsParser.getArtistsFromSpotify(timeRange);
  }

  @GetMapping(v1 + "/artists/{artistsNumber}/{timeRange}")
  public List<String> getArtistsStatistics(@PathVariable int artistsNumber, @PathVariable String timeRange) {

    return artistsParser.getArtistsFromSpotify(artistsNumber, timeRange);
  }

  @GetMapping("/getTracksStats")
  public List<String> getTracksStatistics() {
    List<String> res = tracksParser.getTracksFromSpotify();

    return res;
  }
}