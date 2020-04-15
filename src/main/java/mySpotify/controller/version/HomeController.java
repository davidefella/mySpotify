package mySpotify.controller.version;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @Value("${app.version}")
  private String appVersion;

  @GetMapping
  @RequestMapping("/")
  public Map getStatus() {
    Map applicationVersion = new HashMap<String, String>();
    applicationVersion.put("app-version", appVersion);

    return applicationVersion;
  }
}