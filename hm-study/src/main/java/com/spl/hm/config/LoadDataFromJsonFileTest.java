package com.spl.hm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spl.hm.model.AboutMe;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Objects;

@Component
public class LoadDataFromJsonFileTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDataFromJsonFileTest.class);
    private static AboutMe aboutMe = new AboutMe();
    private ObjectMapper objectMapper;
    private ResourceConfig resourceConfig;

    @Value("${hm.about_me_file:classpath:about_me.json}")
    private String aboutMeFile;

    public LoadDataFromJsonFileTest(final ObjectMapper objectMapper, final ResourceConfig resourceConfig) {
        this.objectMapper = objectMapper;
        this.resourceConfig = resourceConfig;
    }

    void loadAboutMeFile() {
        if (!StringUtils.isEmpty(aboutMeFile)) {
            final JSONObject jsonObject = resourceConfig.loadResourcesAsObject(aboutMeFile);

            try {
                if (Objects.nonNull(jsonObject)) {
                    aboutMe = objectMapper.readValue(jsonObject.toString(), AboutMe.class);
                }
            } catch (IOException e) {
                LOGGER.error("Load about me path {}, error: {}", aboutMeFile, e.getMessage());
            }
        }
    }

    public AboutMe getAboutMe() {
        return aboutMe;
    }
}
