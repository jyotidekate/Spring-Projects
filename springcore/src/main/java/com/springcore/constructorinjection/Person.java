package com.springcore.constructorinjection;

public class Person {
	
	private String name;
	private int personId;
	private Certificate certificate;
	
	public Person(String name, int personId, Certificate certificate) {
		this.name = name;
		this.personId = personId;
		this.certificate = certificate;
	}

	@Override
	public String toString() {
		//return "Person [name=" + name + ", personId=" + personId + "]";
		return this.name+" : "+this.personId+"{ "+this.certificate.name+" }";
	}

}
