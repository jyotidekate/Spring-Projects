package com.springorm.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// 1. Save Student Data (Insert)
	@Transactional												// Due to this right operation will get enable in hibernate case
	public int insert(Student student) {
		//int i = (int) this.hibernateTemplate.save(student);
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	// 2. Get The Single Data Or Object Of Student
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId); 		// In parameter you have to pass which class object you want & second you'll pass studentId
		return student;
	}
	
	// 3. Get All Student Data
	public List<Student> getAllStudents(){
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	// 4. Delete Student Data
	@Transactional	
	public boolean deleteStudent(int studentId) {
		// First we need to get the object
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		if(student != null) {
			this.hibernateTemplate.delete(student);
			return true;
		}else {
			return false;
		}
	}
	
	// 5. Updating Student Data
	@Transactional	
	public 	void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
}

// When you are getting data in that case you don't need to use @Transactional annotation
