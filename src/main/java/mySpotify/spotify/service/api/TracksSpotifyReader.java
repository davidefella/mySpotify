package mySpotify.spotify.service.api;

public interface TracksSpotifyReader {

  String getDefaultTracksFromSpotify();

  String getTracksFromSpotify(int tracksNumber);

  String getTracksFromSpotify(int tracksNumber, String timeRange);

  String getTracksFromSpotify(String timeRange);

}