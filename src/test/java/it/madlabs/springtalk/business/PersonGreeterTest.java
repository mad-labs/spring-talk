package it.madlabs.springtalk.business;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonGreeterTest {
    private PersonGreeter personGreeter = new PersonGreeter();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void composeGreetingToTheWolrd() throws Exception {
        String result = personGreeter.composeGreetingToTheWolrd();
        Assert.assertEquals("Hello World!", result);
    }

    @Test
    public void composeGreetingToRandomPerson() throws Exception {
        String result = personGreeter.composeGreetingToTheWolrd();
        //Assert.assertEquals("Hello World!", result);
    }

    @Test
    public void composeGreetingToSomePerson() throws Exception {
        String result = personGreeter.composeGreetingToSomePerson(0);
        Assert.assertEquals("Hello Mario Mario (mario.mario@nintendo.com)", result);
    }

}