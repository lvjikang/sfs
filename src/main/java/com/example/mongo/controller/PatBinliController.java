package com.example.mongo.controller;

import com.example.mongo.entity.PatBinli;
import com.example.mongo.service.PatBinliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatBinliController {

    @Autowired
    private PatBinliService patBinliService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/add")
    public PatBinli add(@RequestParam("pid")int pid,@RequestParam("pname")String pname,@RequestParam("pbinli")String pbinli){
        PatBinli p = new PatBinli(pid,pname,pbinli);
        patBinliService.save(p);
        return p;
    }

    @PostMapping("/yusave")
    public String yusave(){
        patBinliService.save02();
        return "预存入完毕";
    }

    @GetMapping("/findbyname")
    public PatBinli findbyname(@RequestParam("pname")String pname){
        PatBinli p = patBinliService.findByPatname(pname);
        return p;
    }

    @GetMapping("/findbykey")
    public List<PatBinli> findbykey(@RequestParam("pbinlikey")String pbinlikey){
        List<PatBinli> p = patBinliService.findPatBinlisByBinliIsLike(pbinlikey);
        return p;
    }

    @GetMapping("/findall")
    public List<PatBinli> findall(){
        List<PatBinli> p = patBinliService.findPatBinlisByIdIsNotNull();
        return p;
    }

    @GetMapping("/findofquanwensouyinbykey")
    public List<PatBinli> findofquanwensouyinbykey(@RequestParam("key")String key){
        return patBinliService.findofquanwensouyinbykey(key);
    }

    @GetMapping("/zhenlifenleibykey")
    public List<PatBinli> zhenlifenleibykey(){
        return patBinliService.zhenlifenleibykey();
    }

}
