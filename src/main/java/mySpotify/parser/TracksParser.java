package mySpotify.parser;

import java.util.List;
import mySpotify.mapper.TracksMapper;
import mySpotify.spotify.service.api.TracksSpotifyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TracksParser {

  @Autowired
  TracksSpotifyReader tracksSpotifyReader;

  @Autowired
  TracksMapper tracksMapper;

  public List<String> getDefaultTracksFromSpotify() {

    String tracksResponse = tracksSpotifyReader.readDefaultTracksStatistics();

    return tracksMapper.mapTracksFromResponse(tracksResponse);
  }

  public List<String> getTracksFromSpotify(int artistsNumber) {

    String tracksResponse = tracksSpotifyReader.readTracksStatistics(artistsNumber);

    return tracksMapper.mapTracksFromResponse(tracksResponse);
  }

  public List<String> getTracksFromSpotify(String timeRange) {

    String tracksResponse = tracksSpotifyReader.readTracksStatistics(timeRange);

    return tracksMapper.mapTracksFromResponse(tracksResponse);
  }

  public List<String> getTracksFromSpotify(int tracksNumber, String timeRange) {

    String tracksResponse = tracksSpotifyReader.readTracksStatistics(tracksNumber, timeRange);

    return tracksMapper.mapTracksFromResponse(tracksResponse);
  }

}
