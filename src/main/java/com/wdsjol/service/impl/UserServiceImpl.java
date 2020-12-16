package com.wdsjol.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.wdsjol.dao.UserDao;
import com.wdsjol.dao.impl.UserDaoImpl;
import com.wdsjol.entity.User;
import com.wdsjol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
        if (userDao.findByPhone(phone)!=null){
            return 0;
        }
        return userDao.add(user);
    }

    @Override
    public User dl(String phone, String mina) {
        User user = userDao.dl(phone,mina);
        if (user!=null){

            return user;
        }else {
            return null;
        }
    }
}
