package com.spl.hm.controller;

import com.spl.hm.config.LoadDataFromJsonFileTest;
import com.spl.hm.response.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class SystemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

    private final LoadDataFromJsonFileTest me;

    @Autowired
    public SystemController(LoadDataFromJsonFileTest me) {
        this.me = me;
    }

    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public SuccessResponse about() {
        LOGGER.info("Get about me info!");
        return new SuccessResponse(me.getAboutMe());
    }
}
