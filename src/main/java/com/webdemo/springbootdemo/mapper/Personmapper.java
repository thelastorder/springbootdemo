package com.webdemo.springbootdemo.mapper;

import com.webdemo.springbootdemo.bean.Person;
public interface Personmapper {
    public void register(Person person);

    public Integer chaxun(String name);

    public String login(String username);
}
