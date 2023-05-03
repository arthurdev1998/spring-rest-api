package com.example.demo.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Person;


@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	
	public Person findById(String id) {
		logger.info("buscando ...");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Arthur");
		person.setAddress("Recife");
		person.setGender("fluido");
		person.setLasttName("Mendes");
		return person;
	}
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<>();
		for(int i = 0; i<8;i++) {
			Person persones = MockPerson(i);
			persons.add(persones);
		}
		return persons;
		
	}
	
	public Person MockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Arthur"+i);
		person.setAddress("Recife"+i);
		person.setGender("fluido"+i);
		person.setLasttName("Mendes"+i);
		return person;
			
	}
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	public void delete(String id) {
	
	}
	
}
