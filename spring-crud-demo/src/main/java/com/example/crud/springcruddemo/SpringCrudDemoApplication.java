package com.example.crud.springcruddemo;

import com.example.crud.springcruddemo.dao.StudentDAO;
import com.example.crud.springcruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
public class SpringCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student");
		Student student = new Student("John", "Smith", "John@xyz.com");
		Student student2 = new Student("Brad", "Cage", "brad@xyz.com");
		Student student3 = new Student("William", "Froster", "william@xyz.com");

		// save the student object
		System.out.println("Saving student..");
		studentDAO.save(student);
		studentDAO.save(student2);
		studentDAO.save(student3);

		// display details of the saved student
		System.out.println("ID of the saved student: "+ student.toString());
	}

}
