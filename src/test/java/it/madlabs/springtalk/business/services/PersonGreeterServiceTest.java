package it.madlabs.springtalk.business.services;

import it.madlabs.springtalk.business.services.impl.PersonGreeterServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonGreeterServiceTest {
    private PersonGreeterService personGreeter = new PersonGreeterServiceImpl();

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