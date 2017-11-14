package it.madlabs.springtalk.controller;

import it.madlabs.springtalk.business.services.PersonGreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonGreeterController {

    @Autowired
    private PersonGreeterService personGreeterService;

    @RequestMapping(value = "greetings", method = RequestMethod.GET)
    public ModelAndView getGreetings() {
        ModelAndView mv= new ModelAndView("greetings", "message", personGreeterService.composeGreetingToRandomPerson());
        return mv;
    }

}
