package com.wdsjol.dao;

import com.wdsjol.entity.QD;



public interface QDDao {
    QD getInfo(String phone);
    int qd(String phone,String day);



}
