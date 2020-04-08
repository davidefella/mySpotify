package mySpotify.spotify.service.api;

import org.springframework.web.bind.annotation.PathVariable;

public interface ArtistsSpotifyReader {

  String getDefaultArtistsFromSpotify();

  String getArtistsFromSpotify(int artistsNumber);

  String getArtistsFromSpotify(int artistsNumber, String timeRange);

  String getArtistsFromSpotify(String timeRange);

}