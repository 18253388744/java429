package com.wdsjol.service.impl;


import com.wdsjol.dao.impl.StudentUserDAOImpl;
import com.wdsjol.entity.StudentUser;
import com.wdsjol.service.StuCzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuCzServiceImpl implements StuCzService {
    @Autowired
    StudentUserDAOImpl studentUserDAO;

    @Override
    public int del(int id) {
        return studentUserDAO.delete(id);
    }

    @Override
    public int add(String name, Integer classid, String birthday, Integer sexid, Integer zyid, String tel, String text) {
        StudentUser studentUser = new StudentUser();
        studentUser.setName(name);
        studentUser.setClassid(classid);
        studentUser.setBirthday(birthday);
        studentUser.setSexid(sexid);
        studentUser.setZyid(zyid);
        studentUser.setTel(tel);
        studentUser.setText(text);
        return studentUserDAO.add(studentUser);
    }



    @Override
    public int update(int id,String zd,String nr) {
        //return studentUserDAO.update(studentUser);
        return 0;
    }
}
