package com.webdemo.springbootdemo.controller;

import com.webdemo.springbootdemo.bean.Person;
import com.webdemo.springbootdemo.mapper.Personmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.webdemo.springbootdemo.JwtUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private Personmapper personmapper;

    @PostMapping("/register")
    public void register(@RequestBody Person person){
        personmapper.register(person);
    }

    @PostMapping("/login")
    public Map login(@RequestBody Person person) throws Exception {
        Map map = new HashMap<>();
        Map<String,String> maplog = new HashMap<>();
        String username = person.getName();
        String password = person.getPassword();
        maplog.put(username,password);
        if(password.equals(personmapper.login(username))){
            Person person1 = personmapper.person_Info(username);
            JwtUtils jwtUtils = new JwtUtils();
            String token = jwtUtils.sign(maplog);
            map.put("code", "200");
            map.put("message","登录成功");
            map.put("token", token);
            map.put("card", person1.getCard());
            map.put("pid", person1.getPid());
            map.put("name", person1.getName());
            return map;
        }else{
            map.put("code", "403");
            map.put("message","登录失败");
            return map;
        }
    }
}
