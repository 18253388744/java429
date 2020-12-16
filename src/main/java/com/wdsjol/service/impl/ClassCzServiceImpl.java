package com.wdsjol.service.impl;


import com.alibaba.fastjson.JSON;
import com.wdsjol.dao.impl.ClassDaoImpl;
import com.wdsjol.entity.Classs;
import com.wdsjol.service.ClassCzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassCzServiceImpl implements ClassCzService {

    @Autowired
    ClassDaoImpl classDao;

    @Override
    public String getInfo() {
        List<Classs> allList = classDao.findAllList();
        return JSON.toJSONString(allList);
    }

    @Override
    public int setClass() {
        return 0;
    }

    @Override
    public int delClass() {
        return 0;
    }
}
