package it.madlabs.springtalk.business.services.impl;

import it.madlabs.springtalk.business.services.GreetingStyleService;
import it.madlabs.springtalk.model.entities.Greeting;
import it.madlabs.springtalk.model.repositories.GreetingsRepository;
import it.madlabs.springtalk.model.repositories.impl.GreetingsRepositoryImpl;

public class InformalGreetingStyleServiceImpl
        implements GreetingStyleService {

    private final String type = "informal";

    private GreetingsRepository greetingsRepository;

    public InformalGreetingStyleServiceImpl() {
        this.greetingsRepository = new GreetingsRepositoryImpl();
    }

    public String getFormatByPeriod(String period) {

        Greeting greeting = greetingsRepository.findByTypeAndPeriod(type, period);
        return greeting != null ? greeting.getFormat() : "";
    }
}
