package com.wdsjol.service.impl;

import com.wdsjol.dao.impl.AdminUserDaoImpl;
import com.wdsjol.entity.admin.AdminUser;
import com.wdsjol.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminUserDaoImpl adminUserDao;
    private AdminUser adminUser;

    @Override
    public AdminUser login(String name,String mima) {
        adminUser = adminUserDao.findByNameMima(name,mima);
            return adminUser;
    }
}
