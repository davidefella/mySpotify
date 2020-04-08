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
  public void Artists_Short_Returns20() {
    List<String> artists;

    artists = artistsParser.getArtistsFromSpotify(Consts.SHORT_INPUT);

    Assert.assertEquals(artists.size(), 20);
  }

  @Test
  public void Artists_Medium_Returns20() {
    List<String> artists;

    artists = artistsParser.getArtistsFromSpotify(Consts.MEDIUM_INPUT);

    Assert.assertEquals(artists.size(), 20);
  }

  @Test
  public void Artists_Long_Returns20() {
    List<String> artists;

    artists = artistsParser.getArtistsFromSpotify(Consts.LONG_INPUT);

    Assert.assertEquals(artists.size(), 20);
  }

  @Test
  public void Artists_DefaultCompareMedium_TheSame() {
    List<String> artistsDefault;
    List<String> artistsMediumRangeTime;

    artistsDefault = artistsParser.getDefaultArtistsFromSpotify();
    artistsMediumRangeTime = artistsParser.getArtistsFromSpotify(Consts.MEDIUM_INPUT);

    Assert.assertTrue(artistsDefault.equals(artistsMediumRangeTime));
  }

  @Test
  public void Artists_DefaultCompare20AndMedium_TheSame() {
    List<String> artistsDefault;
    List<String> artistsMediumRangeTime;

    artistsDefault = artistsParser.getDefaultArtistsFromSpotify();
    artistsMediumRangeTime = artistsParser.getArtistsFromSpotify(20, Consts.MEDIUM_INPUT);

    Assert.assertTrue(artistsDefault.equals(artistsMediumRangeTime));
  }

  @Test
  public void Artists_DefaultCompareShort_NotTheSame() {
    List<String> artistsDefault;
    List<String> artistsShortRangeTime;

    artistsDefault = artistsParser.getDefaultArtistsFromSpotify();
    artistsShortRangeTime = artistsParser.getArtistsFromSpotify(Consts.SHORT_INPUT);

    Assert.assertFalse(artistsDefault.equals(artistsShortRangeTime));
  }

  @Test
  public void Artists_DefaultCompareLong_NotTheSame() {
    List<String> artistsDefault;
    List<String> artistsLongRangeTime;

    artistsDefault = artistsParser.getDefaultArtistsFromSpotify();
    artistsLongRangeTime = artistsParser.getArtistsFromSpotify(Consts.LONG_INPUT);

    Assert.assertFalse(artistsDefault.equals(artistsLongRangeTime));
  }

  @Test
  public void Artists_DefaultCompare20AndShort_NotTheSame() {
    List<String> artistsDefault;
    List<String> artistsShortRangeTime;

    artistsDefault = artistsParser.getDefaultArtistsFromSpotify();
    artistsShortRangeTime = artistsParser.getArtistsFromSpotify(20, Consts.SHORT_INPUT);

    Assert.assertFalse(artistsDefault.equals(artistsShortRangeTime));
  }

  @Test
  public void Artists_DefaultCompare20AndLong_NotTheSame() {
    List<String> artistsDefault;
    List<String> artistsLongRangeTime;

    artistsDefault = artistsParser.getDefaultArtistsFromSpotify();
    artistsLongRangeTime = artistsParser.getArtistsFromSpotify(20, Consts.LONG_INPUT);

    Assert.assertFalse(artistsDefault.equals(artistsLongRangeTime));
  }

}