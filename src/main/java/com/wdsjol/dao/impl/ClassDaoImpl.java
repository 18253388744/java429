package com.wdsjol.dao.impl;

import com.wdsjol.dao.ClasssDao;
import com.wdsjol.entity.Classs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ClassDaoImpl implements ClasssDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Classs classs) {
        return jdbcTemplate.update("insert into classs  (classid,classname ) values (?,? )",
                classs.getClassid(),classs.getClassname());
    }

    @Override
    public int update(Classs classs) {
        return jdbcTemplate.update("UPDATE  classs  SET classname=?"
                        +" where classid=?",
                classs.getClassname(),
                classs.getClassid()
        );
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from classs where classid=?",id);
    }

    @Override
    public Classs findById(int id) {
        List<Classs> list = jdbcTemplate.query("select * from classs where classid=?", new Object[]{id}, new BeanPropertyRowMapper<Classs>(Classs.class));
        if(list!=null && list.size()>0){
            Classs classs = list.get(0);
            return classs;
        }else{
            return null;
        }
    }

    @Override
    public List<Classs> findAllList(Map<String,Object> ...params) {
        List<Classs> list = jdbcTemplate.query("select * from classs", new Object[]{}, new BeanPropertyRowMapper<Classs>(Classs.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    public int getCount() {
        int i = jdbcTemplate.queryForObject("select count(1) from classs", Integer.class);
        return i;

    }

}
