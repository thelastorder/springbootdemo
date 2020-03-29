package com.webdemo.springbootdemo.controller;

import com.webdemo.springbootdemo.bean.Person;
import com.webdemo.springbootdemo.mapper.Personmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.webdemo.springbootdemo.JwtUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Logincontroller {

    @Autowired
    private Personmapper personmapper;

    @PostMapping("/register")
    public void register(@RequestBody Person person){
        personmapper.register(person);
    }
    @PostMapping("/personID")
    public Integer cha(@RequestBody Map name){
        String username = name.get("value").toString();
        return personmapper.chaxun(username);
    }

    @PostMapping("/login")
    public Map login(@RequestBody Person person) throws Exception {
        Map map = new HashMap<>();
        Map<String,String> maplog = new HashMap<>();
        String username = person.getName();
        String password = person.getPassword();
        maplog.put(username,password);
        if(password.equals(personmapper.login(username))){
            JwtUtils jwtUtils = new JwtUtils();
            String token = jwtUtils.sign(maplog);
            map.put("code", "200");
            map.put("message","登录成功");
            map.put("token", token);
            return map;
        }else{
            map.put("code", "403");
            map.put("message","登录失败");
            return map;
        }
    }
}
