package spotify.user.details.reader.spotify.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import spotify.user.details.reader.spotify.configuration.APIAddressHandler;
import spotify.user.details.reader.spotify.model.SpotifyAuthResponse;

public final class TokenHandler {

  @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
  public String getBearerToken() {
    final String GRANT_TYPE = "authorization_code";
    final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    LinkedMultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
    ObjectMapper mapper = new ObjectMapper();

    /* TODO: From the first service*/
    String code = "";

    /* TODO: Calculate from base64 transformation*/
    String authorizationCode= "";

    headers.set("content-type", CONTENT_TYPE);
    headers.set("Authorization", "Basic " + authorizationCode);

    paramsMap.add("grant_type", GRANT_TYPE);
    paramsMap.add("code", code);
    paramsMap.add("redirect_uri", APIAddressHandler.REDIRECT_URI);

    HttpEntity<LinkedMultiValueMap<String, String>> request = new   HttpEntity<>(paramsMap, headers);
    ResponseEntity<String> result = restTemplate.postForEntity(APIAddressHandler.AUTHORIZE_URI, request, String.class);

    SpotifyAuthResponse responseObject = null;

    try {
      responseObject = mapper.readValue(result.getBody(), SpotifyAuthResponse.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return responseObject.getAccess_token();
  }
}
