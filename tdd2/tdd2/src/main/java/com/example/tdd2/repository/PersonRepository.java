package com.example.tdd2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tdd2.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
