package com.example.rest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.springboot.data.vo.PersonVO;
import com.example.rest.springboot.data.vo.PersonVOV2;
import com.example.rest.springboot.service.PersonService;

@RestController
@RequestMapping("/api/person/v1/")
public class PersonController {

	@Autowired
	PersonService ps;

//	@RequestMapping(method=RequestMethod.GET,
//			produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping
	public List<PersonVO> findAll() throws Exception {
		return ps.findAll();
	}
	
//	@RequestMapping(value="/create",
//			method=RequestMethod.POST,
//			consumes=MediaType.APPLICATION_JSON_VALUE,
//			produces=MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/create")
	public PersonVO create(@RequestBody PersonVO PersonVO) {
		return ps.create(PersonVO);
	}

	@PostMapping("/create/v2/")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 PersonVO) {
		return ps.createV2(PersonVO);
	}
	
//	@RequestMapping(value="/update",
//			method=RequestMethod.PUT,
//			produces=MediaType.APPLICATION_JSON_VALUE)
	@PutMapping("/update")
	public PersonVO update(@RequestBody PersonVO PersonVO) {
		return ps.update(PersonVO);
	}
	
//	@RequestMapping(value="/delete/{id}",
//			method=RequestMethod.DELETE,
//			produces=MediaType.APPLICATION_JSON_VALUE)
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") String id) {
		ps.delete(Long.parseLong(id)); 
	}

//	@RequestMapping(value="/get/{id}", 
//			method=RequestMethod.GET,
//			produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") String id) throws Exception {
		return ps.findById(Long.parseLong(id));
	}
}
