package mySpotify.parser;

import java.util.List;
import mySpotify.util.Consts;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TracksReaderTest {

  @Autowired
  TracksParser tracksParser;

  @Test
  public void Tracks_Default_Returns20() {
    List<String> tracks;

    tracks = tracksParser.getDefaultTracksFromSpotify();

    Assert.assertEquals(tracks.size(), 20);
  }

  @Test
  public void Tracks_NumberParam_Returns0() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(0);

    Assert.assertEquals(tracks.size(), 0);
  }

  @Test
  public void Tracks_NumberParam_Returns50() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(50);

    Assert.assertEquals(tracks.size(), 50);
  }

  @Test
  public void Tracks_TimeRangeShort_Returns20() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(Consts.SHORT_INPUT);

    Assert.assertEquals(tracks.size(), 20);
  }

  @Test
  public void Tracks_TimeRangeMedium_Returns20() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(Consts.MEDIUM_INPUT);

    Assert.assertEquals(tracks.size(), 20);
  }

  @Test
  public void Tracks_TimeRangeLarge_Returns20() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(Consts.LONG_INPUT);

    Assert.assertEquals(tracks.size(), 20);
  }
}