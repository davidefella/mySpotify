package spotify.user.details.reader.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spotify.user.details.reader.controller.api.StatisticsReader;
import spotify.user.details.reader.parser.ArtistsParser;

@RestController
public class StatisticsReaderImpl implements StatisticsReader {

  @Autowired
  ArtistsParser artistsParser;

  @GetMapping("/getArtistsStats")
  public String getArtistsStatistics() {

    String res = artistsParser.getArtistsFromSpotify();

    return res;
  }
}
