package com.spl.hm.config;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class ResourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceConfig.class);
    private final ResourceLoader resourceLoader;

    @Autowired
    public ResourceConfig(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public JSONObject loadResourcesAsObject(final String path) {

        JSONObject jsonObject = null;

        try {
            jsonObject = (JSONObject) new JSONParser().parse(new InputStreamReader(resourceLoader.getResource(path).getInputStream(), StandardCharsets.UTF_8));
        } catch (IOException | ParseException e) {
            LOGGER.error("Load resource path {}, error: {}", path, e.getMessage());
        }
        return jsonObject;
    }

    public JSONArray loadResourcesAsArray(final String path) {

        JSONArray jsonArray = null;

        try {
            jsonArray = (JSONArray) new JSONParser().parse(new InputStreamReader(resourceLoader.getResource(path).getInputStream(), StandardCharsets.UTF_8));
        } catch (IOException | ParseException e) {
            LOGGER.error("Load resource path {}, error: {}", path, e.getMessage());
        }

        return jsonArray;
    }

    // way 2
    public JSONObject loadResourcesAsObject2(final String path) {
        JSONObject jsonObject = null;

        try (InputStreamReader inputStream = new InputStreamReader(resourceLoader.getResource(path).getInputStream(), StandardCharsets.UTF_8)) {
            jsonObject = (JSONObject) new JSONParser().parse(inputStream);
        } catch (IOException | ParseException e) {
            LOGGER.error("Load resource path {}, error: {}", path, e.getMessage());
        }

        return jsonObject;
    }

    public JSONArray loadResourcesAsArray2(final String path) {
        JSONArray jsonArray = null;

        try (InputStreamReader inputStream = new InputStreamReader(resourceLoader.getResource(path).getInputStream(), StandardCharsets.UTF_8)) {
            jsonArray = (JSONArray) new JSONParser().parse(inputStream);
        } catch (IOException | ParseException e) {
            LOGGER.error("Load resource path {}, error: {}", path, e.getMessage());
        }

        return jsonArray;
    }
}
