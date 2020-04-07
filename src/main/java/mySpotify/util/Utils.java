package mySpotify.util;

import mySpotify.spotify.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

@Service
public class Utils {

  @Autowired
  TokenGenerator tokenGenerator;

  public HttpEntity<LinkedMultiValueMap<String, String>> getBearerHttpEntity() {
    HttpHeaders header = new HttpHeaders();
    header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    header.set("Authorization", "Bearer " + tokenGenerator.getBearerToken());

    HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(header);

    return request;
  }

  public String mapTermRequest(String requestTerm) {
    if (requestTerm.equals("short")) {
      return "short_term";
    } else if (requestTerm.equals("medium")) {
      return "medium_term";
    } else {
      return "long_term";
    }
  }
}
