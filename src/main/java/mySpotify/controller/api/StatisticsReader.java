package mySpotify.controller.api;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

public interface StatisticsReader {

  List<String> getArtistsStatistics();

  List<String> getArtistsStatistics(@PathVariable int artistsNumber);

  List<String> getArtistsStatistics(@PathVariable String timeRange);

  List<String> getArtistsStatistics(@PathVariable int artistsNumber, @PathVariable String timeRange);

  List<String> getTracksStatistics();

}
