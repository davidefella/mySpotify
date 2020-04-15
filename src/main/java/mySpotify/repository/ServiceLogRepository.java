package mySpotify.repository;

import mySpotify.model.logs.ServiceLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceLogRepository extends MongoRepository<ServiceLog, String>{}

