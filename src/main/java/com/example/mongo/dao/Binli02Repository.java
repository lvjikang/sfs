package com.example.mongo.dao;

import com.example.mongo.entity.Binli02;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Binli02Repository extends MongoRepository<Binli02,String> {
    @Override
    List<Binli02> findAll();
}
