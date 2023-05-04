package com.example.demo.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Repositories.PersonRepository;
import com.example.demo.exceptions.ResourcesNotFoundException;
import com.example.demo.models.Person;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public Person findById(Long id) {
		logger.info("buscando ...");

		Person persone = repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Pessoa nao encontrada"));
		return persone;

	};

	public List<Person> findAll() {

		List<Person> persons = repository.findAll();
//		List<Person> persons = new ArrayList<>();
//		for(int i = 0; i<8;i++) {
//			Person persones = MockPerson(i);
//			persons.add(persones);
//		}
		return persons;

	}

	public Person create(Person person) {
		Person persones = new Person();

		persones.setFirstName(person.getFirstName());
		persones.setAddress(person.getAddress());
		persones.setGender(person.getGender());
		persones.setLasttName(person.getLasttName());

		return repository.save(persones);
	}

	public Person update(Person person) {

		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourcesNotFoundException("Pessoa nao encontrada"));
		person.setFirstName(entity.getFirstName());
		person.setAddress(entity.getAddress());
		person.setGender(entity.getGender());
		person.setLasttName(entity.getLasttName());
		repository.save(person);
		return person;

	}

	public void delete(Long id) {
		var persone = repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Pessoa nao encontrada"));
		repository.delete(persone);

	}

}
