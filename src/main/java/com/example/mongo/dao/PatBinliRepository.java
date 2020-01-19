package com.example.mongo.dao;

import com.example.mongo.entity.PatBinli;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.PreUpdate;
import java.util.*;

@Repository
public interface PatBinliRepository extends MongoRepository<PatBinli,Integer> {
    PatBinli findByPatname(String patname);
    List<PatBinli> findPatBinlisByBinliIsLike(String key);
    List<PatBinli> findPatBinlisByIdIsNotNull();

    @Query("{'$text':{'$search': ?0}}")
    List<PatBinli> findofquanwensouyinbykey(@Param("key") String key);


}
