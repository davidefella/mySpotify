package mySpotify.controller.api;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;

public interface GenreReader {

  Map<String, Integer> getGenres();

  Map<String, Integer> getGenre(@RequestParam String timeRange);

  Map<String, Integer> getGenre(@RequestParam int artistsNumber);

  Map<String, Integer> getGenre(@RequestParam int artistsNumber,
      @RequestParam String timeRange);
}
