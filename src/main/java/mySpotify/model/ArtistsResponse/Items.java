package mySpotify.model.ArtistsResponse;

import java.util.ArrayList;
import java.util.List;

public class Items {

  private External_urls external_urls;

  private Followers followers;

  private List<String> genres;

  private String href;

  private String id;

  private List<Images> images;

  private String name;

  private int popularity;

  private String type;

  private String uri;

  public void setExternal_urls(External_urls external_urls) {
    this.external_urls = external_urls;
  }

  public External_urls getExternal_urls() {
    return this.external_urls;
  }

  public void setFollowers(Followers followers) {
    this.followers = followers;
  }

  public Followers getFollowers() {
    return this.followers;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }

  public List<String> getGenres() {
    return this.genres;
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

  public void setImages(List<Images> images) {
    this.images = images;
  }

  public List<Images> getImages() {
    return this.images;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public int getPopularity() {
    return this.popularity;
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

