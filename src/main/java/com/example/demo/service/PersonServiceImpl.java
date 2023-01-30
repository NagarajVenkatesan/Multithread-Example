package com.example.demo.service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository repository;
	
	@Override
	public void savePerson() {
		
		for(int i=1; i<=2000; i++) {
			Person p = new Person(null, "Naga", "India");
			repository.save(p);
		}
	}
	
	@Override
	public void savePersonMultiThreads() {
		
		ExecutorService exService = Executors.newFixedThreadPool(4);
		ExecutorCompletionService<Object> pool = new ExecutorCompletionService<>(exService);
		
		for(int i=1; i<=50000; i++) {
			
			pool.submit(new Callable<Object>() {
				
				@Override
				public Object call() throws Exception {
					Person p = new Person(null, "Naga", "India");
					repository.save(p);
					return null;
				}
			});			
		}
	}
}
