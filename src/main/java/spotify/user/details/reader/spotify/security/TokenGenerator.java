package spotify.user.details.reader.spotify.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import spotify.user.details.reader.spotify.configuration.APIAddressHandler;
import spotify.user.details.reader.spotify.model.SpotifyAuthResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public final class TokenGenerator {
  private final String filePath = "./src/main/resources/token/tokens.json";
  SpotifyAuthResponse spotifyAuthResponse;

  @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
  public String getBearerToken() {
    JSONParser parser = new JSONParser();
    Object objParsed;

    try {
      objParsed = parser.parse(new FileReader(filePath));
      JSONObject jsonObject = (JSONObject) objParsed;
      spotifyAuthResponse = this.getNewBearerTokenFromRefreshToken(jsonObject.get("refresh_token").toString());

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return spotifyAuthResponse.getAccess_token();
  }

  private SpotifyAuthResponse getNewBearerTokenFromRefreshToken(String refresh_token){
    final String GRANT_TYPE = "refresh_token";
    String authorizationCode= "NjA1ZTgxNzIzMDRmNDM0MWFlNGEzMWI4MmFjMzdkYjI6NmMxYjBmOTA5YzNmNGQwNzk3Y2YyNjU0NTdhZmVhMmU=";
    SpotifyAuthResponse spotifyAuthResponse = new SpotifyAuthResponse();

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Basic " + authorizationCode );

    LinkedMultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
    paramsMap.add("grant_type", GRANT_TYPE);
    paramsMap.add("refresh_token",refresh_token);

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

  /* To take the auth code from the first step*/
  private SpotifyAuthResponse getAuthResponse(){
    SpotifyAuthResponse spotifyAuthResponse = null;

    final String GRANT_TYPE = "authorization_code";
    final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    /* TODO: From the first service*/
    String code = "AQAOnO9szRjB7pQJiIAhROnZ_C0ZBxgMOtrkYZnm8fFuqJk_UyKNeH33gX1FHPiqur9PuZOD68ZNL7umodlVWDPf_GAHehGY-7CWtfCNxE48yd3ZqXA4RMjxQFqfR8SR1gkSEmuFNDh-UvMuZjq7eqjJ2Bumvw9_V8yItDHsuXNKW3lvBm7jl0eI4xBUD7QI4yr0TZnJe72sxdpl3_Jyvw";

    /* TODO: Calculate from base64 transformation*/
    String authorizationCode= "NjA1ZTgxNzIzMDRmNDM0MWFlNGEzMWI4MmFjMzdkYjI6NmMxYjBmOTA5YzNmNGQwNzk3Y2YyNjU0NTdhZmVhMmU=";

    HttpHeaders headers = new HttpHeaders();
    headers.set("content-type", CONTENT_TYPE);
    headers.set("Authorization", "Basic " + authorizationCode);

    LinkedMultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
    paramsMap.add("grant_type", GRANT_TYPE);
    paramsMap.add("code", code);
    paramsMap.add("redirect_uri", APIAddressHandler.REDIRECT_URI);

    HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(paramsMap, headers);

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