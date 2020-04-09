package mySpotify.controller.api;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

public interface TracksReader {

  List<String> getDefaultTracks();

  List<String> getTracks(@RequestParam int artistsNumber);

  List<String> getTracks(@RequestParam String timeRange);

  List<String> getTracks(@RequestParam int artistsNumber, @RequestParam String timeRange);

}