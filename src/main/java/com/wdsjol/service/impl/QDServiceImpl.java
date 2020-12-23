package com.wdsjol.service.impl;


import com.wdsjol.dao.impl.QDDaoImpl;
import com.wdsjol.entity.QD;
import com.wdsjol.service.QDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class QDServiceImpl implements QDService {
    @Autowired
    QDDaoImpl qdDao;


    @Override
    public String getInfo(String phone) {
       QD qd =  qdDao.getInfo(phone);
       if (qd!=null){
           return qd.hqday();
       }
        return "";
    }

    @Override
    public int qd(String phone) {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        return qdDao.qd(phone,day);
    }

}
