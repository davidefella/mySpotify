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

@Service
public class SpotifyReaderImpl implements SpotifyReader {

  @Autowired
  TokenGenerator tokenGenerator;

  /*
   * https://developer.spotify.com/documentation/web-api/reference/personalization/get-users-top-artists-and-tracks/
   * */
  public String readArtistsStatistics() {

    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_ARTISTS_URI).queryParam("limit", "5")
        .queryParam("time_range", "short_term");

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, getBearerHttpEntity(), String.class);

    return responseEntity.getBody();
  }

  public String readTracksStatistics() {
    RestTemplate restTemplate = new RestTemplate();

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_TRACKS_URI).queryParam("limit", "10")
        .queryParam("time_range", "long_term");

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
}