package it.madlabs.springtalk.business.services;

import it.madlabs.springtalk.business.services.impl.PersonGreeterServiceImpl;
import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.entities.Person;
import it.madlabs.springtalk.model.repositories.GreetingsRepository;
import it.madlabs.springtalk.model.repositories.PersonRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PersonGreeterServiceTest {

    private PersonRepository personRepository = new PersonRepository() {
        public List<Person> findAll() {
            return Arrays.asList(findOne(0));
        }

        public Person findOne(Integer id) {
            return new Person("Mario", "Mario", "mario.mario@nintendo.com");
        }

        public int count() {
            return 1;
        }

        @Override
        public void setSimpleDataSource(SimpleDataSource simpleDataSource) {
            //NOTHING TO DO
        }
    };

    private GreetingStyleService greetingStyleService = new GreetingStyleService() {
        public String getFormatByPeriod(String period) {
            return "Hello %s %s (%s)";
        }

        @Override
        public void setGreetingsRepository(GreetingsRepository greetingsRepository) {
            //NOTHING TO DO
        }
    };

    private PersonGreeterService personGreeter = new PersonGreeterServiceImpl(personRepository, greetingStyleService);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void composeGreetingToTheWolrd() throws Exception {
        String result = personGreeter.composeGreetingToTheWorld();
        Assert.assertEquals("Hello World!", result);
    }

    /*
        Cannot test! I need a way to control the data inside PersonGreeterService!
     */
    @Test
    public void composeGreetingToRandomPerson() throws Exception {
        String result = personGreeter.composeGreetingToTheWorld();
        Assert.assertEquals("Hello World!", result);
    }

    @Test
    public void composeGreetingToSomePerson() throws Exception {
        String result = personGreeter.composeGreetingToSomePerson(0);
        Assert.assertEquals("Hello Mario Mario (mario.mario@nintendo.com)", result);
    }

}