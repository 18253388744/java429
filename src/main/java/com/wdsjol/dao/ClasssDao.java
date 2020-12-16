package com.wdsjol.dao;

import com.wdsjol.entity.Classs;

import java.util.List;
import java.util.Map;

public interface ClasssDao {
    int add(Classs classs);

    int update(Classs classs);

    int delete(int id);

    Classs findById(int id);

    List<Classs> findAllList(Map<String,Object> ...param);

}
