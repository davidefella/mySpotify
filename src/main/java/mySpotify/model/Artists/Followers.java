package mySpotify.model.Artists;

public class Followers {

  private String href;

  private int total;

  public void setHref(String href) {
    this.href = href;
  }

  public String getHref() {
    return this.href;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getTotal() {
    return this.total;
  }
}
