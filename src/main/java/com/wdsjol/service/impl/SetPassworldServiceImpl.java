package com.wdsjol.service.impl;

import com.wdsjol.dao.impl.AdminUserDaoImpl;
import com.wdsjol.entity.admin.AdminUser;
import com.wdsjol.service.SetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetPassworldServiceImpl implements SetPasswordService {
    @Autowired
    private AdminUserDaoImpl adminUserDao;
    @Override
    public int setPassworld(AdminUser adminUser, String name, String mima) {
        if(name.equals("")||mima.equals("")){
            return 0;
        }
        adminUser.setName(name);
        adminUser.setMima(mima);
        return adminUserDao.update(adminUser);
    }
}
