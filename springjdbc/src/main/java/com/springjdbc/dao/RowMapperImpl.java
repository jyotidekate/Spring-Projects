package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entites.Student;

public class RowMapperImpl implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt(1)); 				// In DB first column is for Id
		student.setName(rs.getString(2));			// In DB second column is for Name	
		student.setCity(rs.getString(3));			// In DB third column is for City
		return student;
	}

}

// <T> means which type of object you are dealing & if you are not mentioning any thing in that case it'll consider it as 
// Object class type of object.
// From ResultSet we have taken out data & sended to the Student class object & then we have return that object.