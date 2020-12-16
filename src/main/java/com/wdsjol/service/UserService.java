package com.wdsjol.service;

import com.wdsjol.entity.User;

public interface UserService {
    int add(String phone,String mina,String username,String sex,String data);
    User dl(String phone,String mina);

}
