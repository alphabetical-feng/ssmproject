package com.springmvc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;

/**
 * @author ：qmf
 * @date ：Created in 2019/10/14 19:23
 * @description：配置类
 * @modified By：
 */
//@Configuration
public class AppConfig {

    //@Bean
    public DruidDataSource getDateSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("");
        dataSource.setUsername("");
        dataSource.setPassword("");
//        dataSource.setInitialSize();
//        dataSource.setMaxActive();
        return null;
    }

    //@Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(getDateSource());
        return bean;
    }

}

