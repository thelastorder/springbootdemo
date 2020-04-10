package com.webdemo.springbootdemo.bean;

import java.sql.Timestamp;

public class Study {
    private int Sid;
    private int Cid;
    private int StuNum;
    private int teaNum;
    private Timestamp time;
    private int Ctime;
    private int active;

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public int getStuNum() {
        return StuNum;
    }

    public void setStuNum(int stuNum) {
        StuNum = stuNum;
    }

    public int getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(int teaNum) {
        this.teaNum = teaNum;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getCtime() {
        return Ctime;
    }

    public void setCtime(int ctime) {
        Ctime = ctime;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
