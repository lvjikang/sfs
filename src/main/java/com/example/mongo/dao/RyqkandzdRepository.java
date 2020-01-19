package com.example.mongo.dao;

import com.example.mongo.entity.Ryqkandzd;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RyqkandzdRepository extends MongoRepository<Ryqkandzd,String> {
}
