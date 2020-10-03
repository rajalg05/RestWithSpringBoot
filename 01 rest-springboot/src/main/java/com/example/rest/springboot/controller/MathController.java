package com.example.rest.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.springboot.constant.Constant;
import com.example.rest.springboot.exception.UnsupportedMathOperationException;
import com.example.rest.springboot.utility.SimpleMath;
import com.example.rest.springboot.utility.Utility;

@RestController
public class MathController {

	SimpleMath sm = new SimpleMath();
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		Utility.checkNumeric(numberOne, numberTwo);
		return sm.sum(numberOne, numberTwo);
	}

	@RequestMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		Utility.checkNumeric(numberOne, numberTwo);
		return sm.subtraction(numberOne, numberTwo);
	}
	@RequestMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		Utility.checkNumeric(numberOne, numberTwo);
		return sm.multiplication(numberOne, numberTwo);
	}
	@RequestMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		Utility.checkNumeric(numberOne, numberTwo);
		return sm.division(numberOne, numberTwo);
	}
	@RequestMapping("/squareRoot/{number}")
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		if(!Utility.isNumeric(number)) {
			throw new UnsupportedMathOperationException(Constant.SET_NUMERIC);
		}
		return sm.squareRoot(number);
	}
}
