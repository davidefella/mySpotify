package mySpotify.controller.impl;

import java.util.List;
import mySpotify.controller.api.ArtistsReader;
import mySpotify.parser.ArtistsParser;
import mySpotify.parser.TracksParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistsReaderImpl implements ArtistsReader {

  @Autowired
  ArtistsParser artistsParser;

  @Autowired
  TracksParser tracksParser;

  @RequestMapping(value = "v1/artists")
  public List<String> getDefaultArtists() {

    return artistsParser.getDefaultArtistsFromSpotify();
  }

  @RequestMapping(value = "v1/artists", params = "timeRange")
  public List<String> getArtists(@RequestParam String timeRange) {

    return artistsParser.getArtistsFromSpotify(timeRange);
  }

  @RequestMapping(value = "v1/artists", params = "artistsNumber")
  public List<String> getArtists(@RequestParam int artistsNumber) {

    return artistsParser.getArtistsFromSpotify(artistsNumber);
  }

  @RequestMapping(value = "v1/artists", params = {"artistsNumber", "timeRange"})
  public List<String> getArtists(@RequestParam int artistsNumber,
      @RequestParam String timeRange) {

    return artistsParser.getArtistsFromSpotify(artistsNumber, timeRange);
  }
}