package it.madlabs.springtalk.business.services.impl;

import it.madlabs.springtalk.business.services.GreetingStyleService;
import it.madlabs.springtalk.model.entities.Greeting;
import it.madlabs.springtalk.model.repositories.GreetingsRepository;
import it.madlabs.springtalk.model.repositories.imp.GreetingsRepositoryImpl;

public class InformalGreatingStyleServiceImpl
        implements GreetingStyleService {

    private final String type = "informal";

    private GreetingsRepository greetingsRepository;

    public InformalGreatingStyleServiceImpl() {
        this.greetingsRepository = new GreetingsRepositoryImpl();
    }

    public String getFormatByPeriod(String period) {

        Greeting greeting = greetingsRepository.findByTypeAndPeriod(type, period);
        return greeting != null ? greeting.getFormat() : "";
    }
}
