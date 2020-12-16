package com.wdsjol.service;

import com.wdsjol.entity.admin.AdminUser;

public interface LoginService {
    AdminUser login(String name ,String mima);
}
