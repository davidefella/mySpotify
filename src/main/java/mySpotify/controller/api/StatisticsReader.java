package mySpotify.controller.api;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

public interface StatisticsReader {

  List<String> getArtistsStatistics();

  List<String> getArtistsStatistics(@RequestParam String timeRange);

  List<String> getArtistsStatistics(@RequestParam int artistsNumber);

  List<String> getArtistsStatistics(@RequestParam int artistsNumber,
      @RequestParam String timeRange);

  List<String> getTracksStatistics();

}