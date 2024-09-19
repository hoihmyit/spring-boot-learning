package com.spl.hm.redisson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 29/07/2021
 */
@RestController
@RequestMapping(value = "v1/fruits")
public class FruitController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FruitController.class);
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FruitCacheEntry> getFruit() {
        LOGGER.info("Get all fruits");
        return fruitService.getAllFruit();
    }
}
