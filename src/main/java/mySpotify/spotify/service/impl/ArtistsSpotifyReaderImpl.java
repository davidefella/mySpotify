package mySpotify.spotify.service.impl;

import mySpotify.spotify.service.api.ArtistsSpotifyReader;
import mySpotify.util.MySpotifyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

/*
 * https://developer.spotify.com/documentation/web-api/reference/personalization/get-users-top-artists-and-tracks/
 * */

/*
 * @TODO: Refactor and split this class, from artists and from tracks
 * */
@Service
public class ArtistsSpotifyReaderImpl implements ArtistsSpotifyReader {

  @Autowired
  MySpotifyUtils mySpotifyUtils;

  public String readDefaultArtistsStatistics() {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readArtistsEndpoints());

    return mySpotifyUtils.buildResponseEntity(builder);
  }

  public String readArtistsStatistics(int artistsNumber) {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readArtistsEndpoints()).queryParam("limit", artistsNumber);

    return mySpotifyUtils.buildResponseEntity(builder);
  }

  public String readArtistsStatistics(int artistsNumber, String timeRange) {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readArtistsEndpoints()).queryParam("limit", artistsNumber)
        .queryParam("time_range", mySpotifyUtils.mapTermRequest(timeRange));

    return mySpotifyUtils.buildResponseEntity(builder);
  }

  public String readArtistsStatistics(String timeRange) {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readArtistsEndpoints())
        .queryParam("time_range", mySpotifyUtils.mapTermRequest(timeRange));

    return mySpotifyUtils.buildResponseEntity(builder);
  }
}