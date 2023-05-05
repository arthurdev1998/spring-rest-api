package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DozerMapper {
 
	private static ModelMapper mapper = new ModelMapper();
		public static <O,D> D parseObject(O origin, Class<D> destination)	{
			return mapper.map(origin, destination);
			
		};
		
		public static <O,D> List<D> parseListObject(List<O> origin, Class<D> destination)	{
			List<D> destinationObjects = new ArrayList<D>();
			for (O o: origin) {
				destinationObjects.add(mapper.map(o, destination));
			}
			return destinationObjects;
			
		}

}
