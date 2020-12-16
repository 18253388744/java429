package com.wdsjol.service;

import com.wdsjol.entity.admin.AdminUser;

public interface SetPasswordService {
    int setPassworld(AdminUser adminUser, String name,String mima);
}
