package com.spl.hm.service;

import com.spl.hm.model.Booked;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReadCSVFileTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadCSVFile.class);

    @Test
    public void testReadCSVFile() {
        List<Booked> bookedList = new ArrayList<>();

        try {
            Reader reader = new FileReader(getClass().getClassLoader().getResource("book.csv").getFile());
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

            if (records.iterator().hasNext()) {
                for (CSVRecord record : records) {
                    Booked booked = new Booked();
                    booked.setId(Integer.parseInt(record.get("id")));
                    booked.setTitle(record.get("title"));
                    booked.setAuthor(record.get("author"));
                    booked.setBookURL(record.get("book_url"));

                    bookedList.add(booked);
                }

            } else {
                LOGGER.error("book.csv file is empty!");
            }

            System.out.println(bookedList);

            reader.close();
        } catch (IOException e) {
            LOGGER.error("Error while reading csv file: {}", e.getMessage());
        }
    }
}
