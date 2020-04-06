package mySpotify.parser;

import java.util.List;
import mySpotify.mapper.ArtistsMapper;
import mySpotify.spotify.service.api.SpotifyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistsParser {

  @Autowired
  SpotifyReader spotifyReader;

  @Autowired
  ArtistsMapper artistsMapper;

  public List<String> getDefaultArtistsFromSpotify() {

    String artists = spotifyReader.readDefaultArtistsStatistics();

    return artistsMapper.mapArtistFromResponse(artists);
  }

  public List<String> getArtistsFromSpotify(int artistsNumber) {

    String artists = spotifyReader.readArtistsStatistics(artistsNumber);

    return artistsMapper.mapArtistFromResponse(artists);
  }

  public List<String> getArtistsFromSpotify(String timeRange) {

    String artists = spotifyReader.readArtistsStatistics(timeRange);

    return artistsMapper.mapArtistFromResponse(artists);
  }

  public List<String> getArtistsFromSpotify(int artistsNumber, String term) {

    String artists = spotifyReader.readArtistsStatistics(artistsNumber, term);

    return artistsMapper.mapArtistFromResponse(artists);
  }
}
