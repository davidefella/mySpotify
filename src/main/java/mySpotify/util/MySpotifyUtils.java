package mySpotify.util;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mySpotify.model.Spotify.SpotifyAuthResponse;

@Service
public class MySpotifyUtils {

	private final String spotifyServices = "./src/main/resources/endpoints/spotifyServices.json";
	SpotifyAuthResponse spotifyAuthResponse;

	@Value("${refresh_token}")
	private String refreshToken;

	@Value("${authorization_code}")
	private String authorizationCode;

//  @Autowired
//  TokenGenerator tokenGenerator;

//  @Autowired
//  MySpotifyUtils mySpotifyUtils;

	public String buildResponseEntity(UriComponentsBuilder builder) {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				this.getBearerHttpEntity(), String.class);

		return responseEntity.getBody();
	}

	public HttpEntity<LinkedMultiValueMap<String, String>> getBearerHttpEntity() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		header.set("Authorization", "Bearer " + getBearerToken());

		HttpEntity<LinkedMultiValueMap<String, String>> request = new HttpEntity<>(header);

		return request;
	}

	public String mapTermRequest(String requestTerm) {
		if (requestTerm.equals(Consts.SHORT_INPUT)) {
			return Consts.SPOTIFY_SHORT_TERM;
		} else if (requestTerm.equals(Consts.MEDIUM_INPUT)) {
			return Consts.SPOTIFY_MEDIUM_TERM;
		} else {
			return Consts.SPOTIFY_LONG_TERM;
		}
	}

	public String readRefreshToken() {

		return refreshToken;
	}

	public String readTracksEndpoints() {
		JSONObject jsonObject = parseJsonFile(spotifyServices);

		return jsonObject.get(Consts.TRACKS_ENDPOINTS).toString();
	}

	public String readArtistsEndpoints() {
		JSONObject jsonObject = parseJsonFile(spotifyServices);

		return jsonObject.get(Consts.ARTISTS_ENDPOINTS).toString();
	}

	public String readAuthorizationEndpoints() {
		JSONObject jsonObject = parseJsonFile(spotifyServices);

		return jsonObject.get(Consts.TOKEN_ENDPOINTS).toString();
	}

	public String readAlbumEndpoints() {
		JSONObject jsonObject = parseJsonFile(spotifyServices);

		return jsonObject.get(Consts.ALBUM_ENDPOINTS).toString();
	}

	private JSONObject parseJsonFile(String path) {
		JSONParser parser = new JSONParser();
		Object objParsed = null;

		try {
			objParsed = parser.parse(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return (JSONObject) objParsed;
	}

	/* TOKEN GENERATOR METHODS */

	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public String getBearerToken() {

		String refreshToken = readRefreshToken();

		spotifyAuthResponse = this.getNewBearerTokenFromRefreshToken(refreshToken);

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
		ResponseEntity<String> result = restTemplate.postForEntity(readAuthorizationEndpoints(), request, String.class);

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