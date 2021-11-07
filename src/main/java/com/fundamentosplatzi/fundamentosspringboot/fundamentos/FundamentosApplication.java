package com.fundamentosplatzi.fundamentosspringboot.fundamentos;

import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.component.ComponentImplement;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.pojo.UserPojo;
import org.apache.catalina.User;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printwithDependency();
		System.out.println(myBeanWithProperties.funtion());
		System.out.printf(userPojo.getEmail() +" -" + userPojo.getPassword());
		try {
			//error
			int value = 10/0;
			LOGGER.debug("valor" + value);
		}catch (Exception e) {
			LOGGER.error("Esto es un error al dividir por cero+" + e.getMessage());
		}
	}
}
