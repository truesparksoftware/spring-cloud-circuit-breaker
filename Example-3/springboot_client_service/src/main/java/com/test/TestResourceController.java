package com.test;
import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/student")
public class TestResourceController {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/get")
	@HystrixCommand(fallbackMethod = "servicedown")
	public Student display(){
		  HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
	  Student s=restTemplate.exchange("http://localhost:9191/student/get", HttpMethod.GET,entity,Student.class).getBody();
	 return new ResponseEntity<Student>(s,HttpStatus.CREATED).getBody();
	}
	@PostMapping("/post")
	public void postData(@RequestBody Student student){
		System.out.println("Student id--->"+student.getId());
	}
	
	@PostMapping("/get")
	public Student display1(){
		  HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
	  Student s=restTemplate.exchange("http://localhost:9191/student/get", HttpMethod.GET,entity,Student.class).getBody();
	 return new ResponseEntity<Student>(s,HttpStatus.CREATED).getBody();
	}
	
	@PutMapping("/get")
	public Student display2(){
		  HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
	  Student s=restTemplate.exchange("http://localhost:9191/student/get", HttpMethod.GET,entity,Student.class).getBody();
	 return new ResponseEntity<Student>(s,HttpStatus.CREATED).getBody();
	}
	
	public Student servicedown(){
		 return new Student(1,"Jeevan","Pune");
	}
}
