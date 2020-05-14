package com.webdemo.springbootdemo.mapper;

import com.webdemo.springbootdemo.bean.Apply;

import java.util.List;

public interface Applymapper {
    public void applyCourse(Apply apply);

    public List<Apply> applyInfo(String name);

    public List<Apply> applyUnread(String name);

    public List<Apply> applyRead(String name);
}
