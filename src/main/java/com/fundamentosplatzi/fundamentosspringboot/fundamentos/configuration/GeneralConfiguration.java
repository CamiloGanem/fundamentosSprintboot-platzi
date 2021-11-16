package com.fundamentosplatzi.fundamentosspringboot.fundamentos.configuration;

import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connections.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String JdbcUrl;

    @Value("${driver}")
    private String Driver;

    @Value("${username}")
    private String UserName;

    @Value("${password}")
    private String Password;

    @Bean
    public MyBeanWithProperties funtion(){
        return new MyBeanWithPropertiesImplement(name, apellido);
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(Driver);
        dataSourceBuilder.url(JdbcUrl);
        dataSourceBuilder.username(UserName);
        dataSourceBuilder.password(Password);
        return dataSourceBuilder.build();
    }



}
