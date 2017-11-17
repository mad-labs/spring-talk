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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Hello world!
 *
 */
@Configuration
public class RootConfig implements WebMvcConfigurer {

    @Bean
    public SimpleDataSource simpleDataSource(){
        return new SimpleDataSourceImpl();
    }

    @Bean
    public GreetingsRepository greetingsRepository(SimpleDataSource simpleDataSource){
        return new GreetingsRepositoryImpl(simpleDataSource);
    }

    @Bean
    public PersonRepository personRepository(SimpleDataSource simpleDataSource){
        return new PersonRepositoryImpl(simpleDataSource);
    }

    @Bean
    public GreetingStyleService greetingStyleService(GreetingsRepository greetingsRepository){
        return new FormalGreetingStyleServiceImpl(greetingsRepository);
    }

    @Bean
    public PersonGreeterService personGreeterService(PersonRepository personRepository, GreetingStyleService greetingStyleService){
        return new PersonGreeterServiceImpl(personRepository, greetingStyleService);
    }
}
