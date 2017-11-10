package it.madlabs.springtalk.business.services.impl;

import it.madlabs.springtalk.business.services.GreetingStyleService;
import it.madlabs.springtalk.model.entities.Greeting;
import it.madlabs.springtalk.model.repositories.GreetingsRepository;
import it.madlabs.springtalk.model.repositories.imp.GreetingsRepositoryImpl;

public class FormalGreetingStyleServiceImpl
        implements GreetingStyleService {

    private final String type = "formal";

    private GreetingsRepository greetingsRepository;

//    public FormalGreetingStyleServiceImpl() {
//        this.greetingsRepository = new GreetingsRepositoryImpl();
//    }

    public FormalGreetingStyleServiceImpl(GreetingsRepository greetingsRepository) {
        this.greetingsRepository = greetingsRepository;
    }

    public String getFormatByPeriod(String period) {

        Greeting greeting = greetingsRepository.findByTypeAndPeriod(type, period);
        return greeting != null ? greeting.getFormat() : "";
    }
}
