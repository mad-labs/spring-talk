package it.madlabs.springtalk;

import it.madlabs.springtalk.business.services.GreetingStyleService;
import it.madlabs.springtalk.business.services.impl.FormalGreetingStyleServiceImpl;
import it.madlabs.springtalk.business.services.impl.PersonGreeterServiceImpl;
import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.data.impl.SimpleDataSourceImpl;
import it.madlabs.springtalk.model.repositories.GreetingsRepository;
import it.madlabs.springtalk.model.repositories.PersonRepository;
import it.madlabs.springtalk.model.repositories.imp.GreetingsRepositoryImpl;
import it.madlabs.springtalk.model.repositories.imp.PersonRepositoryImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("\n *** WELCOME TO GREAT PERSONS GREATER *** \n");

        SimpleDataSource simpleDataSource = new SimpleDataSourceImpl();

        GreetingsRepository greetingsRepository = new GreetingsRepositoryImpl();
        greetingsRepository.setSimpleDataSource(simpleDataSource);

        PersonRepository personRepository = new PersonRepositoryImpl();
        personRepository.setSimpleDataSource(simpleDataSource);

        //GreetingStyleService greetingStyleService = new InformalGreetingStyleServiceImpl(greetingsRepository);
        GreetingStyleService greetingStyleService = new FormalGreetingStyleServiceImpl();
        greetingStyleService.setGreetingsRepository(greetingsRepository);

        PersonGreeterServiceImpl personGreeter = new PersonGreeterServiceImpl();
        personGreeter.setPersonRepository(personRepository);
        personGreeter.setGreetingStyleService(greetingStyleService);

        String worldHello = personGreeter.composeGreetingToTheWorld();
        System.out.println(worldHello);

        String personHello = personGreeter.composeGreetingToRandomPerson();
        System.out.println(personHello);

        System.out.println("\n *** GOODBYE *** \n");
    }
}
