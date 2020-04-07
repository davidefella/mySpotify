package mySpotify.parser;

import java.util.List;
import mySpotify.mapper.ArtistsMapper;
import mySpotify.spotify.service.api.ArtistsSpotifyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistsParser {

  @Autowired
  ArtistsSpotifyReader artistsSpotifyReader;

  @Autowired
  ArtistsMapper artistsMapper;

  public List<String> getDefaultArtistsFromSpotify() {

    String artists = artistsSpotifyReader.readDefaultArtistsStatistics();

    return artistsMapper.mapArtistFromResponse(artists);
  }

  public List<String> getArtistsFromSpotify(int artistsNumber) {

    String artists = artistsSpotifyReader.readArtistsStatistics(artistsNumber);

    return artistsMapper.mapArtistFromResponse(artists);
  }

  public List<String> getArtistsFromSpotify(String timeRange) {

    String artists = artistsSpotifyReader.readArtistsStatistics(timeRange);

    return artistsMapper.mapArtistFromResponse(artists);
  }

  public List<String> getArtistsFromSpotify(int artistsNumber, String term) {

    String artists = artistsSpotifyReader.readArtistsStatistics(artistsNumber, term);

    return artistsMapper.mapArtistFromResponse(artists);
  }
}
