package com.wdsjol.service;

import com.wdsjol.entity.StudentUser;

public interface StuCzService {
    int del(int id);
    int add(String name,Integer classid,String birthday,Integer sexid,Integer zyid,String tel,String text);
    int update(int id,String zd,String nr);


}
