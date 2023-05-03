package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UnsupportedMathOperationException;
import com.example.demo.models.Person;
import com.example.demo.services.PersonService;

@RequestMapping(value="/person")
@RestController
public class PersonController {

	@Autowired
	private PersonService service;
	
	
	@GetMapping
	public List<Person> findAll(
			) {
		return  service.findAll();

		};
		
	
	@RequestMapping( value= "/{Id}",method=RequestMethod.GET)
	public Person findById(
			@PathVariable(value="Id")String id
			)throws Exception {

		if(id == null) {
				throw new UnsupportedMathOperationException("Deu erro, id nulo");
		}
		return  service.findById(id);
		
	}

	
	@PostMapping
	public Person createPerson(@RequestBody Person person) {		
		return service.create(person);
	}	
	
	@PutMapping
	public Person updatePerson(@RequestBody Person person) {
		return service.update(person);
	}
			
	@DeleteMapping(value="/{Id}")
	public void DeletePerson(@PathVariable(value= "{Id}") String id ) {
		service.delete(id);
	}

	
	
}
