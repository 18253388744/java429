package com.wdsjol.service.impl;

import com.wdsjol.dao.UserDao;
import com.wdsjol.dao.impl.UserDaoImpl;
import com.wdsjol.entity.User;
import com.wdsjol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDaoImpl userDao;


    @Override
    public int add(String phone, String mina, String username, String sex, String data) {
        User user = new User();
        user.setPhone(phone);
        user.setMima(mina);
        user.setUsername(username);
        user.setSex(Integer.parseInt(sex));
        user.setData(data);
        return userDao.add(user);
    }
}
