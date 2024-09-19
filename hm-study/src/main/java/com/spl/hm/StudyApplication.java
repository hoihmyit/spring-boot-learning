package com.spl.hm;

import com.spl.hm.config.UserInfoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication implements CommandLineRunner {

    @Autowired
    private UserInfoConfig userInfoConfig;

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
        System.out.println("Study Module!");
    }

    public void run(String... strings) {
        System.out.println(userInfoConfig);
    }
}
