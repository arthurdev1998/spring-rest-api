package com.example.demo.mapper.custom;

import org.springframework.stereotype.Service;

import com.example.demo.data.vo.v2.PersonVoV2;
import com.example.demo.models.Person;
import java.util.Date;

@Service
public class PersonMapper {

	public PersonVoV2 ConverterEntityToVo (Person person) {
	 PersonVoV2 Vo = new PersonVoV2();
	 Vo.setId(person.getId());
	 Vo.setAddress(person.getAddress());
	 Vo.setBirthday(new Date());
	 Vo.setFirstName(person.getFirstName());
	 Vo.setLasttName(person.getLasttName());
	 Vo.setGender(person.getGender());		
	 return Vo;
	}	
	
	public Person ConverterVoToEntity (PersonVoV2 person) {
		Person vo = new Person();
		
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setFirstName(person.getFirstName());
		vo.setGender(person.getGender());
		vo.setLasttName(person.getLasttName());
		
		return vo;
		
		
		
		
	} 
	
}
