package mySpotify.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mySpotify.controller.api.StatisticsReader;
import mySpotify.model.SpotifyArtistsReponse;
import mySpotify.parser.ArtistsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsReaderImpl implements StatisticsReader {

  @Autowired
  ArtistsParser artistsParser;

  @GetMapping("/getArtistsStats")
  public String getArtistsStatistics() {
    String res = artistsParser.getArtistsFromSpotify();

    ObjectMapper mapper = new ObjectMapper();
    SpotifyArtistsReponse spotifyArtistsReponse = null;
    try {
      spotifyArtistsReponse = mapper.readValue(res, SpotifyArtistsReponse.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return res;
  }
}
