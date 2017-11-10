package it.madlabs.springtalk.business.services;

public interface PersonGreeterService {

    String composeGreetingToTheWorld();

    String composeGreetingToRandomPerson();

    String composeGreetingToSomePerson(int id);
}
