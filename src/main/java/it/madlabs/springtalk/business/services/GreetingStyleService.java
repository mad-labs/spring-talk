package it.madlabs.springtalk.business.services;

import it.madlabs.springtalk.model.repositories.GreetingsRepository;

public interface GreetingStyleService {

    String getFormatByPeriod(String period);

    void setGreetingsRepository(GreetingsRepository greetingsRepository);
}
