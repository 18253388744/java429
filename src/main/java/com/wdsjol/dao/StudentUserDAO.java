package com.wdsjol.dao;

import com.wdsjol.entity.StudentUser;

import java.util.List;
import java.util.Map;

public interface StudentUserDAO {
    int add(StudentUser studentUser);

    int update(StudentUser studentUser);

    int delete(int id);

    StudentUser findById(int id);

    List<StudentUser> findAllList(Map<String,Object> param);
    List<StudentUser> getFyData(int a,int b);
    List<StudentUser> getTjAllList(String sql);
}
