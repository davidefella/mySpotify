package mySpotify.controller.api;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

public interface TracksReader {

  List<String> getTracksStatistics();

  List<String> getTracksStatistics(@RequestParam int artistsNumber);

  List<String> getTracksStatistics(@RequestParam String timeRange);

  List<String> getTracksStatistics(@RequestParam int artistsNumber, @RequestParam String timeRange);

}