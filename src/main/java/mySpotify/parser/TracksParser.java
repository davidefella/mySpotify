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

    String tracksResponse = tracksSpotifyReader.getDefaultTracksFromSpotify();

    return tracksMapper.mapTracksToStringFromResponse(tracksResponse);
  }

  public List<String> getTracksFromSpotify(int artistsNumber) {

    String tracksResponse = tracksSpotifyReader.getTracksFromSpotify(artistsNumber);

    return tracksMapper.mapTracksToStringFromResponse(tracksResponse);
  }

  public List<String> getTracksFromSpotify(String timeRange) {

    String tracksResponse = tracksSpotifyReader.getTracksFromSpotify(timeRange);

    return tracksMapper.mapTracksToStringFromResponse(tracksResponse);
  }

  public List<String> getTracksFromSpotify(int tracksNumber, String timeRange) {

    String tracksResponse = tracksSpotifyReader.getTracksFromSpotify(tracksNumber, timeRange);

    return tracksMapper.mapTracksToStringFromResponse(tracksResponse);
  }
}