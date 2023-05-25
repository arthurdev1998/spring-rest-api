package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.data.vo.v1.PersonVo;
import com.example.demo.models.Person;

@Configuration

public class DozerMapper {
 
	private static ModelMapper mapper = new ModelMapper();
//		public static <O,D> D parseObject(O origin, Class<D> destination)	{
//			return mapper.map(origin, destination);			
//		};
	
	
	
// Model Mapper
	
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.createTypeMap(Person.class, PersonVo.class)
			.addMapping(Person::getId, PersonVo::setKey);		
		return  modelMapper;
	}
	
// 
		public static <O,D> List<D> parseListObject(List<O> origin, Class<D> destination)	{
			List<D> destinationObjects = new ArrayList<D>();
			for (O o: origin) {
				destinationObjects.add(mapper.map(o, destination));
			}
			return destinationObjects;
			
		}

}
