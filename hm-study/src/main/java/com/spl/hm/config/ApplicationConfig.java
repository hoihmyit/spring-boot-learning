package com.spl.hm.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

    private final LoadDataFromJsonFileTest loadDataFromJsonFileTest;
    private final LOLConfig lolConfig;

    @Autowired
    public ApplicationConfig(final LoadDataFromJsonFileTest loadDataFromJsonFileTest, final LOLConfig lolConfig) {
        this.loadDataFromJsonFileTest = loadDataFromJsonFileTest;
        this.lolConfig = lolConfig;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReadyAndLoadConfiguration() {
        loadDataFromJsonFileTest.loadAboutMeFile();

        lolConfig.loadLOLChampionConfig();

        LOGGER.debug("Done read configuration!");
    }
}
