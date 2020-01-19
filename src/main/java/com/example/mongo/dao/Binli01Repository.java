package com.example.mongo.dao;

import com.example.mongo.entity.Binli01;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Binli01Repository extends MongoRepository<Binli01,String> {

    List<Binli01> findBinli01ByDoctorbianhaoContaining(String bianhao);

    @Override
    List<Binli01> findAll();

    //c
}
