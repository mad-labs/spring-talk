package it.madlabs.springtalk;

import it.madlabs.springtalk.business.services.PersonGreeterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Hello world!
 *
 */
@Configuration
@Import(RootConfig.class)
public class App implements WebMvcConfigurer {

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
