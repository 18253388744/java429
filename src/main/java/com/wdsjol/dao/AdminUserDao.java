package com.wdsjol.dao;

import com.wdsjol.entity.admin.AdminUser;

import java.util.List;
import java.util.Map;

public interface AdminUserDao {

    int add(AdminUser adminUser);

    int update(AdminUser adminUser);

    int delete(int id);

    AdminUser findById(int id);

    List<AdminUser> findAllList(Map<String,Object> param);
}
