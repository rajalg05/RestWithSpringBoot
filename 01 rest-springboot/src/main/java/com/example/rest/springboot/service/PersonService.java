package com.example.rest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.springboot.data.model.Person;
import com.example.rest.springboot.data.vo.PersonVO;
import com.example.rest.springboot.data.vo.PersonVOV2;
import com.example.rest.springboot.dozer.converter.DozerConverter;
import com.example.rest.springboot.dozer.converter.PersonConverter;
import com.example.rest.springboot.exception.ResourceNotFoundException;
import com.example.rest.springboot.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository pr;

	@Autowired
	PersonConverter pc;
	
	public PersonVO create(PersonVO personVo) {

		var entity = DozerConverter.parseObject(personVo, Person.class);
		var vo = DozerConverter.parseObject(pr.save(entity), PersonVO.class);

		return vo;
		//		Person p = new Person();
		//		p.setAddress(personVo.getAddress());
		//		p.setFirstName(personVo.getFirstName());
		//		p.setGender(personVo.getGender());
		//		
		//		return pr.save(p);
	}

	public PersonVOV2 createV2(PersonVOV2 personVo) {

		var entity = pc.convertVOToEntity(personVo);
		var vo = pc.convertEntityToVO(pr.save(entity));

		return vo;
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseObjectList(pr.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		var entity = pr.findById(id.intValue()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id !!"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public PersonVO update(PersonVO personVO) {
		var p = pr.findById(personVO.getId().intValue())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id!!"));

		p.setFirstName(personVO.getFirstName());
		p.setLastName(personVO.getLastName());
		p.setAddress(personVO.getAddress());
		p.setGender(personVO.getGender());

		return DozerConverter.parseObject(pr.save(p), PersonVO.class);
	}

	public void delete(Long id) {
		Person p = pr.findById(id.intValue()).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this id!!"));

		pr.delete(p);
	}



}
