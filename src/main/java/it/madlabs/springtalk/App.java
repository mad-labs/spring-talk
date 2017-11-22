package it.madlabs.springtalk;

import it.madlabs.springtalk.business.services.GreetingStyleService;
import it.madlabs.springtalk.business.services.PersonGreeterService;
import it.madlabs.springtalk.business.services.impl.InformalGreetingStyleServiceImpl;
import it.madlabs.springtalk.business.services.impl.PersonGreeterServiceImpl;
import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.data.impl.SimpleDataSourceImpl;
import it.madlabs.springtalk.model.repositories.GreetingsRepository;
import it.madlabs.springtalk.model.repositories.PersonRepository;
import it.madlabs.springtalk.model.repositories.impl.GreetingsRepositoryImpl;
import it.madlabs.springtalk.model.repositories.impl.PersonRepositoryImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("\n *** WELCOME TO GREAT PERSONS GREETER *** \n");

        SimpleDataSource simpleDataSource = new SimpleDataSourceImpl();

        GreetingsRepository greetingsRepository = new GreetingsRepositoryImpl(simpleDataSource);

        PersonRepository personRepository = new PersonRepositoryImpl(simpleDataSource);

        GreetingStyleService greetingStyleService = new InformalGreetingStyleServiceImpl(greetingsRepository);

        PersonGreeterService personGreeterService = new PersonGreeterServiceImpl(personRepository, greetingStyleService);

        String worldHello = personGreeterService.composeGreetingToTheWorld();
        System.out.println(worldHello);

        String personHello = personGreeterService.composeGreetingToRandomPerson();
        System.out.println(personHello);

        System.out.println("\n *** GOODBYE *** \n");
    }
}
