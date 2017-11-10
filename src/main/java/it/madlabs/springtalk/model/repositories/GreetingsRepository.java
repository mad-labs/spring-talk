package it.madlabs.springtalk.model.repositories;

import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.entities.Greeting;

import java.util.List;

public interface GreetingsRepository {

    List<Greeting> findAll();

    Greeting findOne(Integer id);

    Greeting findByTypeAndPeriod(String type, String period);

    int count();

    void setSimpleDataSource(SimpleDataSource simpleDataSource);
}
