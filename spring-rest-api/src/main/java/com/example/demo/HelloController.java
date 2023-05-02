package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UnsupportedMathOperationException;

@RestController
public class HelloController {
	private static final String template = "hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping( value= "/soma/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double somatorio(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo")String numberTwo
			)throws Exception {

		if(!isNumeric(numberOne)||!isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Deu erro, por favor verificar os numeros:" +numberOne +"e"+numberTwo);
		}
		return ConverterToNumber(numberOne) + ConverterToNumber(numberTwo);
		
	}

	private double ConverterToNumber(String strNumber) {
		if(strNumber == null) return 0;
		String number = strNumber.replaceAll(",",".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0d;
		
	

	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",",".");

		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
