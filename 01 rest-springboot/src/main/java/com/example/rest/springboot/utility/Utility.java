package com.example.rest.springboot.utility;

import com.example.rest.springboot.constant.Constant;
import com.example.rest.springboot.exception.UnsupportedMathOperationException;

public class Utility {

	public static Double convertToDouble(String number) {
		if(number == null) return 0D;
		return Double.parseDouble(number);
	}

	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public static void checkNumeric(String numberOne, String numberTwo) {
		if(!Utility.isNumeric(numberOne) || !Utility.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(Constant.SET_NUMERIC);
		}
	}
	
	public static void checkNumeric(String number) {
		if(!Utility.isNumeric(number)) {
			throw new UnsupportedMathOperationException(Constant.SET_NUMERIC);
		}
	}
}
