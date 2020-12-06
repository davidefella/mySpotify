package mySpotify.logging.service;

import org.springframework.stereotype.Service;

@Service
public class MongoDBService {
   
    //@Autowired
    //MongoTemplate mongoTemplate;

    public void save(String message, String endPoint, String direction){
        //mongoTemplate.save(new ServiceLog(message, endPoint, direction));
        System.out.println(message + " - " + endPoint + " " + direction );
    }
}