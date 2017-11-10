package it.madlabs.springtalk.business.services;

import it.madlabs.springtalk.model.repositories.PersonRepository;

public interface PersonGreeterService {

    String composeGreetingToTheWorld();

    String composeGreetingToRandomPerson();

    String composeGreetingToSomePerson(int id);

    void setPersonRepository(PersonRepository personRepository);

    void setGreetingStyleService(GreetingStyleService greetingStyleService);
}
