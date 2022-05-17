package com.example.tdd2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.tdd2.entity.Person;
import com.example.tdd2.repository.PersonRepository;
import com.example.tdd2.service.PersonService;

public class PersonServiceTest {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Test
	void TestwhenAgeless18(){
		Person person = new Person(15);
		PersonService personService = new PersonService();
        		
		Assertions.assertEquals(false, personService.isAdult(person));
	
	}
	
		@Test
		void TestwhenAgeMore18(){
			Person person = new Person(19);
			PersonService personService = new PersonService();
			
			Assertions.assertEquals(true, personService.isAdult(person));
		
	}
		
		@Test
		void TestThrowsExceptionwhenAgeIsNull() throws Exception{
			PersonService personService = new PersonService();
			Person person = new Person(null);   
			
			assertThrows(NullPointerException.class, () -> personService.isAdult(person));  
		
		}
		
		@Test
		void TestRemovingNotAdult() throws Exception{
			PersonService personService = new PersonService();
			Person person1 = new Person(15);
			Person person2 = new Person(18);
			Person person3 = new Person(21);
			List<Person> PersonList = List.of(person1, person2, person3);
			
			assertEquals(2, personService.filterRemovingNotAdult(PersonList).size());   
		}
		
		

}
