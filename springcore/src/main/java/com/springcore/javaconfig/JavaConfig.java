package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*@Configuration
@ComponentScan(basePackages = "com.springcore.javaconfig")
public class JavaConfig {
	
	
}*/

@Configuration
public class JavaConfig {
	
	// This method will return object of your bean i.e. Student class object
	//@Bean
	@Bean(name = {"student", "temp", "con"})
	public Student getStudent() {
		// Creating new Student object
		Student student = new Student(getSamosa());		// We are injecting Samosa class object like this i.e. by method name
		return student;
	}
	
	@Bean 
	public Samosa getSamosa() {
		return new Samosa();
	}
}

// This class is handling all configuration it can be bean, component, etc through/by @Configuration annotation
// Basically this class work like our xml/configuration file 