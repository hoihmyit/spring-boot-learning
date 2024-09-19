package com.spl.hm.controller;

import com.spl.hm.response.BaseResponse;
import com.spl.hm.response.SuccessResponse;
import com.spl.hm.service.ReadCSVFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"v1/football-star", "internal/v1/football-star"})
public class ReadCSVFileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadCSVFileController.class);
    private final ReadCSVFile readCSVFile;

    @Autowired
    public ReadCSVFileController(ReadCSVFile readCSVFile) {
        this.readCSVFile = readCSVFile;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse getFootballStars() {
        LOGGER.info("Get football star info!");
        return new SuccessResponse<>(readCSVFile.getFootballStarList());
    }
}
