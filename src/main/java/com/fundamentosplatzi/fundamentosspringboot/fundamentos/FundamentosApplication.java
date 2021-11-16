package com.fundamentosplatzi.fundamentosspringboot.fundamentos;

import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.component.ComponentImplement;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.entity.User;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.fundamentosspringboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
	//	EjemplosAnteriores();
	saveUserInDataBase();
		getInformationJPQLFromUser();
	}

	private void getInformationJPQLFromUser(){
		LOGGER.info("Usuario con el metodo getInformationJPQLFromUser" +
				userRepository.findByUserEmail("Daniela@gmail.com")
						.orElseThrow(()-> new RuntimeException("No se encontro el usuario")));

		userRepository.findAndSort("Cam", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con metodo sort" + user));
	}

	private void saveUserInDataBase(){
		User user1 = new User("Jonh", "jonh@gmail.com", LocalDate.of(2021, 11, 5));
		User user2 = new User("Maria", "Maria@gmail.com", LocalDate.of(2021, 5, 5));
		User user3 = new User("Daniela", "Daniela@gmail.com", LocalDate.of(2021, 11, 22));
		User user4 = new User("Camilo", "Camilo@gmail.com", LocalDate.of(2021, 11, 5));
		User user5 = new User("Pedro", "Pedro@gmail.com", LocalDate.of(2021, 11, 5));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5);
		list.stream().forEach(userRepository::save);
	}

	private void EjemplosAnteriores(){
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
