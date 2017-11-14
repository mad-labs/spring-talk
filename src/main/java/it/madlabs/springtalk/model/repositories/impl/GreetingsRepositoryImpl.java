package it.madlabs.springtalk.model.repositories.impl;

import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.data.impl.SimpleDataSourceImpl;
import it.madlabs.springtalk.model.entities.Greeting;
import it.madlabs.springtalk.model.repositories.GreetingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GreetingsRepositoryImpl
        implements GreetingsRepository {

    @Autowired
    public SimpleDataSource simpleDataSource;

//    public GreetingsRepositoryImpl(){
//        this.simpleDataSource = new SimpleDataSourceImpl();
//    }


    public GreetingsRepositoryImpl() {
    }

    public GreetingsRepositoryImpl(SimpleDataSource simpleDataSource) {
        this.simpleDataSource = simpleDataSource;
    }

    public List<Greeting> findAll() {
        List<Greeting> allGreeting = new ArrayList<Greeting>();

        String[][] rawGreetingList = simpleDataSource.getRawDataList(Greeting.TABLE_NAME);
        for (String[] rawGreetingData : rawGreetingList) {
            Greeting Greeting = composeGreeting(rawGreetingData);
            allGreeting.add(Greeting);
        }
        return allGreeting;
    }

    public Greeting findOne(Integer id) {
        List<Greeting> allGreeting = findAll();
        if (allGreeting.isEmpty()){
            return null;
        }
        return allGreeting.get(id);
    }

    public Greeting findByTypeAndPeriod(String type, String period) {
        List<Greeting> allGreeting = findAll();
        for (Greeting greeting : allGreeting) {
            if (type.equals(greeting.getType()) && period.equals(greeting.getPeriod())){
                return greeting;
            }
        }
        return null;
    }


    public int count() {
        String[][] rawGreetingsDataList = simpleDataSource.getRawDataList(Greeting.TABLE_NAME);
        return rawGreetingsDataList.length;
    }

    private Greeting composeGreeting(String[] rawGreetingData){
        return new Greeting(rawGreetingData[0], rawGreetingData[1], rawGreetingData[2]);
    }

    public void setSimpleDataSource(SimpleDataSource simpleDataSource) {
        this.simpleDataSource = simpleDataSource;
    }
}
