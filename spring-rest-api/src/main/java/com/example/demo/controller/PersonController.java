package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.vo.v1.PersonVo;
import com.example.demo.data.vo.v2.PersonVoV2;
import com.example.demo.exceptions.ResourcesNotFoundException;
import com.example.demo.services.PersonService;

@RequestMapping(value = "/v1/person")
@RestController
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVo> findAll() {
		return service.findAll();

	};

	@RequestMapping(value = "/{Id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVo findById(@PathVariable(value = "Id") Long id) throws Exception {

		if (id == null) {
			throw new ResourcesNotFoundException("Deu erro, id nulo");
		}
		return service.findById(id);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVo create(@RequestBody PersonVo person) {
		return service.create(person);
	}
	
	// METODO CREATE VERSIONADO(V2)
	@PostMapping(value="/V2",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVoV2 createV2(@RequestBody PersonVoV2 person) {
		return service.createV2(person);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public PersonVo update(@RequestBody PersonVo person) {
		return service.update(person);
	};

	@DeleteMapping(value = "/{Id}")
	public ResponseEntity<?> Delete(@PathVariable( value = "Id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	

	}
	
}

