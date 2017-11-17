package it.madlabs.springtalk.controller;

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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonGreeterServlet
        extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        String message = personGreeterService.composeGreetingToRandomPerson();
        req.setAttribute("message", message);
        String nextJSP = "/views/greetings.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req,resp);
    }
}
