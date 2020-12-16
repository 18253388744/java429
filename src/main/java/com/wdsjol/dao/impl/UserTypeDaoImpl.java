package com.wdsjol.dao.impl;

import com.wdsjol.dao.UserTypeDAO;
import com.wdsjol.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class UserTypeDaoImpl implements UserTypeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(UserType userType) {
        return jdbcTemplate.update("insert into user_type  (typeno,typename ) values (?,? )",
                userType.getTypeno(),userType.getTypename());
    }

    @Override
    public int update(UserType userType) {
        return jdbcTemplate.update("UPDATE  user_type  SET typename=?"
                        +" where typeno=?",
                userType.getTypename(),
                userType.getTypeno()
        );
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from user_type where typeno=?",id);
    }

    @Override
    public UserType findById(int id) {
        List<UserType> list = jdbcTemplate.query("select * from user_type where typeno=?", new Object[]{id}, new BeanPropertyRowMapper<UserType>(UserType.class));
        if(list!=null && list.size()>0){
            UserType userType = list.get(0);
            return userType;
        }else{
            return null;
        }
    }

    @Override
    public List<UserType> findAllList(Map<String,Object> params) {
        List<UserType> list = jdbcTemplate.query("select * from user_type", new Object[]{}, new BeanPropertyRowMapper<UserType>(UserType.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    public int getCount() {
        int i = jdbcTemplate.queryForObject("select count(1) from user_type", Integer.class);
        return i;

    }
}
