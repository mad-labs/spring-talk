package it.madlabs.springtalk;

import it.madlabs.springtalk.business.services.GreetingStyleService;
import it.madlabs.springtalk.business.services.PersonGreeterService;
import it.madlabs.springtalk.business.services.impl.InformalGreetingStyleServiceImpl;
import it.madlabs.springtalk.business.services.impl.PersonGreeterServiceImpl;
import it.madlabs.springtalk.model.repositories.PersonRepository;
import it.madlabs.springtalk.model.repositories.imp.PersonRepositoryImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("\n *** WELCOME TO GREAT PERSONS GREATER *** \n");

        PersonGreeterService personGreeterService = new PersonGreeterServiceImpl();

        String worldHello = personGreeterService.composeGreetingToTheWorld();
        System.out.println(worldHello);

        String personHello = personGreeterService.composeGreetingToRandomPerson();
        System.out.println(personHello);

        System.out.println("\n *** GOODBYE *** \n");
    }
}
