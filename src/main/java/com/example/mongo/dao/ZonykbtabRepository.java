package com.example.mongo.dao;

import com.example.mongo.entity.Zonykbtab;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonykbtabRepository extends MongoRepository<Zonykbtab,String> {
    Zonykbtab getByXuhao(int xuhao);
}
