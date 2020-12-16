package com.wdsjol.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdsjol.dao.ZyDao;
import com.wdsjol.dao.impl.ClassDaoImpl;
import com.wdsjol.dao.impl.StudentUserDAOImpl;
import com.wdsjol.dao.impl.TeacherUserDaoImpl;
import com.wdsjol.dto.AdminInfoDto;
import com.wdsjol.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    //{"classs":10,"student":100,"teacher":15,"zy":5}
    @Autowired
    AdminInfoDto adminInfo;
    @Autowired
    private ClassDaoImpl classDao;
    @Autowired
    private ZyDao zyDao;
    @Autowired
    private TeacherUserDaoImpl teacherUserDao;
    @Autowired
    private StudentUserDAOImpl studentUserDAO;
    @Override
    public String getInfo() {
        adminInfo.setStudent(studentUserDAO.getCount());
        adminInfo.setTeacher(teacherUserDao.getCount());
        adminInfo.setClasss(classDao.getCount());
        adminInfo.setZy(zyDao.getCount());
        return JSON.toJSONString(adminInfo);
    }


}
