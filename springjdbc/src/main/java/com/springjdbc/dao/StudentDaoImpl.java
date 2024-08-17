package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entites.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired										// This annotation you'll use when you are creating bean wth of @Component annotation otherwise don't use this annotation for this program
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		// INSERT QUERY
		String query = "insert into student (id, name, city) values (?, ?, ?)";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	@Override
	public int change(Student student) {
		// UPDATE QUERY
		String query = "update student set name=?, city=? where id=?";
		int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	@Override
	public int delete(int studentId) {
		// DELETE QUERY
		String query = "delete from student where id=?";
		int result = this.jdbcTemplate.update(query, studentId);
		return result;
	}

	// Here we have separately created RowMapper Implementation Class [Always use this approach it can be used multiple time anywhere]
	@Override
	public Student getStudent(int studentId) {
		// SELECT -> single student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();		// We can take parent class variable to store the child class object
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	/*
	// Here we are using Anonymous Class for RowMapper [This approach is applicable inside this method only you can't use outside the method]
	@Override
	public Student getStudent(int studentId) {
		// SELECT -> single student data
		String query = "select * from student where id=?";
		Student student = this.jdbcTemplate.queryForObject(query, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1)); 				// In DB first column is for Id
				student.setName(rs.getString(2));			// In DB second column is for Name	
				student.setCity(rs.getString(3));			// In DB third column is for City
				return student;
			}
			
		}, studentId);
		return student;
	}
	*/
	
	@Override
	public List<Student> getAllStudent() {
		// SELECT -> multiple student data
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
	
}
