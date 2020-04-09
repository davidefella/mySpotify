package mySpotify.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import mySpotify.model.Artists.Items;
import mySpotify.model.Artists.Root;
import org.springframework.stereotype.Service;

@Service
public class ArtistsMapper {

  public List<String> mapArtistToStringFromResponse(String artists) {
    Root root;
    ObjectMapper mapper = new ObjectMapper();
    List<String> artistsList = new ArrayList<>();

    try {

      root = mapper.readValue(artists, Root.class);
      List<Items> items = root.getItems();

      for (int i = 0; i < items.size(); i++) {
        artistsList.add(items.get(i).getName());
      }

    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return artistsList;
  }

  public List<Items> mapArtistFromResponse(String artists) {
    Root root;
    ObjectMapper mapper = new ObjectMapper();
    List<Items> artistsItems = new ArrayList<>();

    try {

      root = mapper.readValue(artists, Root.class);
      artistsItems = root.getItems();

    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return artistsItems;
  }

}