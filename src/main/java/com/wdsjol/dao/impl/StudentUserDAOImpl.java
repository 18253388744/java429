package com.wdsjol.dao.impl;

import com.wdsjol.dao.StudentUserDAO;
import com.wdsjol.entity.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StudentUserDAOImpl implements StudentUserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(StudentUser studentUser) {
        return jdbcTemplate.update("insert into student_user  (name,classid,birthday,sexid,zyid,tel,text ) values (?,?,?,?,?,?,? )",
                studentUser.getName(),studentUser.getClassid(),studentUser.getBirthday(),studentUser.getSexid(),studentUser.getZyid(),studentUser.getTel(),studentUser.getText());
    }

    @Override
    public int update(StudentUser studentUser) {
        return jdbcTemplate.update("UPDATE  student_user  SET name=?,classid=?,birthday=?,sexid=?,zyid=?,tel=?,text=?"
                        +" where id=?",
                studentUser.getName(),studentUser.getClassid(),studentUser.getBirthday(),studentUser.getSexid(),studentUser.getZyid(),studentUser.getTel(),studentUser.getText(),
                studentUser.getId()
        );
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from student_user where id=?",id);
    }

    @Override
    public StudentUser findById(int id) {
        List<StudentUser> list = jdbcTemplate.query("select * from student_user where id=?", new Object[]{id}, new BeanPropertyRowMapper<StudentUser>(StudentUser.class));
        if(list!=null && list.size()>0){
            StudentUser studentUser = list.get(0);
            return studentUser;
        }else{
            return null;
        }
    }

    @Override
    public List<StudentUser> findAllList(Map<String,Object> param) {
        List<StudentUser> list = jdbcTemplate.query("select * from student_user", new Object[]{}, new BeanPropertyRowMapper<StudentUser>(StudentUser.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public List<StudentUser> getFyData(int a, int b) {
        List<StudentUser> list = jdbcTemplate.query("select * from student_user LIMIT ?,?", new Object[]{a,b}, new BeanPropertyRowMapper<StudentUser>(StudentUser.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public List<StudentUser> getTjAllList(String sql) {
        List<StudentUser> list = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<StudentUser>(StudentUser.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    public int getCount() {
        int i = jdbcTemplate.queryForObject("select count(1) from student_user", Integer.class);
        return i;

    }

}
