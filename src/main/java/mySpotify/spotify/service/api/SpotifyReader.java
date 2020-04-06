package mySpotify.spotify.service.api;

import org.springframework.web.bind.annotation.PathVariable;

public interface SpotifyReader {

  String readDefaultArtistsStatistics();

  String readArtistsStatistics(int artistsNumber);

  String readArtistsStatistics(int artistsNumber, String term);

  String readArtistsStatistics(String timeRange);

  String readTracksStatistics();

}