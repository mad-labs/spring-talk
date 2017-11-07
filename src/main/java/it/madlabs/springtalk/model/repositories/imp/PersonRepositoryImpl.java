package it.madlabs.springtalk.model.repositories.imp;

import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.entities.Person;
import it.madlabs.springtalk.model.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl
        implements PersonRepository {

    public SimpleDataSource simpleDataSource;

    public PersonRepositoryImpl(){
        this.simpleDataSource = new SimpleDataSource();
    }

    public List<Person> findAll() {
        ArrayList<Person> allPerson = new ArrayList<Person>();

        String[][] rawPersonList = getPersonsDataList();
        if (notNullOrEmpty(rawPersonList)){
            for (String[] rawPersonData : rawPersonList) {
                if (notNullOrEmpty(rawPersonData)){
                    Person person = composePerson(rawPersonData);
                    allPerson.add(person);
                }
            }
        }

        return allPerson;
    }

    public int count() {
        String[][] rawPersonsDataList = getPersonsDataList();
        return notNullOrEmpty(rawPersonsDataList) ? rawPersonsDataList.length : 0;
    }

    private String[] getPersonsDataHeader() {
        String[][] rawPersonsData = getRawPersonsData();
        if (notNullOrEmpty(rawPersonsData)){
            return rawPersonsData[0];
        }
        return null;
    }

    private String[][] getPersonsDataList() {
        String[][] rawPersonsData = getRawPersonsData();
        if (notNullOrEmpty(rawPersonsData)){
            String[][] rawPersonsDataList = new String[rawPersonsData.length-1][];
            for (int i = 1; i < rawPersonsData.length; i++) {
                rawPersonsDataList[i-1] = rawPersonsData[i];
            }
            return rawPersonsDataList;
        }

        return null;
    }

    private String[][] getRawPersonsData() {
        return simpleDataSource.getCatalog().get(Person.TABLE_NAME);
    }

    private boolean notNullOrEmpty(String[] array) {
        return array != null && array.length > 0;
    }

    private boolean notNullOrEmpty(String[][] array) {
        return array != null && array.length > 0;
    }

    public Person findOne(Integer id) {
        List<Person> allPerson = findAll();
        if (allPerson.isEmpty()){
            return null;
        }
        return allPerson.get(id);
    }

    private Person composePerson(String[] rawPersonData){
        return new Person(rawPersonData[0], rawPersonData[1], rawPersonData[2]);

    }
}
