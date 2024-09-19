package com.spl.hm.service;

import com.spl.hm.model.ProgramingLanguage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ReadTextFile {
    public static void main(String[] args) {
        System.out.println("Read text file with commons csv");
        final List<ProgramingLanguage> pl = readTextFile();
        System.out.println(pl);
    }

    private static List<ProgramingLanguage> readTextFile() {
        List<ProgramingLanguage> plList = new ArrayList<>();

        try {
            Reader reader = new FileReader(ReadTextFile.class.getClassLoader().getResource("programing_languages.txt").getFile());
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

            if (records.iterator().hasNext()) {
                for (CSVRecord record : records) {
                    ProgramingLanguage pl = new ProgramingLanguage();
                    pl.setType(record.get("type"));
                    pl.setLanguage(record.get("language"));
                    pl.setCountry(record.get("country"));

                    plList.add(pl);
                }
            } else {
                System.out.println("programing_languages.txt file is empty!");
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error while reading text file: " + e.getMessage());
        }

        return plList;
    }
}
