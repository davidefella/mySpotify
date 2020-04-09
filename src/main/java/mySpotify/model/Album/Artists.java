package mySpotify.model.Album;

public class Artists {

  private External_urls external_urls;

  private String href;

  private String id;

  private String name;

  private String type;

  private String uri;

  public void setExternal_urls(External_urls external_urls) {
    this.external_urls = external_urls;
  }

  public External_urls getExternal_urls() {
    return this.external_urls;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public String getHref() {
    return this.href;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getUri() {
    return this.uri;
  }
}