package it.madlabs.springtalk.controller;

import it.madlabs.springtalk.business.services.PersonGreeterService;
import it.madlabs.springtalk.utils.BeanFactory;
import it.madlabs.springtalk.utils.PropertiesBeanFactory;

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
        BeanFactory beanFactory = new PropertiesBeanFactory("configuration.properties");

        PersonGreeterService personGreeterService = (PersonGreeterService) beanFactory.getBean("personGreeterService");

        String message = personGreeterService.composeGreetingToRandomPerson();
        req.setAttribute("message", message);
        String nextJSP = "/views/greetings.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req,resp);
    }
}
