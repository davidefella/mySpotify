package mySpotify.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import mySpotify.model.Tracks.Items;
import mySpotify.model.Tracks.Root;
import org.springframework.stereotype.Service;

@Service
public class TracksMapper {

  public List<String> mapTracksToStringFromResponse(String tracks) {
    Root root;
    ObjectMapper mapper = new ObjectMapper();
    List<String> tracksList = new ArrayList<>();

    try {

      root = mapper.readValue(tracks, Root.class);
      List<Items> items = root.getItems();

      for (int i = 0; i < items.size(); i++) {
        tracksList.add(items.get(i).getName());
      }

    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return tracksList;
  }
}