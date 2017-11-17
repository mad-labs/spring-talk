package it.madlabs.springtalk.controller;

import it.madlabs.springtalk.App;
import it.madlabs.springtalk.business.services.PersonGreeterService;
import it.madlabs.springtalk.utils.BeanFactory;
import it.madlabs.springtalk.utils.PropertiesBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class PersonGreeterServlet
        extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        BeanFactory beanFactory = new PropertiesBeanFactory("configuration.properties");
//        PersonGreeterService personGreeterService = (PersonGreeterService) beanFactory.getBean("personGreeterService");

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        //Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'personGreeterService' available
        //Why? Because bean has bean a different name!
        //We can undestand this with:

        System.out.println("context.getBeanDefinitionNames() = [" + Arrays.asList(context.getBeanDefinitionNames()) + "]");


        //WARNING: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'personGreeterServiceImpl'
        //Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'it.madlabs.springtalk.business.services.GreetingStyleService' available: expected single matching bean but found 2: formalGreetingStyleServiceImpl,informalGreetingStyleServiceImpl
        //Why? Because we have 2 beans with the same interface!

        PersonGreeterService personGreeterService = (PersonGreeterService) context.getBean("personGreeterServiceImpl");

        //Exception in thread "main" java.lang.NullPointerException
        //at it.madlabs.springtalk.business.services.impl.PersonGreeterServiceImpl.composeGreetingToRandomPerson(PersonGreeterServiceImpl.java:38)
        //Why? Because we forgot some wiring!
        //personRepository is null because noone tell application context to fill it with something!

        String message = personGreeterService.composeGreetingToRandomPerson();
        req.setAttribute("message", message);
        String nextJSP = "/views/greetings.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req,resp);
    }
}
