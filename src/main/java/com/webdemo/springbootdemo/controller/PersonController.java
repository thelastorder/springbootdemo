package com.webdemo.springbootdemo.controller;

import com.webdemo.springbootdemo.mapper.Personmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class PersonController {
    @Autowired
    private Personmapper personmapper;

    @PostMapping("/personID")
    public Integer cha(@RequestBody Map name){
        String username = name.get("value").toString();
        return personmapper.chaxun(username);
    }
}
