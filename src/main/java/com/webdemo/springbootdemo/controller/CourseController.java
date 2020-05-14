package com.webdemo.springbootdemo.controller;

import com.webdemo.springbootdemo.bean.Course;
import com.webdemo.springbootdemo.bean.Study;
import com.webdemo.springbootdemo.mapper.Coursemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
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

    @PostMapping("/courseNum")
    public Integer  CourseNum(@RequestBody Map map){
        return coursemapper.CourseNum(map);
    }

    @PostMapping("/myCourseNum")
    public Integer myCourseNum(@RequestBody Map map){
        String name = map.get("name").toString();
        int active =Integer.parseInt(map.get("active").toString());
        return coursemapper.myCourseNum(name,active);
    }

    @PostMapping("/orderCourse")
    public void orderCourse(@RequestBody Map map){
        String date = map.get("ordertime").toString();
        int sid = Integer.parseInt(map.get("Sid").toString());
        coursemapper.orderCourse(date ,sid);
    }

    @PostMapping("/course")
    public List<Map>  findCourse(@RequestBody Map<String,Object> map){
        int first = (Integer.parseInt(map.get("num").toString())-1)*3;
        int last = (Integer.parseInt(map.get("num").toString()))*3;
        map.put("first",first);
        map.put("last",last);
      return coursemapper.findCourse(map);
    }

    @PostMapping("/myCourseInfo")
    public List<Map>  myCourse(@RequestBody Map<String,Object> map){
        map.put("active",Integer.parseInt(map.get("active").toString()));
        int first = (Integer.parseInt(map.get("number").toString())-1)*3;
        int last = (Integer.parseInt(map.get("number").toString()))*3;
        map.put("first",first);
        map.put("last",last);
        return coursemapper.myCourse(map);
    }

    @PostMapping("/addCourse")
    public void addCourse(@RequestBody Course course){
        coursemapper.addCourse(course);
    }
}
