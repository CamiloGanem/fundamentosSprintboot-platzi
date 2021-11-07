package com.fundamentosplatzi.fundamentosspringboot.fundamentos;

import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.component.ComponentImplement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printwithDependency();

	}
}
