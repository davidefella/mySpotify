package mySpotify.controller.impl;

import java.util.List;
import mySpotify.controller.api.StatisticsReader;
import mySpotify.parser.ArtistsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsReaderImpl implements StatisticsReader {

  @Autowired
  ArtistsParser artistsParser;

  @GetMapping("/getArtistsStats")
  public List<String> getArtistsStatistics() {
    List<String> res = artistsParser.getArtistsFromSpotify();

    return res;
  }
}