package mySpotify.controller.api;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

public interface ArtistsReader {

  List<String> getDefaultArtists();

  List<String> getArtists(@RequestParam String timeRange);

  List<String> getArtists(@RequestParam int artistsNumber);

  List<String> getArtists(@RequestParam int artistsNumber,
      @RequestParam String timeRange);
}