package com.example.mongo.service;

import com.example.mongo.entity.PatBinli;
import org.bson.types.ObjectId;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatBinliService {
    void save(PatBinli patBinli);
    void save02();
    PatBinli findByPatname(String patname);
    List<PatBinli> findPatBinlisByBinliIsLike(String key);
    List<PatBinli> zhenlifenleibykey();
    List<PatBinli> findPatBinlisByIdIsNotNull();
    List<PatBinli> findofquanwensouyinbykey(String key);

    int updatepatxinxiofsets(int patid, List<String> keys);
}
