package com.wdsjol.dao;

import com.wdsjol.entity.UserType;

import java.util.List;
import java.util.Map;

public interface UserTypeDAO {
    int add(UserType userType);

    int update(UserType userType);

    int delete(int id);

    UserType findById(int id);

    List<UserType> findAllList(Map<String,Object> param);
}
