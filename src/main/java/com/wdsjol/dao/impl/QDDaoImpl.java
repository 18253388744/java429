package com.wdsjol.dao.impl;

import com.wdsjol.dao.QDDao;

import com.wdsjol.entity.QD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class QDDaoImpl implements QDDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public QD getInfo(String phone) {
        List<QD> qdList = jdbcTemplate.query("select * from qd WHERE phone = ?", new Object[]{phone}, new BeanPropertyRowMapper<QD>(QD.class));
        if(qdList!=null && qdList.size()>0){
            QD qd = qdList.get(0);
            return qd;
        }else{
            newQd(phone);   //新建用户签到
            return null;
        }
    }

    @Override
    public int qd(String phone, int day) {
        String days ="a"+day;
        String sql = "UPDATE `qd` SET "+days+"='1' WHERE phone= ?";
        return jdbcTemplate.update(sql,phone);
    }
    public int newQd(String phone) {
        String sql = "INSERT INTO `qd` (`phone`) VALUES (?)";
        return jdbcTemplate.update(sql,phone);
    }

}
