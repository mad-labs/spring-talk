package it.madlabs.springtalk;

import it.madlabs.springtalk.business.PersonGreeter;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("\n *** WELCOME TO GREAT PERSONS GREATER *** \n");
        PersonGreeter personGreeter = new PersonGreeter();

        String worldHello = personGreeter.composeGreetingToTheWolrd();
        System.out.println(worldHello);

        String personHello = personGreeter.composeGreetingToRandomPerson();
        System.out.println(personHello);

        System.out.println("\n *** GOODBYE *** \n");
    }
}
