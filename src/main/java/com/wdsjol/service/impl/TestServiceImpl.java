package com.wdsjol.service.impl;


import com.wdsjol.config.SpringConfig;
import com.wdsjol.dao.impl.UserTypeDaoImpl;
import com.wdsjol.entity.UserType;
import com.wdsjol.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public void test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = (JdbcTemplate)app.getBean("jdbcTemplate");
        UserTypeDaoImpl userjdbc = app.getBean(UserTypeDaoImpl.class);

        UserType userType = userjdbc.findById(1);
        System.out.println(userType.getTypename());
    }
}
