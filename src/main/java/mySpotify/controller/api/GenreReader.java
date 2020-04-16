package mySpotify.controller.api;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;

public interface GenreReader {

  Map<String, String> getGenres();

  Map<String, String> getGenre(@RequestParam String timeRange);

  Map<String, String> getGenre(@RequestParam int artistsNumber);

  Map<String, String> getGenre(@RequestParam int artistsNumber,
      @RequestParam String timeRange);
}
