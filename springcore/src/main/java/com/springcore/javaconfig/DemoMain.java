package com.springcore.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class); // Here we'll pass our configuration class
		//Student student = context.getBean("firststudent", Student.class);
		//Student student = context.getBean("getStudent", Student.class);
		//Student student = context.getBean("temp", Student.class);
		Student student = context.getBean("con", Student.class);
		System.out.println(student);
		student.study();
	}

}

// ClassPathXmlApplicationContext -> xml file ki configuration ko handle krta hai 
// AnnotationConfigApplicationContext -> java ke through jo bhi apne configuration kiya hoga wo sab handle krenga 