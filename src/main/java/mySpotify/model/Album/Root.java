package mySpotify.model.Album;

import java.util.List;

public class Root {

  private String album_type;

  private List<Artists> artists;

  private List<String> available_markets;

  private List<Copyrights> copyrights;

  private External_ids external_ids;

  private External_urls external_urls;

  private List<String> genres;

  private String href;

  private String id;

  private List<Images> images;

  private String label;

  private String name;

  private int popularity;

  private String release_date;

  private String release_date_precision;

  private int total_tracks;

  private Tracks tracks;

  private String type;

  private String uri;

  public void setAlbum_type(String album_type) {
    this.album_type = album_type;
  }

  public String getAlbum_type() {
    return this.album_type;
  }

  public void setArtists(List<Artists> artists) {
    this.artists = artists;
  }

  public List<Artists> getArtists() {
    return this.artists;
  }

  public void setAvailable_markets(List<String> available_markets) {
    this.available_markets = available_markets;
  }

  public List<String> getAvailable_markets() {
    return this.available_markets;
  }

  public void setCopyrights(List<Copyrights> copyrights) {
    this.copyrights = copyrights;
  }

  public List<Copyrights> getCopyrights() {
    return this.copyrights;
  }

  public void setExternal_ids(External_ids external_ids) {
    this.external_ids = external_ids;
  }

  public External_ids getExternal_ids() {
    return this.external_ids;
  }

  public void setExternal_urls(External_urls external_urls) {
    this.external_urls = external_urls;
  }

  public External_urls getExternal_urls() {
    return this.external_urls;
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

  public void setLabel(String label) {
    this.label = label;
  }

  public String getLabel() {
    return this.label;
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

  public void setRelease_date(String release_date) {
    this.release_date = release_date;
  }

  public String getRelease_date() {
    return this.release_date;
  }

  public void setRelease_date_precision(String release_date_precision) {
    this.release_date_precision = release_date_precision;
  }

  public String getRelease_date_precision() {
    return this.release_date_precision;
  }

  public void setTotal_tracks(int total_tracks) {
    this.total_tracks = total_tracks;
  }

  public int getTotal_tracks() {
    return this.total_tracks;
  }

  public void setTracks(Tracks tracks) {
    this.tracks = tracks;
  }

  public Tracks getTracks() {
    return this.tracks;
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
