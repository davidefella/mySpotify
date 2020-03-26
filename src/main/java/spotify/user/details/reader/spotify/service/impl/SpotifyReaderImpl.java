package spotify.user.details.reader.spotify.service.impl;

import org.springframework.stereotype.Service;
import spotify.user.details.reader.spotify.service.api.SpotifyReader;

@Service
public class SpotifyReaderImpl implements SpotifyReader {

  public String readArtistsStatistics() {
    return "Ok from Spotify";
  }
}
