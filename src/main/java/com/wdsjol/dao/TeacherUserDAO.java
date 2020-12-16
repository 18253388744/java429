package com.wdsjol.dao;

import com.wdsjol.entity.TeacherUser;

import java.util.List;
import java.util.Map;

public interface TeacherUserDAO {
    int add(TeacherUser teacherUser);

    int update(TeacherUser teacherUser);

    int delete(int id);

    TeacherUser findById(int id);

    List<TeacherUser> findAllList(Map<String,Object> param);
}
