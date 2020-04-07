package mySpotify.spotify.service.impl;

import mySpotify.spotify.service.api.TracksSpotifyReader;
import mySpotify.util.MySpotifyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

/*
 * https://developer.spotify.com/documentation/web-api/reference/personalization/get-users-top-artists-and-tracks/
 * */
@Service
public class TracksSpotifyReaderImpl implements TracksSpotifyReader {

  @Autowired
  MySpotifyUtils mySpotifyUtils;

  public String readDefaultTracksStatistics() {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readTracksEndpoints());

    return mySpotifyUtils.buildResponseEntity(builder);
  }

  @Override
  public String readTracksStatistics(int tracksNumber) {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readTracksEndpoints()).queryParam("limit", tracksNumber);

    return mySpotifyUtils.buildResponseEntity(builder);
  }

  @Override
  public String readTracksStatistics(String timeRange) {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readTracksEndpoints())
        .queryParam("time_range", mySpotifyUtils.mapTermRequest(timeRange));

    return mySpotifyUtils.buildResponseEntity(builder);
  }

  @Override
  public String readTracksStatistics(int tracksNumber, String timeRange) {

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readTracksEndpoints()).queryParam("limit", tracksNumber)
        .queryParam("time_range", mySpotifyUtils.mapTermRequest(timeRange));

    return mySpotifyUtils.buildResponseEntity(builder);
  }
}