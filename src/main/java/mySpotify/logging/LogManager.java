package mySpotify.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mySpotify.logging.service.MongoDBService;

@Service
public class LogManager {

    @Autowired
    MongoDBService mongoDBService; 
    
    public void save(String message, String endPoint, String direction){
        mongoDBService.save(message, endPoint, direction);
    }
}