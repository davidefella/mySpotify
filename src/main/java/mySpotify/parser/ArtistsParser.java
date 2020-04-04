package mySpotify.parser;

import mySpotify.spotify.service.api.SpotifyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistsParser {

  @Autowired
  SpotifyReader spotifyReader;

  public String getArtistsFromSpotify(){
    return spotifyReader.readArtistsStatistics();
  }
}
