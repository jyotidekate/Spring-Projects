package com.springcore.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/autowire/autoconfig.xml");
		Emp emp = context.getBean("emp1", Emp.class); 					// we don't need to do type casting by writing like this
		System.out.println(emp);
	}

}
