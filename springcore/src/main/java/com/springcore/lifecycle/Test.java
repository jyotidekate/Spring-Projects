package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/lifecycleconfig.xml");
		
		// We have to enable pre shutdown hook due to this context we will call the methods 
		context.registerShutdownHook(); // Means i have tell container that whenever i have to destroy object you'll call destroy()
		// The method i.e. destroy() which i have maintion in config.xml file call this
		
		Samosa samosa = (Samosa) context.getBean("s1");
		System.out.println(samosa);
		
		System.out.println("--------------------------------------------");
		
		Pepsi pepsi = (Pepsi) context.getBean("p1");
		System.out.println(pepsi);
		
		System.out.println("--------------------------------------------");
		
		Movie movie = (Movie) context.getBean("m1");
		System.out.println(movie);
	}

}

// If you want to run/ call destroy() compulsory you have to run this method i.e. registerShutdownHook()