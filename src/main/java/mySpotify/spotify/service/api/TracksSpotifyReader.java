package mySpotify.spotify.service.api;

public interface TracksSpotifyReader {

  String readDefaultTracksStatistics();

  String readTracksStatistics(int tracksNumber);

  String readTracksStatistics(int tracksNumber, String timeRange);

  String readTracksStatistics(String timeRange);

}