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

  public List<String> getDefaultTracksFromSpotify() {

    String tracksResponse = spotifyReader.readDefaultTracksStatistics();

    return tracksMapper.mapTracksFromResponse(tracksResponse);
  }

  public List<String> getTracksFromSpotify(int artistsNumber) {

    String tracksResponse = spotifyReader.readTracksStatistics(artistsNumber);

    return tracksMapper.mapTracksFromResponse(tracksResponse);
  }

  public List<String> getTracksFromSpotify(String timeRange) {

    String tracksResponse = spotifyReader.readTracksStatistics(timeRange);

    return tracksMapper.mapTracksFromResponse(tracksResponse);
  }

  public List<String> getTracksFromSpotify(int tracksNumber, String timeRange) {

    String tracksResponse = spotifyReader.readTracksStatistics(tracksNumber, timeRange);

    return tracksMapper.mapTracksFromResponse(tracksResponse);
  }

}
