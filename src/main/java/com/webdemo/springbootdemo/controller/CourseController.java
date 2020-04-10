package com.webdemo.springbootdemo.controller;

import com.webdemo.springbootdemo.bean.Course;
import com.webdemo.springbootdemo.bean.Study;
import com.webdemo.springbootdemo.mapper.Coursemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    private Coursemapper coursemapper;

    @PostMapping("/myCourse")
    public List<Study> firstCourse(@RequestBody Map map){
        String id = map.get("id").toString();
        List<Study> study = coursemapper.fCourse(id);

        return study;
    }
}
