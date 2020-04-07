package mySpotify.spotify.service.api;

import org.springframework.web.bind.annotation.PathVariable;

public interface SpotifyReader {

  String readDefaultArtistsStatistics();

  String readArtistsStatistics(int artistsNumber);

  String readArtistsStatistics(int artistsNumber, String timeRange);

  String readArtistsStatistics(String timeRange);

  String readDefaultTracksStatistics();

  String readTracksStatistics(int tracksNumber);

  String readTracksStatistics(int tracksNumber, String timeRange);

  String readTracksStatistics(String timeRange);

}