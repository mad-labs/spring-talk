package it.madlabs.springtalk.model.repositories;

import it.madlabs.springtalk.model.entities.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> findAll();

    Person findOne(Integer id);

    int count();
}
