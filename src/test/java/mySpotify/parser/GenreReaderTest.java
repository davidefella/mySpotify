package mySpotify.parser;

import java.util.Map;
import java.util.Set;
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

    Map<String, Integer> genresFromSpotify;
    Set<String> keySetGenreString;

    genresFromSpotify = genreParser.getGenresFromSpotify();
    keySetGenreString = genresFromSpotify.keySet();

    Assert.assertNotNull(keySetGenreString);
    Assert.assertTrue(keySetGenreString.size() > 0);
  }
}