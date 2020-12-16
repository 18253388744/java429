package com.wdsjol.dao.impl;

import com.wdsjol.dao.ZyDao;
import com.wdsjol.entity.Zy;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository
public class ZyDaoImpl implements ZyDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Zy zy) {
        return jdbcTemplate.update("insert into zy  (zyid,zy ) values (?,? )",
                zy.getZyid(),zy.getZy());
    }

    @Override
    public int update(Zy zy) {
        return jdbcTemplate.update("UPDATE  zy  SET zy=?"
                        +" where zyid=?",
                zy.getZy(),
                zy.getZyid()
        );
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from zy where zyid=?",id);
    }

    @Override
    public Zy findById(int id) {
        List<Zy> list = jdbcTemplate.query("select * from zy where zyid=?", new Object[]{id}, new BeanPropertyRowMapper<Zy>(Zy.class));
        if(list!=null && list.size()>0){
            Zy zy = list.get(0);
            return zy;
        }else{
            return null;
        }
    }

    @Override
    public List<Zy> findAllList() {
        List<Zy> list = jdbcTemplate.query("select * from zy", new Object[]{}, new BeanPropertyRowMapper<Zy>(Zy.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    public int getCount() {
        int i = jdbcTemplate.queryForObject("select count(1) from zy", Integer.class);
        return i;

    }
}
