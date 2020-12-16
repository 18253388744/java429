package com.wdsjol.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//核心配置类
@Configuration
//<context:component-scan base-package="com.wdsjol"/>
@ComponentScan("com.wdsjol")
@Import({JdbcConfig.class,JdbcTConfig.class})
public class SpringConfig {
}
