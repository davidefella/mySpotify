package mySpotify.controller.impl;

import java.util.List;
import mySpotify.controller.api.TracksReader;
import mySpotify.model.logs.ServiceLog;
import mySpotify.parser.TracksParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TracksReaderImpl implements TracksReader {

  @Autowired
  TracksParser tracksParser;

  @Autowired
  MongoTemplate mongoTemplate;

  @RequestMapping(value = "v1/tracks")
  public List<String> getDefaultTracks() {

    String endPoint = "v1/tracks";

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    List<String> tracks = tracksParser.getDefaultTracksFromSpotify();

    mongoTemplate.save(new ServiceLog(tracks.toString(), endPoint, "OUT"));

    return tracks;

  }

  @RequestMapping(value = "v1/tracks", params = "tracksNumber")
  public List<String> getTracks(@RequestParam int tracksNumber) {

    String endPoint = "v1/tracks?tracksNumber" + tracksNumber;

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    List<String> tracks = tracksParser.getTracksFromSpotify(tracksNumber);

    mongoTemplate.save(new ServiceLog(tracks.toString(), endPoint, "OUT"));

    return tracks;
  }

  @RequestMapping(value = "v1/tracks", params = "timeRange")
  public List<String> getTracks(@RequestParam String timeRange) {

    String endPoint = "v1/tracks?timeRange" + timeRange;

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    List<String> tracks = tracksParser.getTracksFromSpotify(timeRange);

    mongoTemplate.save(new ServiceLog(tracks.toString(), endPoint, "OUT"));

    return tracks;
  }

  @RequestMapping(value = "v1/tracks", params = {"tracksNumber", "timeRange"})
  public List<String> getTracks(@RequestParam int tracksNumber, @RequestParam String timeRange) {

    String endPoint = "v1/tracks?timeRange" + timeRange + "&tracksNumber" + tracksNumber;

    mongoTemplate.save(new ServiceLog("", endPoint, "IN"));

    List<String> tracks = tracksParser.getTracksFromSpotify(tracksNumber, timeRange);

    mongoTemplate.save(new ServiceLog(tracks.toString(), endPoint, "OUT"));

    return tracks;
  }
}