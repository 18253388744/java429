package com.wdsjol.dao.impl;

import com.wdsjol.dao.AdminUserDao;
import com.wdsjol.entity.admin.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AdminUserDaoImpl implements AdminUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(AdminUser adminUser) {
        return jdbcTemplate.update("insert into admin_user  (id,name,mima ) values (?,?,? )",
                adminUser.getId(),adminUser.getName(),adminUser.getMima());
    }

    @Override
    public int update(AdminUser adminUser) {
        return jdbcTemplate.update("UPDATE  admin_user  SET name=?,mima=?"
                        +" where id=?",
                adminUser.getName(),adminUser.getMima(),
                adminUser.getId()
        );
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from admin_user where id=?",id);
    }

    @Override
    public AdminUser findById(int id) {
        List<AdminUser> list = jdbcTemplate.query("select * from admin_user where id=?", new Object[]{id}, new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
        if(list!=null && list.size()>0){
            AdminUser adminUser = list.get(0);
            return adminUser;
        }else{
            return null;
        }
    }

    @Override
    public List<AdminUser> findAllList(Map<String,Object> params) {
        List<AdminUser> list = jdbcTemplate.query("select * from admin_user", new Object[]{}, new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    public AdminUser findByNameMima(String name,String mima) {
        List<AdminUser> list = jdbcTemplate.query("select * from admin_user where name=? and mima=?", new Object[]{name,mima}, new BeanPropertyRowMapper<AdminUser>(AdminUser.class));
        if(list!=null && list.size()>0){
            AdminUser adminUser = list.get(0);
            return adminUser;
        }else{
            return null;
        }
    }
    public int getCount() {
        int i = jdbcTemplate.queryForObject("select count(1) from admin_user", Integer.class);
            return i;

    }

}