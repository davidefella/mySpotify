package mySpotify.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import mySpotify.model.ArtistsResponse.Items;
import mySpotify.model.ArtistsResponse.Root;
import mySpotify.spotify.service.api.SpotifyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistsParser {

  @Autowired
  SpotifyReader spotifyReader;

  public List<String> getArtistsFromSpotify() {
    Root root;
    ObjectMapper mapper = new ObjectMapper();
    List<String> artistsList = new ArrayList<>();

    try {

      root = mapper.readValue(spotifyReader.readArtistsStatistics(), Root.class);
      List<Items> items = root.getItems();

      for (int i = 0; i < items.size(); i++) {
        artistsList.add(items.get(i).getName());
      }

    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return artistsList;
  }
}
