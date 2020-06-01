package org.rajesh.aws.s3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessCsv {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCsv.class);
    private String[][] csvData;
    private Map<String, Integer> columnNameIndexMap;

    ProcessCsv(final String csvFileName) throws IOException {
        FileReader fileReader = new FileReader(csvFileName);
        BufferedReader myInput = new BufferedReader(fileReader);
        List<String[]> lines = new ArrayList<>();
        String currentLine;
        while ((currentLine = myInput.readLine()) != null) {
            lines.add(currentLine.split(","));
        }

        csvData = new String[lines.size()][0];
        lines.toArray(csvData);

        final String[] columns = lines.get(0);
        setColumnIndexMap(columns);
    }

    private void setColumnIndexMap(String[] columns) {
        columnNameIndexMap = new HashMap<>();
        for (int index = 0; index < columns.length; index++) {
            columnNameIndexMap.put(columns[index], index);
        }
    }

    void readCsvFile(List<String> columnNames) throws IOException {
//        for (int row = 0; row < csvData.length; row++) {
//            for (int column = 0; column < csvData[row].length; column++) {
//                LOGGER.info("Value = {}", csvData[row][column]);
//            }
//        }

        for (String[] csvDatum : csvData) {
            for(String column: columnNames) {
                LOGGER.info("{} = {}", column, csvDatum[columnNameIndexMap.get(column)]);
            }
        }
    }
}
