package com.wdsjol.dao;

import com.wdsjol.entity.Zy;

import java.util.List;
import java.util.Map;

public interface ZyDao {
    int add(Zy zy);

    int update(Zy zy);

    int delete(int id);

    Zy findById(int id);

    List<Zy> findAllList();
    int getCount();
}
