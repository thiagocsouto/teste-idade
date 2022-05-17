package com.example.tdd2.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tdd2.entity.Person;
import com.example.tdd2.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> ListPerson(){
		return personRepository.findAll();
	}
	
	public Optional<Person> ListPersonId(Integer id){
		return personRepository.findById(id);
	}
	
	public void deletePerson(Person person){
		 personRepository.delete(person);
	}
	
	public boolean isAdult(Person person) {
		if(person == null) { 
			throw new NullPointerException(); 
		}
		return person.getAge() >= 18;
	}
	
	public List<Person> filterRemovingNotAdult(List<Person> personList){
		return personList.stream().filter(this::isAdult).collect(Collectors.toList());
	}
      
      
}
