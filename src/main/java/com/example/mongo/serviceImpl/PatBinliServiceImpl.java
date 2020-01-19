package com.example.mongo.serviceImpl;

import com.example.mongo.dao.PatBinliRepository;
import com.example.mongo.entity.PatBinli;
import com.example.mongo.service.PatBinliService;
import com.example.mongo.util.Chuliword;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.BasicUpdate;

@Service
public class PatBinliServiceImpl implements PatBinliService {

    private static List<String> keysets = new ArrayList<>();
    private List<PatBinli> prtlist01 = new ArrayList<>();

    static {
        keysets.add("血管异常");
        keysets.add("色素斑");
        keysets.add("龋病");
        keysets.add("咳嗽");
        keysets.add("发热");
        keysets.add("肺炎");
        keysets.add("肺结核");
        keysets.add("肺癌");
        keysets.add("气促");
        keysets.add("胸痛");
        keysets.add("心肌炎");
        keysets.add("心衰");
        keysets.add("尿频");
        keysets.add("尿急");
        keysets.add("皮疹");
        keysets.add("咽痛");
        keysets.add("糖尿病");
        keysets.add("高血压");
        keysets.add("药物过敏");
        keysets.add("前列腺炎");
    }

    @Autowired
    private Chuliword chuliword;

    @Autowired
    private PatBinliRepository patBinliRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(PatBinli patBinli) {
        patBinliRepository.save(patBinli);
    }

    @Override
    public void save02() {
        List<PatBinli> patBinlis = Chuliword.doc2String("E:\\aaa\\资料\\病历\\");
        System.out.println("开始第一步预存入: size " + patBinlis.size());
        for (PatBinli p : patBinlis) {
            patBinliRepository.save(p);
        }
    }

    @Override
    public PatBinli findByPatname(String patname) {
        return this.patBinliRepository.findByPatname(patname);
    }

    @Override
    public List<PatBinli> findPatBinlisByBinliIsLike(String key) {
        return this.patBinliRepository.findPatBinlisByBinliIsLike(key);
    }

    @Override
    public List<PatBinli> zhenlifenleibykey() {
        prtlist01 = this.patBinliRepository.findPatBinlisByIdIsNotNull();
        System.out.println("keysets size: " + keysets.size());

        for (String key : keysets) {
            List<PatBinli> litys = this.patBinliRepository.findPatBinlisByBinliIsLike(key);
            for (PatBinli p : litys) {
                //--
                for (PatBinli p2 : prtlist01) {
                    if (p2.getId() == p.getId()) {
                        p2.getKeyset().add(key);
                        break;
                    }
                }
            }
        }

        for (PatBinli p3 : prtlist01) {
            if(p3.getId()!=null) {
                System.out.println("修改病人ID "+p3.getId());
                this.updatepatxinxiofsets(p3.getId(), p3.getKeyset());
            }
        }

        return prtlist01;
    }

    @Override
    public List<PatBinli> findPatBinlisByIdIsNotNull() {
        return this.patBinliRepository.findPatBinlisByIdIsNotNull();
    }

    @Override
    public List<PatBinli> findofquanwensouyinbykey(String key) {
        return this.patBinliRepository.findofquanwensouyinbykey(key);
    }

    @Override
    public int updatepatxinxiofsets(int patid, List<String> keys) {
//        BasicDBObject basicDBObject = new BasicDBObject();
//        System.out.println("接受keys size: "+keys.size());
//        basicDBObject.put("$set", new BasicDBObject("keyset", keys));
//        Update update = new BasicUpdate(String.valueOf(basicDBObject));
//        mongoTemplate.updateFirst(new Query(Criteria.where("id").is(patid)), update, "patBinli");

        Query query = Query.query(Criteria.where("id").is(patid));
        Update update = Update.update("keyset",keys);
        mongoTemplate.updateFirst(query,update, PatBinli.class);
        System.out.println("-.");

        return 1;
    }
}
