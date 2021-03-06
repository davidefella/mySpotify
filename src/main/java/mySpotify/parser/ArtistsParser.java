package mySpotify.parser;

import java.util.List;
import mySpotify.mapper.ArtistsMapper;
import mySpotify.model.Artists.Items;
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

    String artists = artistsSpotifyReader.getDefaultArtistsFromSpotify();

    return artistsMapper.mapArtistToStringFromResponse(artists);
  }

  public List<String> getArtistsFromSpotify(int artistsNumber) {

    String artists = artistsSpotifyReader.getArtistsFromSpotify(artistsNumber);

    return artistsMapper.mapArtistToStringFromResponse(artists);
  }

  public List<String> getArtistsFromSpotify(String timeRange) {

    String artists = artistsSpotifyReader.getArtistsFromSpotify(timeRange);

    return artistsMapper.mapArtistToStringFromResponse(artists);
  }

  public List<String> getArtistsFromSpotify(int artistsNumber, String term) {

    String artists = artistsSpotifyReader.getArtistsFromSpotify(artistsNumber, term);

    return artistsMapper.mapArtistToStringFromResponse(artists);
  }

  public List<Items> getItemsDefaultArtistsFromSpotify() {

    String artists = artistsSpotifyReader.getDefaultArtistsFromSpotify();

    return artistsMapper.mapArtistFromResponse(artists);
  }

  public List<Items> getItemsArtistsFromSpotify(int artistsNumber) {

    String artists = artistsSpotifyReader.getArtistsFromSpotify(artistsNumber);

    return artistsMapper.mapArtistFromResponse(artists);
  }

  public List<Items> getItemsArtistsFromSpotify(String timeRange) {

    String artists = artistsSpotifyReader.getArtistsFromSpotify(timeRange);

    return artistsMapper.mapArtistFromResponse(artists);
  }

  public List<Items> getItemsArtistsFromSpotify(int artistsNumber, String term) {

    String artists = artistsSpotifyReader.getArtistsFromSpotify(artistsNumber, term);

    return artistsMapper.mapArtistFromResponse(artists);
  }
}