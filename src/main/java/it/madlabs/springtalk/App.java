package it.madlabs.springtalk;

import it.madlabs.springtalk.business.services.GreetingStyleService;
import it.madlabs.springtalk.business.services.PersonGreeterService;
import it.madlabs.springtalk.business.services.impl.FormalGreetingStyleServiceImpl;
import it.madlabs.springtalk.business.services.impl.InformalGreetingStyleServiceImpl;
import it.madlabs.springtalk.business.services.impl.PersonGreeterServiceImpl;
import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.data.impl.SimpleDataSourceImpl;
import it.madlabs.springtalk.model.repositories.GreetingsRepository;
import it.madlabs.springtalk.model.repositories.PersonRepository;
import it.madlabs.springtalk.model.repositories.impl.GreetingsRepositoryImpl;
import it.madlabs.springtalk.model.repositories.impl.PersonRepositoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Hello world!
 *
 */
@Configuration
public class App {

    @Bean
    public SimpleDataSource simpleDataSource(){
        return new SimpleDataSourceImpl();
    }

    @Bean
    public GreetingsRepository greetingsRepository(SimpleDataSource simpleDataSource){
        return new GreetingsRepositoryImpl(simpleDataSource);
    }

    @Bean
    @Scope("singleton")
    public PersonRepository personRepository(SimpleDataSource simpleDataSource){
        return new PersonRepositoryImpl(simpleDataSource);
    }

    @Bean
    public GreetingStyleService formalGreetingStyleService(GreetingsRepository greetingsRepository){
        return new FormalGreetingStyleServiceImpl(greetingsRepository);
    }

    @Bean
    public GreetingStyleService informalGreetingStyleService(GreetingsRepository greetingsRepository){
        return new InformalGreetingStyleServiceImpl(greetingsRepository);
    }

    @Bean
    public PersonGreeterService personGreeterService(PersonRepository personRepository, GreetingStyleService formalGreetingStyleService){
        return new PersonGreeterServiceImpl(personRepository, formalGreetingStyleService);
    }

    public static void main( String[] args ) {
        System.out.println("\n *** WELCOME TO GREAT PERSONS GREETER *** \n");

//        BeanFactory beanFactory = new PropertiesBeanFactory("configuration.properties");
//        PersonGreeterService personGreeterService = (PersonGreeterService) beanFactory.getBean("personGreeterService");

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        PersonGreeterService personGreeterService = (PersonGreeterService) context.getBean("personGreeterService");

        String worldHello = personGreeterService.composeGreetingToTheWorld();
        System.out.println(worldHello);

        String personHello = personGreeterService.composeGreetingToRandomPerson();
        System.out.println(personHello);

        System.out.println("\n *** GOODBYE *** \n");
    }


}
