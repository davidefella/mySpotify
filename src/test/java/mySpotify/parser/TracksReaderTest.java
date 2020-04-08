package mySpotify.parser;

import java.util.List;
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
    List<String> defaultList;

    defaultList = tracksParser.getDefaultTracksFromSpotify();

    Assert.assertEquals(defaultList.size(), 20);
  }

  @Test
  public void Tracks_FromSpotify_Returns0() {
    List<String> defaultList;

    defaultList = tracksParser.getTracksFromSpotify(0);

    Assert.assertEquals(defaultList.size(), 0);
  }

  @Test 
  public void Tracks_FromSpotify_Returns50() {
    List<String> defaultList;

    defaultList = tracksParser.getTracksFromSpotify(50);

    Assert.assertEquals(defaultList.size(), 50);
  }
}
