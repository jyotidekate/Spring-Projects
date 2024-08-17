package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// Implementing Lifecycle methods of spring bean using Annotations
public class Movie {

	private String movieName;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + "]";
	}
	
	@PostConstruct
	public void start() {
		System.out.println("Stating Init Method");
	}
	
	@PreDestroy
	public void Destroy() {
		System.out.println("Ending Destroy Method");
	}
	
}

// @PostConstruct & @PreDestroy this two annotation by default are disable, now we have to make it enable in lifecycleconfig.xml file
