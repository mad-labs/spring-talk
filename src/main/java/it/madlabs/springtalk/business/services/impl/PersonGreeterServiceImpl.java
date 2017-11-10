package it.madlabs.springtalk.business.services.impl;

import it.madlabs.springtalk.business.services.GreetingStyleService;
import it.madlabs.springtalk.business.services.PersonGreeterService;
import it.madlabs.springtalk.model.entities.Person;
import it.madlabs.springtalk.model.repositories.PersonRepository;
import it.madlabs.springtalk.model.repositories.imp.PersonRepositoryImpl;

import java.util.Calendar;
import java.util.Random;

public class PersonGreeterServiceImpl implements PersonGreeterService {

    private PersonRepository personRepository;
    private GreetingStyleService greetingStyleService;

//    public PersonGreeterServiceImpl() {
//        this.personRepository = new PersonRepositoryImpl();
//        this.greetingStyleService = new InformalGreetingStyleServiceImpl();
//    }

    public PersonGreeterServiceImpl() {
    }

    public PersonGreeterServiceImpl(PersonRepository personRepository, GreetingStyleService greetingStyleService) {
        this.personRepository = personRepository;
        this.greetingStyleService = greetingStyleService;
    }

    public String composeGreetingToTheWorld() {
        return "Hello World!";
    }

    public String composeGreetingToRandomPerson() {
        int personsCount = personRepository.count();
        int nextInt = new Random().nextInt(personsCount);
        String greetingFormat = greetingStyleService.getFormatByPeriod(getDayPeriod());
        return composeGreetingToSomePerson(nextInt, greetingFormat);
    }

    private String getDayPeriod() {
        return Calendar.getInstance().get(Calendar.AM_PM) == Calendar.AM ? "am" : "pm";
    }

    public String composeGreetingToSomePerson(int id) {
        String greetingFormat = greetingStyleService.getFormatByPeriod(getDayPeriod());
        return composeGreetingToSomePerson(id, greetingFormat);
    }

    public String composeGreetingToSomePerson(int id, String greetingFormat) {
        Person person = personRepository.findOne(id);
        if (person != null) {
            return String.format(greetingFormat, person.getName(), person.getSurname(), person.getEmail());
        }
        return "I don't know that person :(";
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void setGreetingStyleService(GreetingStyleService greetingStyleService) {
        this.greetingStyleService = greetingStyleService;
    }
}