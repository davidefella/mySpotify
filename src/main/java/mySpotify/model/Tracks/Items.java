package mySpotify.model.Tracks;

import java.util.List;

public class Items {

  private Album album;

  private List<Artists> artists;

  private List<String> available_markets;

  private int disc_number;

  private int duration_ms;

  private boolean explicit;

  private External_ids external_ids;

  private External_urls external_urls;

  private String href;

  private String id;

  private boolean is_local;

  private String name;

  private int popularity;

  private String preview_url;

  private int track_number;

  private String type;

  private String uri;

  public void setAlbum(Album album) {
    this.album = album;
  }

  public Album getAlbum() {
    return this.album;
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

  public void setDisc_number(int disc_number) {
    this.disc_number = disc_number;
  }

  public int getDisc_number() {
    return this.disc_number;
  }

  public void setDuration_ms(int duration_ms) {
    this.duration_ms = duration_ms;
  }

  public int getDuration_ms() {
    return this.duration_ms;
  }

  public void setExplicit(boolean explicit) {
    this.explicit = explicit;
  }

  public boolean getExplicit() {
    return this.explicit;
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

  public void setIs_local(boolean is_local) {
    this.is_local = is_local;
  }

  public boolean getIs_local() {
    return this.is_local;
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

  public void setPreview_url(String preview_url) {
    this.preview_url = preview_url;
  }

  public String getPreview_url() {
    return this.preview_url;
  }

  public void setTrack_number(int track_number) {
    this.track_number = track_number;
  }

  public int getTrack_number() {
    return this.track_number;
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