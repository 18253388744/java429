package com.wdsjol.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdsjol.dao.impl.UserDaoImpl;
import com.wdsjol.entity.User;
import com.wdsjol.service.HomeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeInfoServiceImpl implements HomeInfoService {
    @Autowired
    UserDaoImpl userDao;
    @Override
    public String getInfo(String phone) {
        User user = userDao.findByPhone(phone);
        return JSON.toJSONString(user);
    }
}
