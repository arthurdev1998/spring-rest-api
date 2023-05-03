package com.example.demo.Math;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.NumberConverter;
import com.example.demo.exceptions.UnsupportedMathOperationException;

public class SimpleMath {

	public double div (
	@PathVariable(value="numberOne")double numberOne,
	@PathVariable(value="numberTwo")double numberTwo
			) {
		return  numberOne/numberTwo;

	};
	public double soma (
			@PathVariable(value="numberOne")double numberOne,
			@PathVariable(value="numberTwo")double numberTwo
					) {
				return  numberOne+numberTwo;

			};

			public double sub (
					@PathVariable(value="numberOne")double numberOne,
					@PathVariable(value="numberTwo")double numberTwo
							) {
						return  numberOne-numberTwo;

					};
					
					public double mult (
							@PathVariable(value="numberOne")double numberOne,
							@PathVariable(value="numberTwo")double numberTwo
									) {
								return  numberOne*numberTwo;

							};

}
	
	

