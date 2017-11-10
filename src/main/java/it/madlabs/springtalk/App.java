package it.madlabs.springtalk;

import it.madlabs.springtalk.business.services.PersonGreeterService;
import it.madlabs.springtalk.business.services.impl.PersonGreeterServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("\n *** WELCOME TO GREAT PERSONS GREATER *** \n");
        PersonGreeterService personGreeter = new PersonGreeterServiceImpl();

        String worldHello = personGreeter.composeGreetingToTheWorld();
        System.out.println(worldHello);

        String personHello = personGreeter.composeGreetingToRandomPerson();
        System.out.println(personHello);

        System.out.println("\n *** GOODBYE *** \n");
    }
}
