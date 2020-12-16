package com.wdsjol.dao.impl;

import com.wdsjol.dao.TeacherUserDAO;
import com.wdsjol.entity.TeacherUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TeacherUserDaoImpl implements TeacherUserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(TeacherUser teacherUser) {
        return jdbcTemplate.update("insert into teacher_user  (id,name,mima,sexid,zyid,classid,text ) values (?,?,?,?,?,?,? )",
                teacherUser.getId(),teacherUser.getName(),teacherUser.getMima(),teacherUser.getSexid(),teacherUser.getZyid(),teacherUser.getClassid(),teacherUser.getText());
    }

    @Override
    public int update(TeacherUser teacherUser) {
        return jdbcTemplate.update("UPDATE  teacher_user  SET name=?,mima=?,sexid=?,zyid=?,classid=?,text=?"
                        +" where id=?",
                teacherUser.getName(),teacherUser.getMima(),teacherUser.getSexid(),teacherUser.getZyid(),teacherUser.getClassid(),teacherUser.getText(),
                teacherUser.getId()
        );
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from teacher_user where id=?",id);
    }

    @Override
    public TeacherUser findById(int id) {
        List<TeacherUser> list = jdbcTemplate.query("select * from teacher_user where id=?", new Object[]{id}, new BeanPropertyRowMapper<TeacherUser>(TeacherUser.class));
        if(list!=null && list.size()>0){
            TeacherUser teacherUser = list.get(0);
            return teacherUser;
        }else{
            return null;
        }
    }

    @Override
    public List<TeacherUser> findAllList(Map<String,Object> params) {
        List<TeacherUser> list = jdbcTemplate.query("select * from teacher_user", new Object[]{}, new BeanPropertyRowMapper<TeacherUser>(TeacherUser.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    public int getCount() {
        int i = jdbcTemplate.queryForObject("select count(1) from teacher_user", Integer.class);
        return i;

    }

}
