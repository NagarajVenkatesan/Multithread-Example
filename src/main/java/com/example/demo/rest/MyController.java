package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PersonService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class MyController {
	
	private PersonService service;

	@GetMapping("/save")
	public void saveToDb() {
		service.savePerson();		
	}

	@GetMapping("/threads")
	public void saveToDbMultiThreads() {        
		service.savePersonMultiThreads();
	}
}
