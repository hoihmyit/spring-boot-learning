package com.spl.hm.service;

import com.spl.hm.model.FootballStar;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReadCSVFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadCSVFile.class);

    public List<FootballStar> getFootballStarList() {
        List<FootballStar> footballStars = new ArrayList<>();
        LOGGER.info("Start read csv file");

        try {
            // final String path = classpath:football_star.csv
            // InputStreamReader in = new InputStreamReader(resourceLoader.getResource(path).getInputStream(), StandardCharsets.UTF_8);
            Reader reader = new FileReader(getClass().getClassLoader().getResource("football_star.csv").getFile());
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

            if (records.iterator().hasNext()) {
                for (CSVRecord record : records) {
                    FootballStar star = new FootballStar();
                    star.setId(Integer.parseInt(record.get("id")));
                    star.setName(record.get("name"));
                    star.setBirthday(record.get("birthday"));
                    star.setTeam(record.get("team"));
                    star.setCountry(record.get("country"));
                    footballStars.add(star);
                }
            } else {
                LOGGER.error("football_star.csv file is empty!");
            }

            reader.close();
        } catch (IOException e) {
            LOGGER.error("Error while reading csv file: {}", e.getMessage());
        }

        LOGGER.info("End read csv file");
        return footballStars;
    }
}
