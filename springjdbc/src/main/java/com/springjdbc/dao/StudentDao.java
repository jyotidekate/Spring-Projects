package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entites.Student;

public interface StudentDao {

	// 1. Insert
	public int insert(Student student);
	
	// 2. Update
	public int change(Student student);
	
	// 3. DELETE
	public int delete(int studentId);
	
	// 4. SELECT -> Single Object
	public Student getStudent(int studentId);
	
	// 5. SELECT -> Multiple Object
	public List<Student> getAllStudent();		// We'll not pass any parameter cause we want all objects 
	
}
