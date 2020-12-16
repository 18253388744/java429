package com.wdsjol.dao.impl;

import com.wdsjol.dao.SexDao;
import com.wdsjol.entity.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SexDaoImpl implements SexDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Sex sex) {
        return jdbcTemplate.update("insert into sex  (sexid,sex ) values (?,? )",
                sex.getSexid(),sex.getSex());
    }

    @Override
    public int update(Sex sex) {
        return jdbcTemplate.update("UPDATE  sex  SET sex=?"
                        +" where sexid=?",
                sex.getSex(),
                sex.getSexid());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from sex where sexid=?",id);
    }

    @Override
    public Sex findById(int id) {
        List<Sex> list = jdbcTemplate.query("select * from sex where sexid=?", new Object[]{id}, new BeanPropertyRowMapper<Sex>(Sex.class));
        if(list!=null && list.size()>0){
            Sex sex = list.get(0);
            return sex;
        }else{
            return null;
        }
    }

    @Override
    public List<Sex> findAllList(Map<String,Object> params) {
        List<Sex> list = jdbcTemplate.query("select * from sex", new Object[]{}, new BeanPropertyRowMapper<Sex>(Sex.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
