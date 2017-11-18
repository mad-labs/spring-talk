package it.madlabs.springtalk.model.data.impl;

import it.madlabs.springtalk.model.data.SimpleDataSource;
import it.madlabs.springtalk.model.entities.Greeting;
import it.madlabs.springtalk.model.entities.Person;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

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
//        catalogs.put(Person.TABLE_NAME, loadPersonsFromGoogleSheetCsvFile());
        catalogs.put(Greeting.TABLE_NAME, new String[][]{
                {"type", "period", "format"},
                {"formal", "am", "Good morning %s %s (%s)"},
                {"formal", "pm", "Good evening %s %s (%s)"},
                {"informal", "am", "Hi %s %s (%s)"},
                {"informal", "pm", "Hello %s %s (%s)"}
        });
    }

    private String [][] loadPersonsFromGoogleSheetCsvFile(){
        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(Person.TABLE_NAME+ ".csv");
        Scanner scanner = new Scanner(input);
        ArrayList<String> rowList = new ArrayList<>();
        while(scanner.hasNext()){
            String aLine = scanner.nextLine();
            rowList.add(aLine);
        }
        String[] header = rowList.get(0).split(",");
        int rawLenght = header.length - 1;
        int tableLenght = rowList.size();
        String[][] loadedData = new String[tableLenght][rawLenght];
        for (int i = 0; i < tableLenght; i++) {
            String[] csvRow = rowList.get(i).split(",");
            String[] catalogRow = new String[rawLenght];
            catalogRow[0] = csvRow[2];
            catalogRow[1] = csvRow[3];
            catalogRow[2] = csvRow[1];
            loadedData[i] = catalogRow;
        }
        return loadedData;
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
