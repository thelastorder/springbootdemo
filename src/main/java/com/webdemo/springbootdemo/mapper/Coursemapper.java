package com.webdemo.springbootdemo.mapper;

import com.webdemo.springbootdemo.bean.Course;
import com.webdemo.springbootdemo.bean.Study;

import java.util.List;

public interface Coursemapper {
    public List<Study> fCourse(String id);
}
