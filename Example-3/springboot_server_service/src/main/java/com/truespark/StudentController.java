package com.truespark;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	@GetMapping("/get")
	public Student display(){
	  
		Student student=new Student();
		student.setAddress("Pune");
		student.setId(22);
		student.setName("Jeevan");
		return new ResponseEntity<Student>(student,HttpStatus.CREATED).getBody();
	}
}