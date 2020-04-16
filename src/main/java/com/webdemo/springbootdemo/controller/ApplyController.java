package com.webdemo.springbootdemo.controller;

import com.webdemo.springbootdemo.bean.Apply;
import com.webdemo.springbootdemo.mapper.Applymapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ApplyController {

    @Autowired
    Applymapper applymapper;

    @GetMapping("/info")
    public List<Apply> info(@RequestParam("name") String name){
        return applymapper.applyInfo(name);
    }

    @PostMapping("/applyCourse")
    public void applyCourse(@RequestBody Map map){
        Apply apply = new Apply();
        apply.setAppName(map.get("username").toString());
        apply.setCid(Integer.parseInt(map.get("Cid").toString()));
        apply.setNowName(map.get("teacher").toString());
        apply.setCname(map.get("name").toString());
        apply.setReason(1);
        apply.setState(0);

        applymapper.applyCourse(apply);
    }
}
