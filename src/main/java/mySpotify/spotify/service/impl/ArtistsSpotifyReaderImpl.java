package mySpotify.spotify.service.impl;

import mySpotify.spotify.service.api.ArtistsSpotifyReader;
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
public class ArtistsSpotifyReaderImpl implements ArtistsSpotifyReader {

  @Autowired
  MySpotifyUtils mySpotifyUtils;

  public String readDefaultArtistsStatistics() {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readArtistsEndpoints());

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, mySpotifyUtils.getBearerHttpEntity(),
            String.class);

    return responseEntity.getBody();
  }

  public String readArtistsStatistics(int artistsNumber) {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readArtistsEndpoints()).queryParam("limit", artistsNumber);

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, mySpotifyUtils.getBearerHttpEntity(),
            String.class);

    return responseEntity.getBody();
  }

  public String readArtistsStatistics(int artistsNumber, String timeRange) {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readArtistsEndpoints()).queryParam("limit", artistsNumber)
        .queryParam("time_range", mySpotifyUtils.mapTermRequest(timeRange));

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, mySpotifyUtils.getBearerHttpEntity(),
            String.class);

    return responseEntity.getBody();
  }

  public String readArtistsStatistics(String timeRange) {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(mySpotifyUtils.readArtistsEndpoints())
        .queryParam("time_range", mySpotifyUtils.mapTermRequest(timeRange));

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, mySpotifyUtils.getBearerHttpEntity(),
            String.class);

    return responseEntity.getBody();
  }
}