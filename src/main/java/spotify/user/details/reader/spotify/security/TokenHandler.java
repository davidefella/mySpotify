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

    /* TODO: From the first service*/
    String code = "AQDqRDL6_2QL2VKiEffg-IbqDPJLcHet0zYeiY0YAtpH1CUhY_WiOzwbrM3kNS7sF6lLb7sphmkVcwEQ4UA0V1ei5PDpXEl4_qjCFHTOi0U7kYvbMF1HR-62QIoXzzaorKE42g4quJD2mP0cvEIwT6pK4LQd7a_-cN6VsYw5j0ccOm5aZ6w9bf0HQemHyT7Xtwv8zMBXiDqI5d9ZMDJ-FA";

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

    SpotifyAuthResponse responseObject = null;
    ObjectMapper mapper = new ObjectMapper();

    try {
      responseObject = mapper.readValue(result.getBody(), SpotifyAuthResponse.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return responseObject.getAccess_token();
  }


  /*
  *
    HttpHeaders headers2 = new HttpHeaders();
    //headers2.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers2.set("client_id", "605e8172304f4341ae4a31b82ac37db2");
    headers2.set("scope", "user-top-read");
    headers2.set("redirect_uri", "https://api-university.com/" );

    HttpEntity<String> entity2 = new HttpEntity<String>(headers2);

    String fooResourceUrl = "https://accounts.spotify.com/authorize";

    RestTemplate restTemplate2 = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate2
        .exchange(fooResourceUrl, HttpMethod.GET, entity2, String.class);

    String body = responseEntity.getBody();


    Document parse = Jsoup.parse(body);

    System.out.print(parse);

    parse.getElementById("sp-bootstrap-data");

  List<String> tokens = new ArrayList<>();
  StringTokenizer tokenizer = new StringTokenizer(body, "=");
    while (tokenizer.hasMoreElements()) {
    tokens.add(tokenizer.nextToken());
  }


  String temp = null;

    for(String s : tokens){
    if(s.contains("tpaState")){
      temp = s;
    }
  }

    System.out.print(temp);
  tokens = new ArrayList<>();
  tokenizer = new StringTokenizer(body, ",");
    while (tokenizer.hasMoreElements()) {
    tokens.add(tokenizer.nextToken());
  }


    System.out.println();


  String s3 = "";
    for(String s2 : tokens){

    if(s2.contains("tpaState"))
      s3 = s2;

  }

    System.out.print(s3);

  tokenizer = new StringTokenizer(s3, ":");
  tokens = new ArrayList<>();
    while (tokenizer.hasMoreElements()) {
    tokens.add(tokenizer.nextToken());
  }


    System.out.print(tokens);

  String t = tokens.get(1);

    System.out.println("Token: " + tokens.get(1).replace("\"", ""));

  code = tokens.get(1).replace("\"", "");

  * */
}
