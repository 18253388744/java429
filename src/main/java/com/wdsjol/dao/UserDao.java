package com.wdsjol.dao;

import com.wdsjol.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int add(User user);

    int update(User user);

    int delete(int id);

    User findById(int id);

    List<User> findAllList(Map<String,Object> param);
}
