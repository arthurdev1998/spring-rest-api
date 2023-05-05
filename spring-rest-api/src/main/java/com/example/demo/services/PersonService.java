package com.example.demo.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.PersonRepository;
import com.example.demo.data.vo.v1.PersonVo;
import com.example.demo.exceptions.ResourcesNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.models.Person;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public PersonVo findById(Long id) {
		logger.info("buscando ...");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Pessoa nao encontrada"));
		return DozerMapper.parseObject(entity, PersonVo.class);

	};

	public List<PersonVo> findAll() {

		
		var entity = repository.findAll();
		return DozerMapper.parseListObject(entity, PersonVo.class); 
				
//		List<Person> persons = new ArrayList<>();
//		for(int i = 0; i<8;i++) {
//			Person persones = MockPerson(i);
//			persons.add(persones);
//		}
	

	}

	public PersonVo create(PersonVo person) {
		PersonVo persones = new PersonVo();

		persones.setFirstName(person.getFirstName());
		persones.setAddress(person.getAddress());
		persones.setGender(person.getGender());
		persones.setLasttName(person.getLasttName());
		
		var entity = DozerMapper.parseObject(persones, Person.class);

		return DozerMapper.parseObject(repository.save(entity), PersonVo.class);
	}

	public PersonVo update(PersonVo person) {

		
		
		var entity = DozerMapper.parseObject(person, Person.class);
			var persone = repository.findById(entity.getId())
				.orElseThrow(() -> new ResourcesNotFoundException("Pessoa nao encontrada"));
		persone.setFirstName(entity.getFirstName());
		persone.setAddress(entity.getAddress());
		persone.setGender(entity.getGender());
		persone.setLasttName(entity.getLasttName());
		return DozerMapper.parseObject(repository.save(persone), PersonVo.class);

	}

	public void delete(Long id) {
		var persone = repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Pessoa nao encontrada"));
		repository.delete(persone);

	}

}
