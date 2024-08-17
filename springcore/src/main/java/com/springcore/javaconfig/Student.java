package com.springcore.javaconfig;

import org.springframework.stereotype.Component;

/*@Component("firststudent")
public class Student {

	public void study() {
		System.out.println("Student is reading book...");
	}
	
}*/
 
// Instead of using @Component annotation to declare a bean now we'll use @Bean annotation for that same in JavaConfig.java class
public class Student {
	
	private Samosa samosa;

	public Samosa getSamosa() {
		return samosa;
	}

	public void setSamosa(Samosa samosa) {
		this.samosa = samosa;
	}
	
	public Student(Samosa samosa) {
		super();
		this.samosa = samosa;
	}

	public void study() {
		this.samosa.display();
		System.out.println("Student is reading book...");
	}
	
}

// Bean Configuration -
// 1. By using bean tag in xml file
// 2. @Component annotation
// 3. @Bean annotation