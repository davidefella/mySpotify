package mySpotify.model.Album;

import java.util.List;

public class Tracks {

  private String href;

  private List<Items> items;

  private int limit;

  private String next;

  private int offset;

  private String previous;

  private int total;

  public void setHref(String href) {
    this.href = href;
  }

  public String getHref() {
    return this.href;
  }

  public void setItems(List<Items> items) {
    this.items = items;
  }

  public List<Items> getItems() {
    return this.items;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getLimit() {
    return this.limit;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public String getNext() {
    return this.next;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getOffset() {
    return this.offset;
  }

  public void setPrevious(String previous) {
    this.previous = previous;
  }

  public String getPrevious() {
    return this.previous;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getTotal() {
    return this.total;
  }
}
