package mySpotify.parser;

import java.util.List;
import mySpotify.mapper.TracksMapper;
import mySpotify.spotify.service.api.SpotifyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TracksParser {

  @Autowired
  SpotifyReader spotifyReader;

  @Autowired
  TracksMapper tracksMapper;

  public List<String> getTracksFromSpotify() {

    String tracks = spotifyReader.readTracksStatistics();

    return tracksMapper.mapTracksFromResponse(tracks);
  }
}
