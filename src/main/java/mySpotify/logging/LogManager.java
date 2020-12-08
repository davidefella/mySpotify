package mySpotify.logging;

import org.springframework.stereotype.Service;

@Service
public class LogManager {

    public void save(String message, String endPoint, String direction){
        System.out.println(message + " - " + endPoint + " " + direction );
    }
}