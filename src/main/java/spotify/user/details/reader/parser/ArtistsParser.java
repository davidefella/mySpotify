package spotify.user.details.reader.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spotify.user.details.reader.spotify.service.api.SpotifyReader;

@Service
public class ArtistsParser {

  @Autowired
  SpotifyReader spotifyReader;

  public String getArtistsFromSpotify(){
    return spotifyReader.readArtistsStatistics();
  }
}
