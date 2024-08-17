package com.springcore.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/constructorinjection/ciconfig.xml");
		Person person = (Person) context.getBean("person");
		System.out.println(person);
		
		Addition addition = (Addition) context.getBean("add");
		addition.doSum();
	}

}
