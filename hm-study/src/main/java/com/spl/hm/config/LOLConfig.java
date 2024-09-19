package com.spl.hm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spl.hm.config.mapper.Champion;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class LOLConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(LOLConfig.class);
    private static List<Champion> championList = new ArrayList<>();
    private ObjectMapper objectMapper;
    private ResourceConfig resourceConfig;

    @Value("${hm.lol_type_of_champion_file:classpath:LOL_type_of_champions.json}")
    private String lolChampionFilePath;

    public LOLConfig(final ObjectMapper objectMapper, final ResourceConfig resourceConfig) {
        this.objectMapper = objectMapper;
        this.resourceConfig = resourceConfig;
    }

    void loadLOLChampionConfig() {
        final JSONArray configObject = resourceConfig.loadResourcesAsArray(lolChampionFilePath);

        try {
            if (Objects.nonNull(configObject)) {
                championList = Arrays.asList(objectMapper.readValue(configObject.toJSONString(), Champion[].class));
            }
        } catch (IOException e) {
            LOGGER.error("Load lol type of champion path {}, error: {}", lolChampionFilePath, e.getMessage());
        }
    }

    public List<Champion> getChampionList() {
        return championList;
    }

    public Champion getChampionByName(final String name) {
        Champion champion = new Champion();

        if (CollectionUtils.isEmpty(championList)) {
            return champion;
        }

        for (Champion champ : championList) {
            if (StringUtils.hasText(name) && name.equals(champ.getChampion())) {
                champion = champ;
                break;
            }
        }

        return champion;
    }
}
