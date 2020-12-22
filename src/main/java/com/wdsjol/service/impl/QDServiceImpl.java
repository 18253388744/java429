package com.wdsjol.service.impl;


import com.wdsjol.dao.impl.QDDaoImpl;
import com.wdsjol.entity.QD;
import com.wdsjol.service.QDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QDServiceImpl implements QDService {
    @Autowired
    QDDaoImpl qdDao;


    @Override
    public String getInfo(String phone) {
       QD qd =  qdDao.getInfo(phone);
       if (qd!=null){
           //return qd.toString();
//           Qday(qd.getA1(),1);
           return qd.hqday();

       }
        return "";
    }

    @Override
    public int qd(String phone) {
        return 0;
    }
    public int Qday(int a,int x){
        if (a==1){
            return x;
        }else {
            return 0;
        }

    }
}
