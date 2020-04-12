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
        String name = map.get("name").toString();
        List<Study> study = coursemapper.fCourse(name);

        return study;
    }

    @PostMapping("courseNum")
    public Integer  CourseNum(@RequestBody Map map){
        return coursemapper.CourseNum(map);
    }

    @PostMapping("course")
    public List<Map>  findCourse(@RequestBody Map<String,Object> map){
        int first = (Integer.parseInt(map.get("num").toString())-1)*3;
        int last = (Integer.parseInt(map.get("num").toString()))*3;
        map.put("first",first);
        map.put("last",last);
      return coursemapper.findCourse(map);
    }
}
