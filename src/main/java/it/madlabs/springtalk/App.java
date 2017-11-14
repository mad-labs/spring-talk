package it.madlabs.springtalk;

import it.madlabs.springtalk.business.services.PersonGreeterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan(basePackages = "it.madlabs.springtalk")
public class App {

    public static void main( String[] args ) {
        System.out.println("\n *** WELCOME TO GREAT PERSONS GREETER *** \n");

//        BeanFactory beanFactory = new PropertiesBeanFactory("configuration.properties");
//        PersonGreeterService personGreeterService = (PersonGreeterService) beanFactory.getBean("personGreeterService");

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        //Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'personGreeterService' available
        //Why? Because bean has bean a different name!
        //We can undestand this with: System.out.println("context.getBeanDefinitionNames() = [" + Arrays.asList(context.getBeanDefinitionNames()) + "]");

        PersonGreeterService personGreeterService = (PersonGreeterService) context.getBean("personGreeterService");

        String worldHello = personGreeterService.composeGreetingToTheWorld();
        System.out.println(worldHello);

        String personHello = personGreeterService.composeGreetingToRandomPerson();
        System.out.println(personHello);

        System.out.println("\n *** GOODBYE *** \n");
    }


}
