package com.example.demo.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.PersonRepository;
import com.example.demo.data.vo.v1.PersonVo;
import com.example.demo.data.vo.v2.PersonVoV2;
import com.example.demo.exceptions.ResourcesNotFoundException;
import com.example.demo.mapper.DozerMapper;
import com.example.demo.mapper.custom.PersonMapper;
import com.example.demo.models.Person;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonMapper mappering;
	
	
	@Autowired
	private ModelMapper modelMapper;

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public PersonVo findById(Long id) {
		logger.info("buscando ...");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Pessoa nao encontrada"));
		return modelMapper.map(entity, PersonVo.class);

	};

	public List<PersonVo> findAll() {

		
		var entity = repository.findAll();	
		TypeToken<List<PersonVo>> typeToken = new TypeToken<>() {
		};
		return modelMapper.map(entity, typeToken.getType());
				
//		List<Person> persons = new ArrayList<>();
//		for(int i = 0; i<8;i++) {
//			Person persones = MockPerson(i);
//			persons.add(persones);
//		}
	

	}

	public PersonVo create(PersonVo person) {
		
		var entity = modelMapper.map(person, Person.class);
		return modelMapper.map(repository.save(entity), PersonVo.class);
	}
	
	//VERSIONAMENTO CREATE V2
	public PersonVoV2 createV2(PersonVoV2 person) {
		var entity = mappering.ConverterVoToEntity(person);
		return mappering.ConverterEntityToVo(repository.save(entity)); //pegue a entidade, salve ela no banco, pegue o que foi salvo e converta para VoV2
		
	}

	public PersonVo update(PersonVo person) {
				
//		var entity = DozerMapper.parseObject(person, Person.class);
//			var persone = repository.findById(entity.getId())
//				.orElseThrow(() -> new ResourcesNotFoundException("Pessoa nao encontrada"));
//		persone.setFirstName(entity.getFirstName());
//		persone.setAddress(entity.getAddress());
//		persone.setGender(entity.getGender());
//		persone.setLasttName(entity.getLasttName());
//		return DozerMapper.parseObject(repository.save(persone), PersonVo.class);
		
		var entity = repository.findById(person.getKey()).orElseThrow(()-> new ResourcesNotFoundException("Pessoa nao encontrada"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLasttName(person.getLasttName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return modelMapper.map(repository.save(entity), PersonVo.class);
		
		
		
		
	}

	public void delete(Long id) {
		var persone = repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Pessoa nao encontrada"));
		repository.delete(persone);

	}

}
