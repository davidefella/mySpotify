package spotify.user.details.reader.spotify.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spotify.user.details.reader.spotify.configuration.APIAddressHandler;
import spotify.user.details.reader.spotify.security.TokenHandler;
import spotify.user.details.reader.spotify.service.api.SpotifyReader;

@Service
public class SpotifyReaderImpl implements SpotifyReader {

  public String readArtistsStatistics()  {

    TokenHandler th = new TokenHandler();

    final String accessToken = th.getBearerToken();
    final String astrstisEndPoint = APIAddressHandler.GET_ARTISTS_URI;

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.set("Authorization", "Bearer " + accessToken);

    HttpEntity<String> entity = new HttpEntity<String>(headers);

    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl
        = astrstisEndPoint;

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(fooResourceUrl, HttpMethod.GET, entity, String.class);

    return responseEntity.toString();
  }
}
