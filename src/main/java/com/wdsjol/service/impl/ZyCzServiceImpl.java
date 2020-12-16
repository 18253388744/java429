package com.wdsjol.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdsjol.dao.impl.ZyDaoImpl;
import com.wdsjol.dto.LayuiJson;
import com.wdsjol.entity.Zy;
import com.wdsjol.service.ZyCzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ZyCzServiceImpl implements ZyCzService {
    @Autowired
    ZyDaoImpl zyDao;
    @Autowired
    LayuiJson layuiJson;
    @Override
    public String getZyInfo() {
        List<Zy> allList = zyDao.findAllList();

        return JSON.toJSONString(allList);
    }

    @Override
    public int setZy(int id) {
        return 0;
    }

    @Override
    public int delZy(int id) {
        return 0;
    }
}
