package it.madlabs.springtalk;

import it.madlabs.springtalk.business.services.PersonGreeterService;
import it.madlabs.springtalk.business.services.impl.PersonGreeterServiceImpl;
import it.madlabs.springtalk.utils.BeanFactory;
import it.madlabs.springtalk.utils.PropertiesBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("\n *** WELCOME TO GREAT PERSONS GREETER *** \n");

//        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        BeanFactory beanFactory = new PropertiesBeanFactory("configuration.properties");
        PersonGreeterService personGreeterService = (PersonGreeterService) beanFactory.getBean("personGreeterService");

        String worldHello = personGreeterService.composeGreetingToTheWorld();
        System.out.println(worldHello);

        String personHello = personGreeterService.composeGreetingToRandomPerson();
        System.out.println(personHello);

        System.out.println("\n *** GOODBYE *** \n");
    }


}
