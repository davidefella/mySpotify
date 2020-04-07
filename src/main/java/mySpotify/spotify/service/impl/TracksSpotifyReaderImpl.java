package mySpotify.spotify.service.impl;

import mySpotify.spotify.service.api.TracksSpotifyReader;
import mySpotify.util.MySpotifyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/*
 * https://developer.spotify.com/documentation/web-api/reference/personalization/get-users-top-artists-and-tracks/
 * */

/*
 * @TODO: Refactor and split this class, from artists and from tracks
 * */
@Service
public class TracksSpotifyReaderImpl implements TracksSpotifyReader {

  @Autowired
  MySpotifyUtils mySpotifyUtils;

  public String readDefaultTracksStatistics() {
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readTracksEndpoints()).queryParam("limit", "10")
        .queryParam("time_range", "long_term");

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, mySpotifyUtils.getBearerHttpEntity(),
            String.class);

    return responseEntity.getBody();
  }

  @Override
  public String readTracksStatistics(int tracksNumber) {
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readTracksEndpoints()).queryParam("limit", tracksNumber);

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, mySpotifyUtils.getBearerHttpEntity(),
            String.class);

    return responseEntity.getBody();
  }

  @Override
  public String readTracksStatistics(int tracksNumber, String timeRange) {
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readTracksEndpoints()).queryParam("limit", tracksNumber)
        .queryParam("time_range", mySpotifyUtils.mapTermRequest(timeRange));

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, mySpotifyUtils.getBearerHttpEntity(),
            String.class);

    return responseEntity.getBody();
  }

  @Override
  public String readTracksStatistics(String timeRange) {
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readTracksEndpoints())
        .queryParam("time_range", mySpotifyUtils.mapTermRequest(timeRange));

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, mySpotifyUtils.getBearerHttpEntity(),
            String.class);

    return responseEntity.getBody();
  }
}