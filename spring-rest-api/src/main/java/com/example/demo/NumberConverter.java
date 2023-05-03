package com.example.demo;

public class NumberConverter {
	
	
	public static double ConverterToNumber(String strNumber) {
		if(strNumber == null) return 0;
		String number = strNumber.replaceAll(",",".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0d;
		
	}
	
	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",",".");

		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
