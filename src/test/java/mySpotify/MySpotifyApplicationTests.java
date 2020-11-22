package mySpotify;

import mySpotify.controller.api.ArtistsReader;
import mySpotify.controller.api.TracksReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpotifyApplicationTests {

  @Autowired
  ArtistsReader artistsReader;

  @Autowired
  TracksReader tracksReader;

  @Test
  public void contextLoads(){
    Assert.assertNotNull(artistsReader);
    Assert.assertNotNull(tracksReader);
  }
}