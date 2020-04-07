package mySpotify.spotify.service.impl;

import mySpotify.spotify.service.api.ArtistsSpotifyReader;
import mySpotify.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import mySpotify.spotify.configuration.APIAddressHandler;
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
  Utils utils;


  public String readDefaultArtistsStatistics() {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_ARTISTS_URI);

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, utils.getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  public String readArtistsStatistics(int artistsNumber) {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_ARTISTS_URI).queryParam("limit", artistsNumber);

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, utils.getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  public String readArtistsStatistics(int artistsNumber, String timeRange) {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_ARTISTS_URI).queryParam("limit", artistsNumber)
        .queryParam("time_range", utils.mapTermRequest(timeRange));

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, utils.getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  public String readArtistsStatistics(String timeRange) {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_ARTISTS_URI)
        .queryParam("time_range", utils.mapTermRequest(timeRange));

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, utils.getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  /*  TRACKS    */
  public String readDefaultTracksStatistics() {
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_TRACKS_URI).queryParam("limit", "10")
        .queryParam("time_range", "long_term");

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, utils.getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

}