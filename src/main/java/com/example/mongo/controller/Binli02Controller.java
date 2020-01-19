package com.example.mongo.controller;

import com.example.mongo.dao.Binli02Repository;
import com.example.mongo.entity.Binli02;
import com.example.mongo.service.Binli02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/binli02")
public class Binli02Controller {

    @Autowired
    private Binli02Repository binli02Repository;
    @Autowired
    private Binli02Service binli02Service;

    @PostMapping("/bsave")
    public List<Binli02> yusave() {
        binli02Service.save01();
        return binli02Repository.findAll();
    }

    @GetMapping("/formatruyuanzhenduan")
    public List<String> formatruyuanzhenduan() {
        return  binli02Service.formatruyuanzhenduan();
    }
}
