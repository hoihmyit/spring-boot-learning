package com.spl.hm.controller;

import com.spl.hm.config.LOLConfig;
import com.spl.hm.response.BaseResponse;
import com.spl.hm.response.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"v1/champions", "internal/v1/champions"})
public class LOLController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LOLController.class);

    private final LOLConfig lolConfig;

    @Autowired
    public LOLController(final LOLConfig lolConfig) {
        this.lolConfig = lolConfig;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse getChampions() {
        LOGGER.info("Get champion list!");
        return new SuccessResponse<>(lolConfig.getChampionList());
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse getChampionByNameWithPathVariable(
            @PathVariable("name") String name) {

        LOGGER.info("Using PathVariable for get football star info with name: {}!", name);
        return new SuccessResponse<>(lolConfig.getChampionByName(name));
    }

    @GetMapping(value = "/withRequestParam", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse getChampionByNameWithRequestParam(
            @RequestParam(value = "championName") String championName) {

        LOGGER.info("Using RequestParam for get football star info with champion name: {}!", championName);
        return new SuccessResponse<>(lolConfig.getChampionByName(championName));
    }
}
