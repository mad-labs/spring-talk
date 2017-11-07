package it.madlabs.springtalk.model.data;

import it.madlabs.springtalk.model.entities.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleDataSource {
    private Map<String, String[][]> catalog;

    public SimpleDataSource() {
        this.catalog = new ConcurrentHashMap<String, String[][]>();
        catalog.put(Person.TABLE_NAME, new String[][]{
                {"name", "surname", "email"},
                {"Mario", "Mario", "mario.mario@nintendo.com"},
                {"Luigi", "Mario", "luigi.mario@nintendo.com"} ,
                {"Bowser", "Koopa", "bowser.koopa@nintendo.com"}
        });
    }

    public Map<String, String[][]> getCatalog() {
        return catalog;
    }
}
