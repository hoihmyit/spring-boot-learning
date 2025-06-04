package com.springbootcache.hm;

import com.springbootcache.hm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootCachingApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootCachingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCachingApplication.class);
    }

    @Autowired
    private UserService userService;

    /*
     * CommandLineRunner is a simple Spring Boot interface with a run method.
     * Spring Boot will automatically call the run method of all beans implementing this interface after the application context has been loaded.
     */
    @Override
    public void run(String... args) {
        logger.info("------------------ demo @Cacheable --------------------");
        logger.info("find user with id = 1: {}", userService.findUserById(1));
        logger.info("find user with id = 1: {}", userService.findUserById(1));
        logger.info("find user with id = 2: {}", userService.findUserById(2));
        logger.info("find user with id = 2: {}", userService.findUserById(2));

        logger.info("------------------ demo @CacheEvict --------------------");
        userService.clearCache();
        logger.info("find user with id = 1: {}", userService.findUserById(1));
        logger.info("find user with id = 2: {}", userService.findUserById(2));

        logger.info("------------------ demo @CachePut --------------------");
        logger.info("reload and find user with id = 1: {}", userService.reloadAndFindUserById(1));
        logger.info("find user with id = 1: {}", userService.findUserById(1));
        logger.info("find user with id = 2: {}", userService.findUserById(2));
    }
}
