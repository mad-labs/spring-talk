package it.madlabs.springtalk.business;

import it.madlabs.springtalk.model.entities.Person;
import it.madlabs.springtalk.model.repositories.PersonRepository;
import it.madlabs.springtalk.model.repositories.imp.PersonRepositoryImpl;

import java.util.Random;

public class PersonGreeter {

    private PersonRepository personRepository;

    public PersonGreeter() {
        this.personRepository = new PersonRepositoryImpl();
    }

    public String composeGreetingToTheWolrd() {
        return "Hello World!";
    }

    public String composeGreetingToRandomPerson() {
        int personsCount = personRepository.count();
        int nextInt = new Random().nextInt(personsCount);
       return composeGreetingToSomePerson(nextInt);
    }

    public String composeGreetingToSomePerson(int id) {
        Person person = personRepository.findOne(id);
        if (person != null) {
            return "Hello " + person.getName() + " " + person.getSurname() + " (" + person.getEmail() + ")";
        }
        return "I don't know that person :(";
    }
}