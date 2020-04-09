package mySpotify.controller.impl;

import java.util.List;
import mySpotify.controller.api.TracksReader;
import mySpotify.parser.ArtistsParser;
import mySpotify.parser.TracksParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TracksReaderImpl implements TracksReader {

  @Autowired
  ArtistsParser artistsParser;

  @Autowired
  TracksParser tracksParser;

  @RequestMapping(value = "v1/tracks")
  public List<String> getDefaultTracks() {
    return tracksParser.getDefaultTracksFromSpotify();

  }

  @RequestMapping(value = "v1/tracks", params = "tracksNumber")
  public List<String> getTracks(@RequestParam int tracksNumber) {

    return tracksParser.getTracksFromSpotify(tracksNumber);
  }

  @RequestMapping(value = "v1/tracks", params = "timeRange")
  public List<String> getTracks(@RequestParam String timeRange) {

    return tracksParser.getTracksFromSpotify(timeRange);
  }

  @RequestMapping(value = "v1/tracks", params = {"tracksNumber", "timeRange"})
  public List<String> getTracks(@RequestParam int tracksNumber,
      @RequestParam String timeRange) {

    return tracksParser.getTracksFromSpotify(tracksNumber, timeRange);
  }
}