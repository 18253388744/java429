package com.wdsjol.dao;

import com.wdsjol.entity.Sex;

import java.util.List;
import java.util.Map;

public interface SexDao {
    int add(Sex sex);

    int update(Sex sex);

    int delete(int id);

    Sex findById(int id);

    List<Sex> findAllList(Map<String,Object> param);
}
