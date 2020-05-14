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

    @GetMapping("/infoUnread")
    public List<Apply> infoUnread(@RequestParam("name") String name){
        return applymapper.applyUnread(name);
    }

    @GetMapping("/infoRead")
    public List<Apply> infoRead(@RequestParam("name") String name){
        return applymapper.applyRead(name);
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
        apply.setTime(map.get("time").toString());

        applymapper.applyCourse(apply);
    }
}
