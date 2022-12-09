package com.crud;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BankController {

    private static final String BANK_SERVICE = "bankservice";
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/bank")
    @CircuitBreaker(name=BANK_SERVICE, fallbackMethod = "bankFallBack")
    public ResponseEntity<String> createBank(){
        String response = restTemplate.getForObject("http://localhost:8081/bank", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
   
    @GetMapping("/bank")
    @CircuitBreaker(name=BANK_SERVICE, fallbackMethod = "bankFallBack")
    public ResponseEntity<String> createOrder(){
        String response = restTemplate.getForObject("http://localhost:8081/item", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    
    
    public ResponseEntity<String> bankFallBack(Exception e){
        return new ResponseEntity<String>("Bank service is down", HttpStatus.OK);

    }




}
