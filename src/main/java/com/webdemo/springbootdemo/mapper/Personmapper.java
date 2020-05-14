package com.webdemo.springbootdemo.mapper;

import com.webdemo.springbootdemo.bean.Person;

import java.util.List;

public interface Personmapper {
    public void register(Person person);

    public Person person_Info(String name);

    public String login(String username);

    public void person_update(String picture,String username);

    public void person_Change(Person person);

    public List<Person> personManager();
}
