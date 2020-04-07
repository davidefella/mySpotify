package mySpotify.spotify.service.api;

import org.springframework.web.bind.annotation.PathVariable;

public interface ArtistsSpotifyReader {

  String readDefaultArtistsStatistics();

  String readArtistsStatistics(int artistsNumber);

  String readArtistsStatistics(int artistsNumber, String timeRange);

  String readArtistsStatistics(String timeRange);

}