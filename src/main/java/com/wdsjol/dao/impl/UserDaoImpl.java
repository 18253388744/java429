package com.wdsjol.dao.impl;

import com.wdsjol.dao.UserDao;
import com.wdsjol.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into user  (phone,mima,username,sex,data ) values (?,?,?,?,? )",
               user.getPhone(),user.getMima(),user.getUsername(),user.getSex(),user.getData());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE  user  SET phone=?,mima=?,username=?,sex=?,data=?"
                        +" where id=?",
                user.getPhone(),user.getMima(),user.getUsername(),user.getSex(),user.getData(),
                user.getId())
                ;
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from user where id=?",id);
    }

    @Override
    public User findById(int id) {
        List<User> list = jdbcTemplate.query("select * from user where id=?", new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
        if(list!=null && list.size()>0){
            User user = list.get(0);
            return user;
        }else{
            return null;
        }
    }
    public User findByPhone(String phone) {
        List<User> list = jdbcTemplate.query("select * from user where phone=?", new Object[]{phone}, new BeanPropertyRowMapper<User>(User.class));
        if(list!=null && list.size()>0){
            User user = list.get(0);
            return user;
        }else{
            return null;
        }
    }

    @Override
    public List<User> findAllList(Map<String,Object> params) {
        List<User> list = jdbcTemplate.query("select * from user", new Object[]{}, new BeanPropertyRowMapper<User>(User.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
