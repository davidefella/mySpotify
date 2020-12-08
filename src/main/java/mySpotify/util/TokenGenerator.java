package mySpotify.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import mySpotify.model.Spotify.SpotifyAuthResponse;

@Service
public final class TokenGenerator {

  SpotifyAuthResponse spotifyAuthResponse;

  @Autowired
  MySpotifyUtils mySpotifyUtils;

  @Value("${authorization_code}")
  private String authorizationCode;

  @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
  public String getBearerToken() {

    String refreshToken = mySpotifyUtils.readRefreshToken();

    spotifyAuthResponse = this
        .getNewBearerTokenFromRefreshToken(refreshToken);

    return spotifyAuthResponse.getAccess_token();
  }

  private SpotifyAuthResponse getNewBearerTokenFromRefreshToken(String refresh_token) {
    SpotifyAuthResponse spotifyAuthResponse = new SpotifyAuthResponse();

    final String GRANT_TYPE = "refresh_token";

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Basic " + readAuthenticationCode());

    LinkedMultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
    paramsMap.add("grant_type", GRANT_TYPE);
    paramsMap.add("refresh_token", refresh_token);

    HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(paramsMap, headers);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> result = restTemplate
        .postForEntity(mySpotifyUtils.readAuthorizationEndpoints(), request, String.class);

    ObjectMapper mapper = new ObjectMapper();

    try {
      spotifyAuthResponse = mapper.readValue(result.getBody(), SpotifyAuthResponse.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return spotifyAuthResponse;
  }

  public String readAuthenticationCode() {

    return authorizationCode;
  }
}