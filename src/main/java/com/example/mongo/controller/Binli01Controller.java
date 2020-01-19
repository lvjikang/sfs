package com.example.mongo.controller;

import com.example.mongo.dao.Binli01Repository;
import com.example.mongo.entity.Binli01;
import com.example.mongo.service.BInli01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/binli01")
public class Binli01Controller {

    @Autowired
    private BInli01Service bInli01Service;
    @Autowired
    private Binli01Repository binli01Repository;

    @PostMapping("/bsave")
    public List<Binli01> yusave() {
        bInli01Service.save01();
        return binli01Repository.findAll();
    }

    @GetMapping("/getbydtbianhao")
    public List<Binli01> findbydtbianhao(@RequestParam("bianhao") String bianhao){
        List<Binli01> list = new ArrayList<>();
        list = binli01Repository.findBinli01ByDoctorbianhaoContaining(bianhao);
        return list;
    }

    @GetMapping("/formatruyuanzhenduan")
    public List<String> formatruyuanzhenduan() {
        return  bInli01Service.formatruyuanzhenduan();
    }
}
