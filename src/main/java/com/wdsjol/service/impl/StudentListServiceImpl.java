package com.wdsjol.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdsjol.dao.StudentUserDAO;
import com.wdsjol.dao.impl.ClassDaoImpl;
import com.wdsjol.dao.impl.SexDaoImpl;
import com.wdsjol.dao.impl.StudentUserDAOImpl;
import com.wdsjol.dao.impl.ZyDaoImpl;
import com.wdsjol.dto.LayuiJson;
import com.wdsjol.dto.StudentListDto;
import com.wdsjol.entity.StudentUser;
import com.wdsjol.service.StudentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentListServiceImpl implements StudentListService {
    @Autowired
    StudentUserDAOImpl studentUserDAO;
    @Autowired
    SexDaoImpl sexDao;
    @Autowired
    ZyDaoImpl zyDao;
    @Autowired
    ClassDaoImpl classDao;
    @Autowired
    LayuiJson layuiJson;
    @Override
    public String getInfo(int m,int n) {

        List<StudentUser> fyData = studentUserDAO.getFyData(m, n); //获取studentUser
        List<StudentListDto> Student =new ArrayList<StudentListDto>();

        for(int i = 0 ; i < fyData.size() ; i++) {
            StudentListDto studentListDto = new StudentListDto();
            studentListDto.setId(fyData.get(i).getId());
            studentListDto.setName(fyData.get(i).getName());
            studentListDto.setClassName(classDao.findById(fyData.get(i).getClassid()).getClassname());
            studentListDto.setSex(sexDao.findById(fyData.get(i).getSexid()).getSex());
            studentListDto.setBirthday(fyData.get(i).getBirthday());
            studentListDto.setZy(zyDao.findById(fyData.get(i).getZyid()).getZy());
            studentListDto.setTel(fyData.get(i).getTel());
            studentListDto.setText(fyData.get(i).getText());
            Student.add(studentListDto);
        }
        layuiJson.setData(Student);
        return JSON.toJSONString(layuiJson);

    }

    @Override
    public String getInfoTj(String name, String zy, String classs, String sex) {
        String sqls="SELECT * FROM `student_user` WHERE 1=1";
        if (!"".equals(name)){
            sqls= sqls+" AND `name`= '"+name+"'";
        }
        if (!"".equals(zy)){
            sqls= sqls+" AND `zyid`= "+zy;
        }
        if (!"".equals(classs)){
            sqls= sqls+" AND `classid`= "+classs;
        }
        if (!"".equals(sex)){
            sqls= sqls+" AND `sexid`= "+sex;
        }
        List<StudentUser> fyData = studentUserDAO.getTjAllList(sqls);
        List<StudentListDto> Student =new ArrayList<StudentListDto>();

        for(int i = 0 ; i < fyData.size() ; i++) {
            StudentListDto studentListDto = new StudentListDto();
            studentListDto.setId(fyData.get(i).getId());
            studentListDto.setName(fyData.get(i).getName());
            studentListDto.setClassName(classDao.findById(fyData.get(i).getClassid()).getClassname());
            studentListDto.setSex(sexDao.findById(fyData.get(i).getSexid()).getSex());
            studentListDto.setBirthday(fyData.get(i).getBirthday());
            studentListDto.setZy(zyDao.findById(fyData.get(i).getZyid()).getZy());
            studentListDto.setTel(fyData.get(i).getTel());
            studentListDto.setText(fyData.get(i).getText());
            Student.add(studentListDto);
        }
        layuiJson.setData(Student);
        return JSON.toJSONString(layuiJson);

    }


}
