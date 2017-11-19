package it.madlabs.springtalk;

import it.madlabs.springtalk.business.services.GreetingStyleService;
import it.madlabs.springtalk.business.services.PersonGreeterService;
import it.madlabs.springtalk.business.services.impl.FormalGreetingStyleServiceImpl;
import it.madlabs.springtalk.business.services.impl.PersonGreeterServiceImpl;
import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.data.impl.SimpleDataSourceImpl;
import it.madlabs.springtalk.model.repositories.GreetingsRepository;
import it.madlabs.springtalk.model.repositories.PersonRepository;
import it.madlabs.springtalk.model.repositories.impl.GreetingsRepositoryImpl;
import it.madlabs.springtalk.model.repositories.impl.PersonRepositoryImpl;

public class BeanFactory {

    public static PersonGreeterService getPersonGreeterService() {
        SimpleDataSource simpleDataSource = new SimpleDataSourceImpl();

        GreetingsRepository greetingsRepository = new GreetingsRepositoryImpl();
        greetingsRepository.setSimpleDataSource(simpleDataSource);

        PersonRepository personRepository = new PersonRepositoryImpl();
        personRepository.setSimpleDataSource(simpleDataSource);

        //GreetingStyleService greetingStyleService = new InformalGreetingStyleServiceImpl(greetingsRepository);
        GreetingStyleService greetingStyleService = new FormalGreetingStyleServiceImpl();
        greetingStyleService.setGreetingsRepository(greetingsRepository);

        PersonGreeterService personGreeterService = new PersonGreeterServiceImpl();
        personGreeterService.setPersonRepository(personRepository);
        personGreeterService.setGreetingStyleService(greetingStyleService);
        return personGreeterService;
    }
}
