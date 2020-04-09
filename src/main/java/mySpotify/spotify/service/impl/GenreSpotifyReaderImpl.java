package mySpotify.spotify.service.impl;

import mySpotify.spotify.service.api.GenreSpotifyReader;
import mySpotify.util.MySpotifyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GenreSpotifyReaderImpl implements GenreSpotifyReader {

  @Autowired
  MySpotifyUtils mySpotifyUtils;

  @Override
  public String getAlbumGenres(String albumID) {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readAlbumEndpoints().concat(albumID));

    return mySpotifyUtils.buildResponseEntity(builder);
  }
}