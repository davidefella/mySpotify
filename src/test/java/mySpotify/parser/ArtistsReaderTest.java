package mySpotify.parser;

import java.util.List;
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
    List<String> defaultList;

    defaultList = artistsParser.getDefaultArtistsFromSpotify();

    Assert.assertEquals(defaultList.size(), 20);
  }

  @Test
  public void Artists_FromSpotify_Returns0() {
    List<String> defaultList;

    defaultList = artistsParser.getArtistsFromSpotify(0);

    Assert.assertEquals(defaultList.size(), 0);
  }

  @Test
  public void Artists_FromSpotify_Returns50() {
    List<String> defaultList;

    defaultList = artistsParser.getArtistsFromSpotify(50);

    Assert.assertEquals(defaultList.size(), 50);
  }
}
