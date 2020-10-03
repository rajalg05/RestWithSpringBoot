package com.example.rest.springboot.dozer.converter;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.rest.springboot.data.model.Person;
import com.example.rest.springboot.data.vo.PersonVOV2;

@Service
public class PersonConverter {
	public PersonVOV2 convertEntityToVO(Person person) {
		var personVOV2 = new PersonVOV2();
		
		personVOV2.setId(person.getId());
		personVOV2.setAddress(person.getAddress());
		personVOV2.setBirthDay(new Date()); 
		personVOV2.setFirstName(person.getFirstName()); 
		personVOV2.setLastName(person.getLastName());;
		personVOV2.setGender(person.getGender());
		
		return personVOV2;
		
	}
	
	public Person convertVOToEntity(PersonVOV2 v2) {
		var person = new Person();
		person.setAddress(v2.getAddress());
		person.setFirstName(v2.getFirstName());
		person.setGender(v2.getGender());
		person.setLastName(v2.getLastName());
		
		return person;
	}
}
