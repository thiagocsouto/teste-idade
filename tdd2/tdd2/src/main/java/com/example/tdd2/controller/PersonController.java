package com.example.tdd2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tdd2.entity.Person;
import com.example.tdd2.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> ListPersons(){
		return personService.ListPerson();
	}
	
	@GetMapping("/{id}")
	public Optional<Person> ListIdPersons(@PathVariable(value="id") Integer id){
		return personService.ListPersonId(id);
	}
	
	@PostMapping
	public Person SavePersons(@RequestBody Person person){
		return personService.savePerson(person);
	}
	
	@DeleteMapping
	public void deletePersons(@RequestBody Person person) {
		personService.deletePerson(person);
	}
	
	

}
