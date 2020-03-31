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

public final class TokenGenerator {
  SpotifyAuthResponse spotifyAuthResponse;

  @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
  public String getBearerToken() {

    if(spotifyAuthResponse == null){
      spotifyAuthResponse = this.getAuthResponse();
    } else {
      //this.getNewTokenFromRefresh
    }

    return spotifyAuthResponse.getAccess_token();
  }

  private SpotifyAuthResponse getAuthResponse(){
    SpotifyAuthResponse spotifyAuthResponse = null;

    final String GRANT_TYPE = "authorization_code";
    final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    /* TODO: From the first service*/
    String code = "AQCgjGYeYbxvyHGAoV_uw8_1Rj2zSkAIfhA3e2IP6xE7XIjRQ-o5-9fX_73Rd3QTkVvN7WMiIb3jz9ezn2BLbEYrAGcLsqq04Gs-zJjbPTp7VRmFp22sC-uwt0YGx-FwFAwJhd6OGhFDXoSKZwHZlMCncRe37F8eVYtSctSYepKL2yoCBbR96cKHX1Js0HkYE-yxSA0-dnvxoIf_sabUHQ";

    /* TODO: Calculate from base64 transformation*/
    String authorizationCode= "NjA1ZTgxNzIzMDRmNDM0MWFlNGEzMWI4MmFjMzdkYjI6NmMxYjBmOTA5YzNmNGQwNzk3Y2YyNjU0NTdhZmVhMmU=";

    HttpHeaders headers = new HttpHeaders();
    headers.set("content-type", CONTENT_TYPE);
    headers.set("Authorization", "Basic " + authorizationCode);

    LinkedMultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
    paramsMap.add("grant_type", GRANT_TYPE);
    paramsMap.add("code", code);
    paramsMap.add("redirect_uri", APIAddressHandler.REDIRECT_URI);

    HttpEntity<LinkedMultiValueMap<String, String>> request = new   HttpEntity<>(paramsMap, headers);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> result = restTemplate.postForEntity(APIAddressHandler.AUTHORIZE_URI, request, String.class);

    ObjectMapper mapper = new ObjectMapper();

    try {
      spotifyAuthResponse = mapper.readValue(result.getBody(), SpotifyAuthResponse.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return spotifyAuthResponse;
  }
}
