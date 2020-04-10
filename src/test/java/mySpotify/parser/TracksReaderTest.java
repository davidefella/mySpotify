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
  public void Tracks_Default_ReturnsTwenty() {
    List<String> tracks;

    tracks = tracksParser.getDefaultTracksFromSpotify();

    Assert.assertEquals(tracks.size(), 20);
  }

  @Test
  public void Tracks_EqualZero_ReturnsZero() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(0);

    Assert.assertEquals(tracks.size(), 0);
  }

  @Test
  public void Tracks_EqualFifty_ReturnsFifty() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(50);

    Assert.assertEquals(tracks.size(), 50);
  }

  @Test
  public void Tracks_OverSpotifyLimit_ReturnsFifty() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(51);

    Assert.assertEquals(tracks.size(), 50);
  }

  @Test
  public void Tracks_TimeRangeShort_ReturnsTwenty() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(Consts.SHORT_INPUT);

    Assert.assertEquals(tracks.size(), 20);
  }

  @Test
  public void Tracks_TimeRangeMedium_ReturnsTwenty() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(Consts.MEDIUM_INPUT);

    Assert.assertEquals(tracks.size(), 20);
  }

  @Test
  public void Tracks_TimeRangeLarge_ReturnsTwenty() {
    List<String> tracks;

    tracks = tracksParser.getTracksFromSpotify(Consts.LONG_INPUT);

    Assert.assertEquals(tracks.size(), 20);
  }

  @Test
  public void Tracks_DefaultCompareTimeRangeMedium_TheSame() {
    List<String> tracksDefault;
    List<String> tracksMediumRangeTime;

    tracksDefault = tracksParser.getDefaultTracksFromSpotify();
    tracksMediumRangeTime = tracksParser.getTracksFromSpotify(Consts.MEDIUM_INPUT);

    Assert.assertTrue(tracksDefault.equals(tracksMediumRangeTime));
  }

  @Test
  public void Tracks_DefaultCompareEqualTwentyAndTimeRangeMedium_TheSame() {
    List<String> tracksDefault;
    List<String> tracksMediumRangeTime;

    tracksDefault = tracksParser.getDefaultTracksFromSpotify();
    tracksMediumRangeTime = tracksParser.getTracksFromSpotify(20, Consts.MEDIUM_INPUT);

    Assert.assertTrue(tracksDefault.equals(tracksMediumRangeTime));
  }

  @Test
  public void Tracks_DefaultCompareTimeRangeShort_NotTheSame() {
    List<String> tracksDefault;
    List<String> tracksShortRangeTime;

    tracksDefault = tracksParser.getDefaultTracksFromSpotify();
    tracksShortRangeTime = tracksParser.getTracksFromSpotify(Consts.SHORT_INPUT);

    Assert.assertFalse(tracksDefault.equals(tracksShortRangeTime));
  }

  @Test
  public void Tracks_DefaultCompareTimeRangeLong_NotTheSame() {
    List<String> tracksDefault;
    List<String> tracksLongRangeTime;

    tracksDefault = tracksParser.getDefaultTracksFromSpotify();
    tracksLongRangeTime = tracksParser.getTracksFromSpotify(Consts.LONG_INPUT);

    Assert.assertFalse(tracksDefault.equals(tracksLongRangeTime));
  }

  @Test
  public void Tracks_DefaultCompareEqualTwentyAndTimeRangeShort_NotTheSame() {
    List<String> tracksDefault;
    List<String> tracksShortRangeTime;

    tracksDefault = tracksParser.getDefaultTracksFromSpotify();
    tracksShortRangeTime = tracksParser.getTracksFromSpotify(20, Consts.SHORT_INPUT);

    Assert.assertFalse(tracksDefault.equals(tracksShortRangeTime));
  }

  @Test
  public void Tracks_DefaultCompareTwentyAndTimeRangeLong_NotTheSame() {
    List<String> tracksDefault;
    List<String> tracksLongRangeTime;

    tracksDefault = tracksParser.getDefaultTracksFromSpotify();
    tracksLongRangeTime = tracksParser.getTracksFromSpotify(20, Consts.LONG_INPUT);

    Assert.assertFalse(tracksDefault.equals(tracksLongRangeTime));
  }
}