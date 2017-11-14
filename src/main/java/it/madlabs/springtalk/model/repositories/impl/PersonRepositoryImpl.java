package it.madlabs.springtalk.model.repositories.impl;

import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.entities.Person;
import it.madlabs.springtalk.model.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonRepositoryImpl
        implements PersonRepository {

    //property style autowiring
    @Autowired
    public SimpleDataSource simpleDataSource;

//    public PersonRepositoryImpl(){
//        this.simpleDataSource = new SimpleDataSourceImpl();
//    }


    public PersonRepositoryImpl() {
    }

    public PersonRepositoryImpl(SimpleDataSource simpleDataSource) {
        this.simpleDataSource = simpleDataSource;
    }

    public List<Person> findAll() {
        List<Person> allPerson = new ArrayList<Person>();

        String[][] rawPersonList = simpleDataSource.getRawDataList(Person.TABLE_NAME);
        for (String[] rawPersonData : rawPersonList) {
            Person person = composePerson(rawPersonData);
            allPerson.add(person);
        }
        return allPerson;
    }

    public Person findOne(Integer id) {
        List<Person> allPerson = findAll();
        if (allPerson.isEmpty()){
            return null;
        }
        return allPerson.get(id);
    }


    public int count() {
        String[][] rawPersonsDataList = simpleDataSource.getRawDataList(Person.TABLE_NAME);
        return rawPersonsDataList.length;
    }

    private Person composePerson(String[] rawPersonData){
        return new Person(rawPersonData[0], rawPersonData[1], rawPersonData[2]);
    }

    public void setSimpleDataSource(SimpleDataSource simpleDataSource) {
        this.simpleDataSource = simpleDataSource;
    }
}
