package com.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        // 1. INSERT
        /*
        Student student = new Student(2, "Pooja Dekate", "Mumbai");
        int result = studentDao.insert(student);
        System.out.println("Data Saved..."+result);
        */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while(go) 
        {
        	System.out.println("Press 1 for adding new student");
            System.out.println("Press 2 for displying all students");
            System.out.println("Press 3 for getting detail of single student");
            System.out.println("Press 4 for deleting student");
            System.out.println("Press 5 for updating a student");
            System.out.println("Press 6 for exit");
            
            try {
            	int input = Integer.parseInt(br.readLine());
            	
            	switch(input)
            	{
            	case 1:
            		// Add a new student
            		System.out.println("Enter Student ID : ");
            		int id = Integer.parseInt(br.readLine());
            		
            		System.out.println("Enter Student Name : ");
            		String name = br.readLine();
            		
            		System.out.println("Enter Student City : ");
            		String city = br.readLine();
            		
            		Student newStudent = new Student(id, name, city);
            		int result = studentDao.insert(newStudent);
            		System.out.println("Student added with ID : "+result);
            		break;
            	case 2:
            		// Display all students
            		List<Student> allStudents = studentDao.getAllStudents();
            		System.out.println("All Students :");
            		for(Student s : allStudents) {
            			System.out.println(s);
            		}
            		break;
            	case 3:
            		// Get single student data
            		System.out.println("Enter student ID : ");
            		int studentId = Integer.parseInt(br.readLine());
            		Student student = studentDao.getStudent(studentId);
            		if(student != null) {
            			System.out.println("Student details : "+student);
            		}else{
            			System.out.println("No student found with ID : "+studentId);
            		}
            		break;
            	case 4:
            		// Delete student
            		System.out.println("Enter student ID to delete : ");
            		int deleteId = Integer.parseInt(br.readLine());
            		boolean isDeleted = studentDao.deleteStudent(deleteId);
            		if(isDeleted) {
            			System.out.println("Student delete with ID : "+deleteId);
            		}else {
            			System.out.println("No student found with ID : "+deleteId);
            		}
            		break;
            	case 5:
            		// Update student
            		System.out.println("Enter student ID to update : ");
            		int updateId = Integer.parseInt(br.readLine());
            		
            		Student studentToUpdate = studentDao.getStudent(updateId);
            		if(studentToUpdate != null) {
            			System.out.println("Enter new student name : ");
                		String newName = br.readLine();
                		
                		System.out.println("Enter new student city : ");
                		String newCity = br.readLine();
                		
                		Student updateStudent = new Student(updateId, newName, newCity);
                		studentDao.updateStudent(updateStudent);
                		System.out.println("Student update with ID : "+updateId);
            		}else {
            			 System.out.println("No student found with ID: " + updateId);
            		}
            		break;
            	case 6:
            		// I have to exit
            		go = false;
            		break;
            		
            	default:
                    System.out.println("Invalid input, please try again.");
            	}
            	
            	/*
            	if(input == 1)
            	{
            		// add a new student
            	}
            	else if(input == 2)
            	{
            		// display all students
            	}
            	*/
            	
            }catch (Exception e) {
				System.out.println("Invalid Input Try With Another One!!!");
				System.out.println(e.getMessage());
			}
        }
        System.out.println("Thank you for using my application");
        System.out.println("I'll see you soon!!!");
    }
}

// From BufferReader object we can get input from users