package mySpotify.parser;

import java.util.Map;
import java.util.Set;
import mySpotify.util.Consts;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenreReaderTest {

  @Autowired
  GenreParser genreParser;

  @Test
  public void Genre_Default_isNotNull() {

    Map<String, String> defaultGenreToCount;
    Set<String> keySetGenreString;

    defaultGenreToCount = genreParser.getGenresFromDefault();
    keySetGenreString = defaultGenreToCount.keySet();

    Assert.assertNotNull(keySetGenreString);
    Assert.assertTrue(keySetGenreString.size() > 0);
  }

  @Test
  public void Genre_NumberParamZero_Returns0() {
    Map<String, String> genreToCount;

    genreToCount = genreParser.getGenresFromSpotify(0);

    Assert.assertEquals(genreToCount.size(), 0);
  }

  @Test
  public void Genre_EqualFifty_KeySetNotNull() {
    Map<String, String> genreToCount;

    genreToCount = genreParser.getGenresFromSpotify(50);

    Assert.assertNotNull(genreToCount.keySet());
  }

  @Test
  public void Genre_OverSpotifyLimit_KeySetNotNull() {
    Map<String, String> genreToCount;

    genreToCount = genreParser.getGenresFromSpotify(51);

    Assert.assertNotNull(genreToCount.keySet());
  }

  @Test
  public void Genre_TimeRangeShort_KeySetNotNull() {
    Map<String, String> genreToCount;

    genreToCount = genreParser.getGenresFromSpotify(Consts.SHORT_INPUT);

    Assert.assertNotNull(genreToCount.keySet());
  }


  @Test
  public void Genre_TimeRangeMedium_KeySetNotNull() {
    Map<String, String> genreToCount;

    genreToCount = genreParser.getGenresFromSpotify(Consts.MEDIUM_INPUT);

    Assert.assertNotNull(genreToCount.keySet());
  }

  @Test
  public void Genre_TimeRangeLong_KeySetNotNull() {
    Map<String, String> genreToCount;

    genreToCount = genreParser.getGenresFromSpotify(Consts.LONG_INPUT);

    Assert.assertNotNull(genreToCount.keySet());
  }

  @Test
  public void Genre_DefaultCompareMedium_KeySetIsTheSame() {
    Map<String, String> defaultGenreToCount;
    Map<String, String> genreToCountMediumRange;

    defaultGenreToCount = genreParser.getGenresFromDefault();
    genreToCountMediumRange = genreParser.getGenresFromSpotify(Consts.MEDIUM_INPUT);

    Assert.assertTrue(
        defaultGenreToCount.keySet().toString()
            .equals(genreToCountMediumRange.keySet().toString()));
  }

  @Test
  public void Genre_DefaultCompareTwentyAndTimeRangeMedium_TheSame() {
    Map<String, String> defaultGenreToCount;
    Map<String, String> genreToCountMediumRange;

    defaultGenreToCount = genreParser.getGenresFromDefault();
    genreToCountMediumRange = genreParser.getGenresFromSpotify(20, Consts.MEDIUM_INPUT);

    Assert.assertTrue(
        defaultGenreToCount.keySet().toString()
            .equals(genreToCountMediumRange.keySet().toString()));
  }

  @Test
  public void Genre_DefaultCompareRangeShort_NotTheSame() {
    Map<String, String> defaultGenreToCount;
    Map<String, String> genreToCountShortRange;

    defaultGenreToCount = genreParser.getGenresFromDefault();
    genreToCountShortRange = genreParser.getGenresFromSpotify(20, Consts.SHORT_INPUT);

    Assert.assertFalse(
        defaultGenreToCount.keySet().toString().equals(genreToCountShortRange.keySet().toString()));
  }

  @Test
  public void Genre_DefaultCompareRangeLong_NotTheSame() {
    Map<String, String> defaultGenreToCount;
    Map<String, String> genreToCountLongRange;

    defaultGenreToCount = genreParser.getGenresFromDefault();
    genreToCountLongRange = genreParser.getGenresFromSpotify(20, Consts.LONG_INPUT);

    Assert
        .assertFalse(defaultGenreToCount.keySet().toString()
            .equals(genreToCountLongRange.keySet().toString()));
  }

  @Test
  public void Genre_DefaultCompareTwentyAndTimeRangeShort_NotTheSame() {
    Map<String, String> defaultGenreToCount;
    Map<String, String> genreToCountShortRange;

    defaultGenreToCount = genreParser.getGenresFromDefault();
    genreToCountShortRange = genreParser.getGenresFromSpotify(20, Consts.SHORT_INPUT);

    Assert.assertFalse(
        defaultGenreToCount.keySet().toString().equals(genreToCountShortRange.keySet().toString()));
  }

  @Test
  public void Genre_DefaultCompareTwentyAndTimeRangeLong_NotTheSame() {
    Map<String, String> defaultGenreToCount;
    Map<String, String> genreToCountLongRange;

    defaultGenreToCount = genreParser.getGenresFromDefault();
    genreToCountLongRange = genreParser.getGenresFromSpotify(20, Consts.LONG_INPUT);

    Assert
        .assertFalse(defaultGenreToCount.keySet().toString()
            .equals(genreToCountLongRange.keySet().toString()));
  }
}