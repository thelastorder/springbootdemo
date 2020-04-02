package com.webdemo.springbootdemo.controller;

import com.webdemo.springbootdemo.bean.Person;
import com.webdemo.springbootdemo.mapper.Personmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@RestController
public class PersonController {
    @Autowired
    private Personmapper personmapper;

    @PostMapping("/person")
    public Person Person_Info(@RequestBody Map map){
        String username = map.get("name").toString();
        return personmapper.person_Info(username);
    }

    @PostMapping("/person_c")
    public void Person_Change(@RequestBody Person person){
        personmapper.person_Change(person);
    }
}
