package it.madlabs.springtalk.model.data.impl;

import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.entities.Greeting;
import it.madlabs.springtalk.model.entities.Person;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SimpleDataSourceImpl implements SimpleDataSource {
    private Map<String, String[][]> catalogs;

    public SimpleDataSourceImpl() {
        this.catalogs = new ConcurrentHashMap<String, String[][]>();
        catalogs.put(Person.TABLE_NAME, new String[][]{
                {"name", "surname", "email"},
                {"Mario", "Mario", "mario.mario@nintendo.com"},
                {"Luigi", "Mario", "luigi.mario@nintendo.com"} ,
                {"Bowser", "Koopa", "bowser.koopa@nintendo.com"}
        });
        catalogs.put(Greeting.TABLE_NAME, new String[][]{
                {"type", "period", "format"},
                {"formal", "am", "Good morning %s %s (%s)"},
                {"formal", "pm", "Good evening %s %s (%s)"},
                {"informal", "am", "Hi %s %s (%s)"},
                {"informal", "pm", "Hello %s %s (%s)"}
        });
    }

    public String[] getRawDataHeader(String tableName) {
        String[][] rawPersonsData = getRawPersonsData(tableName);
        if (notNullOrEmpty(rawPersonsData)){
            return rawPersonsData[0];
        }
        return new String[0];
    }

    public String[][] getRawDataList(String tableName) {
        String[][] rawPersonsData = getRawPersonsData(tableName);
        if (notNullOrEmpty(rawPersonsData)){
            String[][] rawPersonsDataList = new String[rawPersonsData.length-1][];
            for (int i = 1; i < rawPersonsData.length; i++) {
                rawPersonsDataList[i-1] = rawPersonsData[i];
            }
            return rawPersonsDataList;
        }

        return new String[0][0];
    }

    private String[][] getRawPersonsData(String tableName) {
        return catalogs.get(tableName);
    }

    private boolean notNullOrEmpty(String[][] array) {
        return array != null && array.length > 0;
    }
}
