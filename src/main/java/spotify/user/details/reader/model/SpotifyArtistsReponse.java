package spotify.user.details.reader.model;

import java.util.ArrayList;
import java.util.List;

public class SpotifyArtistsReponse {
    List< Object > items = new ArrayList< Object >();
    private float total;
    private float limit;
    private float offset;
    private String previous = null;
    private String href;
    private String next;

    // Getter Methods
    public float getTotal() {
      return total;
    }

    public float getLimit() {
      return limit;
    }

    public float getOffset() {
      return offset;
    }

    public String getPrevious() {
      return previous;
    }

    public String getHref() {
      return href;
    }

    public String getNext() {
      return next;
    }

    // Setter Methods
    public void setTotal(float total) {
      this.total = total;
    }

    public void setLimit(float limit) {
      this.limit = limit;
    }

    public void setOffset(float offset) {
      this.offset = offset;
    }

    public void setPrevious(String previous) {
      this.previous = previous;
    }

    public void setHref(String href) {
      this.href = href;
    }

    public void setNext(String next) {
      this.next = next;
    }
}