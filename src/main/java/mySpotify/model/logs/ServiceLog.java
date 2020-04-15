package mySpotify.model.logs;

import java.util.Date;

public class ServiceLog {

  private String message;

  private String endPoint;

  private String direction;

  private Date timestamp;

  public ServiceLog(String message, String endPoint, String direction) {
    this.message = message;
    this.endPoint = endPoint;
    this.direction = direction;
    this.timestamp = new Date();
  }

}