package com.springjdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entites.Student;

/**
 * Hello world!
 *
 */

public class App {

	// This Is For XML Configuration
	/*
	 * public static void main( String[] args ) { System.out.println(
	 * "My Program Started ..." );
	 * 
	 * // Spring JDBC -> JdbcTemplate ApplicationContext context = new
	 * ClassPathXmlApplicationContext("com/springjdbc/config.xml");
	 * 
	 * 
	 * // Below code is not recommended & if you are not using com.springjdbc.doa
	 * this package than only go with below code JdbcTemplate template =
	 * context.getBean("jdbcTemplate", JdbcTemplate.class);
	 * 
	 * // Insert Query String query =
	 * "insert into student (id, name, city) values (?, ?, ?)"; // Fire the query
	 * int result = template.update(query, 456, "Subhash Dekate", "Mumbai");
	 * System.out.println("Number of record inserted ..."+result);
	 * 
	 * 
	 * StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
	 * 
	 * // 1. INSERT
	 * 
	 * Student student = new Student(); student.setId(168);
	 * student.setName("Prachi Mohadikar"); student.setCity("Goa");
	 * 
	 * int result = studentDao.insert(student);
	 * System.out.println("Student Added..."+result);
	 * 
	 * 
	 * // 2. UPDATE
	 * 
	 * Student student = new Student(); student.setId(22);
	 * student.setName("Khushi Dekate"); student.setCity("Pune");
	 * 
	 * int result = studentDao.change(student);
	 * System.out.println("Data Changed..."+result);
	 * 
	 * 
	 * // 3. DELETE
	 * 
	 * int result = studentDao.delete(456); System.out.println("Deleted..."+result);
	 * 
	 * 
	 * 
	 * // Create a Scanner object for reading user input Scanner scanner = new
	 * Scanner(System.in); System.out.print("Enter the student ID to delete : ");
	 * int studentId = scanner.nextInt(); int result = studentDao.delete(studentId);
	 * //System.out.println("Deleted..."+result);
	 * System.out.println("Deleted student with ID "+studentId); scanner.close(); //
	 * Close the scanner
	 * 
	 * 
	 * // 4. We are going to get single object
	 * 
	 * Student student = studentDao.getStudent(168); System.out.println(student);
	 * 
	 * 
	 * // 5. We are going to get multiple objects
	 * 
	 * List<Student> allStudent = studentDao.getAllStudent(); for(Student student :
	 * allStudent) { System.out.println(student); }
	 * 
	 * }
	 */
	
	// This Is For JAVA Configuration
	public static void main( String[] args )
    {
        System.out.println( "My Program Started ..." );
        
        // Spring JDBC -> JdbcTemplate
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        /*
        // Below code is not recommended & if you are not using com.springjdbc.doa this package than only go with below code
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        
        // Insert Query
        String query = "insert into student (id, name, city) values (?, ?, ?)";
        // Fire the query
        int result = template.update(query, 456, "Subhash Dekate", "Mumbai");
        System.out.println("Number of record inserted ..."+result);
        */
        
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        // 1. INSERT 
        /*
        Student student = new Student();
        student.setId(168);
        student.setName("Prachi Mohadikar");
        student.setCity("Goa");
        
        int result = studentDao.insert(student);
        System.out.println("Student Added..."+result);
        */
        
        // 2. UPDATE
        /*
        Student student = new Student();
        student.setId(22);
        student.setName("Khushi Dekate");
        student.setCity("Pune");
        
        int result = studentDao.change(student);
        System.out.println("Data Changed..."+result);
        */
        
        // 3. DELETE
        /*
        int result = studentDao.delete(456);
        System.out.println("Deleted..."+result);
        */
        
        /*
        // Create a Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student ID to delete : ");
        int studentId = scanner.nextInt();
        int result = studentDao.delete(studentId);
        //System.out.println("Deleted..."+result);
        System.out.println("Deleted student with ID "+studentId);
        scanner.close();											// Close the scanner
        */
        
        // 4. We are going to get single object
        /*
        Student student = studentDao.getStudent(168);
        System.out.println(student);
        */
        
        // 5. We are going to get multiple objects
        List<Student> allStudent = studentDao.getAllStudent();
        for(Student student : allStudent) {
        	System.out.println(student);
        }
       
    }

}

// In this App.java we have use xml configuration file & java configuration class it's up to us what we want to use as per our
// need. The only differences is in one line & rest code is same in both -
// ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/config.xml"); -> XML Configuration
// ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);		 -> JAVA Configuration class
