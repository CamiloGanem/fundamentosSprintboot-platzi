package com.fundamentosplatzi.fundamentosspringboot.fundamentos.configuration;

import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationSuma(){
        return new MyOperationImplement();
    }

    @Bean MyBeanWithDependency beanOperationWithDependecy(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
