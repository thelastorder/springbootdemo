package com.webdemo.springbootdemo.mapper;

import com.webdemo.springbootdemo.bean.Course;
import com.webdemo.springbootdemo.bean.Study;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface Coursemapper {
    public List<Study> fCourse(String name);

    public List<Map> findCourse(Map map);

    public Integer CourseNum(Map map);

    public void addCourse(Course course);

    public Integer myCourseNum(String name,int active);

    public List<Map> myCourse(Map map);

    public void orderCourse(String  date,int Sid);
}
