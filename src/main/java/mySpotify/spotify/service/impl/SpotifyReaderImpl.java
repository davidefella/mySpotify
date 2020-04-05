package mySpotify.spotify.service.impl;

import mySpotify.spotify.service.api.SpotifyReader;
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

  /*
   * https://developer.spotify.com/documentation/web-api/reference/personalization/get-users-top-artists-and-tracks/
   * */
  public String readArtistsStatistics() {
    TokenGenerator th = new TokenGenerator();
    RestTemplate restTemplate = new RestTemplate();

    String accessToken = th.getBearerToken();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.set("Authorization", "Bearer " + accessToken);

    HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(headers);

    UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(APIAddressHandler.GET_ARTISTS_URI).queryParam("limit", "5")
        .queryParam("time_range", "short_term");

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(builder.toUriString(), HttpMethod.GET, request, String.class);

    return responseEntity.getBody();
  }
}