package com.spl.hm.service;

import com.spl.hm.model.DoraemonCharacter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class ReadTXTFileTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadTXTFileTest.class);

    @Test
    public void testReadTXTFile_By_BufferedReader() {
        LOGGER.info("Starting read text file by BufferedReader");
        try {
            File file = new File(getClass().getClassLoader().getResource("doraemon_characters.txt").getFile());
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<DoraemonCharacter> doraemonCharacters = new ArrayList<>();
            List<String> headers = new ArrayList<>();
            String str;

            while ((str = br.readLine()) != null) {

                if (CollectionUtils.isEmpty(headers)) {
                    headers = new ArrayList(Arrays.asList(str.split(",")));
                } else {
                    List<String> items = Arrays.stream(str.split(",")).collect(Collectors.toList());
                    DoraemonCharacter doraemon = new DoraemonCharacter();
                    doraemon.setId(Integer.parseInt(items.get(0)));
                    doraemon.setName(items.get(1));
                    doraemon.setAvatar(items.get(2));

                    doraemonCharacters.add(doraemon);
                }
            }

            System.out.println(doraemonCharacters);
            LOGGER.info("Ending read text file by BufferedReader");
            br.close();

        } catch (IOException e) {
            LOGGER.error("Error while reading text file: {}", e.getMessage());
        }
    }

    @Test
    public void testReadTXTFile_By_Apache_Commons_CSV_Library() {
        LOGGER.info("Starting read text file by Apache Commons CSV Library");
        try {
            Reader reader = new FileReader(getClass().getClassLoader().getResource("doraemon_characters.txt").getFile());
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            List<DoraemonCharacter> doraemonCharacters = new ArrayList<>();

            if (records.iterator().hasNext()) {
                for (CSVRecord record : records) {
                    DoraemonCharacter doraemon = new DoraemonCharacter();
                    doraemon.setId(Integer.parseInt(record.get("id")));
                    doraemon.setName(record.get("name"));
                    doraemon.setAvatar(record.get("avatar"));

                    doraemonCharacters.add(doraemon);
                }
            } else {
                LOGGER.error("doraemon_characters.txt file is empty!");
            }

            System.out.println(doraemonCharacters);
            LOGGER.info("Ending read text file by Apache Commons CSV Library");
            reader.close();

        } catch (IOException e) {
            LOGGER.error("Error while reading text file: {}", e.getMessage());
        }
    }

    @Test
    public void testReadTXTFile_By_FileReader() {
        try {
            FileReader fr = new FileReader(getClass().getClassLoader().getResource("doraemon_characters.txt").getFile());
            int i;

            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            LOGGER.error("Error while reading text file: {}", e.getMessage());
        }
    }
}
