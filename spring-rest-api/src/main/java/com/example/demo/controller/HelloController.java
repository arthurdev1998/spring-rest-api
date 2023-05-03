package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.NumberConverter;
import com.example.demo.Math.SimpleMath;
import com.example.demo.exceptions.UnsupportedMathOperationException;

@RestController
public class HelloController {
	private static final String template = "hello, %s";
	private final AtomicLong counter = new AtomicLong();
	private SimpleMath simplemath = new SimpleMath();
	
	@RequestMapping( value= "/soma/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public double somatorio(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo")String numberTwo
			)throws Exception {

		if(!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Deu erro, por favor verificar os numeros:" +numberOne +"e"+numberTwo);
		}
		return  simplemath.soma(NumberConverter.ConverterToNumber(numberOne),NumberConverter.ConverterToNumber(numberTwo));
		
	}

	@GetMapping(value="/sub/{numberOne}/{numberTwo}")
	public double Sub(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo")String numberTwo
			)throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne)|| !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("subtração inválida");
		}
		
		return  simplemath.sub(NumberConverter.ConverterToNumber(numberOne),NumberConverter.ConverterToNumber(numberTwo));
	}
	
	@GetMapping(value="/mult/{numberOne}/{numberTwo}")
	public double mult(
		@PathVariable(value="numberOne")String numberOne,
		@PathVariable(value="numberTwo")String numberTwo
			)throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Multiplicação inválida");
		}
		
		return  simplemath.mult(NumberConverter.ConverterToNumber(numberOne),NumberConverter.ConverterToNumber(numberTwo));
	}
	
	
	@GetMapping(value="div/{numberOne}/{numberTwo}")
	public double div (
	@PathVariable(value="numberOne")String numberOne,
	@PathVariable(value="numberTwo")String numberTwo
			)throws Exception {
		if(!NumberConverter.isNumeric(numberOne)|| !NumberConverter.isNumeric(numberTwo)) {
		  throw new UnsupportedMathOperationException ("Divisão inválida");
		}
		 else if(NumberConverter.ConverterToNumber(numberTwo) <= 0) {
			 throw new UnsupportedMathOperationException("Não é possivel divisao por zero");
		 }

		return  simplemath.div(NumberConverter.ConverterToNumber(numberOne),NumberConverter.ConverterToNumber(numberTwo));
	}
	
	
	
	

	
	
}
