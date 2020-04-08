package mySpotify.parser;

import java.util.List;
import mySpotify.util.Consts;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtistsReaderTest {

  @Autowired
  ArtistsParser artistsParser;

  @Test
  public void Artists_Default_Returns20() {
    List<String> artists;

    artists = artistsParser.getDefaultArtistsFromSpotify();

    Assert.assertEquals(artists.size(), 20);
  }

  @Test
  public void Artists_NumberParam_Returns0() {
    List<String> artists;

    artists = artistsParser.getArtistsFromSpotify(0);

    Assert.assertEquals(artists.size(), 0);
  }

  @Test
  public void Artists_NumberParam_Returns50() {
    List<String> artists;

    artists = artistsParser.getArtistsFromSpotify(50);

    Assert.assertEquals(artists.size(), 50);
  }

  @Test
  public void Artists_TimeRangeShort_Returns20() {
    List<String> artists;

    artists = artistsParser.getArtistsFromSpotify(Consts.SHORT_INPUT);

    Assert.assertEquals(artists.size(), 20);
  }

  @Test
  public void Artists_TimeRangeMedium_Returns20() {
    List<String> artists;

    artists = artistsParser.getArtistsFromSpotify(Consts.MEDIUM_INPUT);

    Assert.assertEquals(artists.size(), 20);
  }

  @Test
  public void Artists_TimeRangeLarge_Returns20() {
    List<String> artists;

    artists = artistsParser.getArtistsFromSpotify(Consts.LONG_INPUT);

    Assert.assertEquals(artists.size(), 20);
  }
}