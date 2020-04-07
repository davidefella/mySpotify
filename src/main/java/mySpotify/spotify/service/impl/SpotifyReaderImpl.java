package mySpotify.spotify.service.impl;

import mySpotify.spotify.service.api.SpotifyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import mySpotify.spotify.configuration.APIAddressHandler;
import mySpotify.spotify.security.TokenGenerator;
import org.springframework.web.util.UriComponentsBuilder;

/*
 * https://developer.spotify.com/documentation/web-api/reference/personalization/get-users-top-artists-and-tracks/
 * */

/*
 * @TODO: Refactor and split this class, from artists and from tracks
 * */
@Service
public class SpotifyReaderImpl implements SpotifyReader {

  @Autowired
  TokenGenerator tokenGenerator;


  public String readDefaultArtistsStatistics() {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_ARTISTS_URI);

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  public String readArtistsStatistics(int artistsNumber) {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_ARTISTS_URI).queryParam("limit", artistsNumber);

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  public String readArtistsStatistics(int artistsNumber, String timeRange) {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_ARTISTS_URI).queryParam("limit", artistsNumber)
        .queryParam("time_range", mapTermRequest(timeRange));

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  public String readArtistsStatistics(String timeRange) {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_ARTISTS_URI)
        .queryParam("time_range", mapTermRequest(timeRange));

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  /*  TRACKS    */
  public String readDefaultTracksStatistics() {
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_TRACKS_URI).queryParam("limit", "10")
        .queryParam("time_range", "long_term");

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }


  @Override
  public String readTracksStatistics(int tracksNumber) {
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_TRACKS_URI).queryParam("limit", tracksNumber);

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  @Override
  public String readTracksStatistics(int tracksNumber, String timeRange) {
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_TRACKS_URI).queryParam("limit", tracksNumber)
        .queryParam("time_range", mapTermRequest(timeRange));

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  @Override
  public String readTracksStatistics(String timeRange) {
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_TRACKS_URI)
        .queryParam("time_range", mapTermRequest(timeRange));

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  private HttpEntity<LinkedMultiValueMap<String, String>> getBearerHttpEntity() {
    HttpHeaders header = new HttpHeaders();
    header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    header.set("Authorization", "Bearer " + tokenGenerator.getBearerToken());

    HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(header);

    return request;
  }

  private String mapTermRequest(String requestTerm) {
    if (requestTerm.equals("short")) {
      return "short_term";
    } else if (requestTerm.equals("medium")) {
      return "medium_term";
    } else {
      return "long_term";
    }
  }
}