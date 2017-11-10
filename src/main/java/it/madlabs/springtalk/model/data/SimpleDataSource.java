package it.madlabs.springtalk.model.data;

public interface SimpleDataSource {
    String[] getRawDataHeader(String tableName);

    String[][] getRawDataList(String tableName);
}
