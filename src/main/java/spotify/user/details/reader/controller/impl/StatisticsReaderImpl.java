package spotify.user.details.reader.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spotify.user.details.reader.controller.api.StatisticsReader;
import spotify.user.details.reader.model.SpotifyArtistsReponse;
import spotify.user.details.reader.parser.ArtistsParser;

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
