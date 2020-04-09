package mySpotify.spotify.service.api;

public interface ArtistsSpotifyReader {

  String getDefaultArtistsFromSpotify();

  String getArtistsFromSpotify(int artistsNumber);

  String getArtistsFromSpotify(int artistsNumber, String timeRange);

  String getArtistsFromSpotify(String timeRange);

}