package spotify.user.details.reader.context;

public class ContextHandler {

  private String refreshToken;

  public String getRefreshToken(){
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken){
    this.refreshToken = refreshToken; 
  }
}
