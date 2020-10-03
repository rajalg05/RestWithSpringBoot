package com.example.rest.springboot.utility;

public class SimpleMath {

	public Double sum(String numberOne, String numberTwo) {
		return Double.parseDouble(numberOne) + Double.parseDouble(numberTwo);
	}

	public Double subtraction(String numberOne, String numberTwo) {
		return Double.parseDouble(numberOne) - Double.parseDouble(numberTwo);
	}

	public Double multiplication(String numberOne, String numberTwo) {
		return Double.parseDouble(numberOne) * Double.parseDouble(numberTwo);
	}

	public Double division(String numberOne, String numberTwo) {
		return Double.parseDouble(numberOne) / Double.parseDouble(numberTwo);
	}

	public Double squareRoot(String number) {
		return Math.sqrt(Double.parseDouble(number));
	} 
}
