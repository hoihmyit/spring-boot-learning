package com.spl.hm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spl.hm.config.mapper.Champion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteListObjectToJsonFile {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Champion> championList = new ArrayList<>();
        Champion champion1 = new Champion();
        champion1.setChampion("Hayate");
        champion1.setFullName("Hayate");
        champion1.setAdaptiveType("Physical");

        Champion champion2 = new Champion();
        champion2.setChampion("Arthur");
        champion2.setFullName("Arthur");
        champion2.setAdaptiveType("Physical");
        championList.add(champion1);
        championList.add(champion2);

        String path = String.format("%s", System.getProperty("user.dir") + "/hm-study/src/main/resources/write_list_of_object_to_json_file.json");
        File file = new File(path);

//        File file = new File("/Users/hmy/Projects/Learning/spring-boot-learning/hm-study/src/main/resources/write_list_of_object_to_json_file.json");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        System.out.println(championList);
        String json = objectMapper.writeValueAsString(championList);
        System.out.println(json);
        fileWriter.write(json);

        fileWriter.flush();
        fileWriter.close();
    }
}
