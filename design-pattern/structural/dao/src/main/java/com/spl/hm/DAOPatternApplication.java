package com.spl.hm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 12/07/2021
 * <p>
 * DAO Pattern: Data Access Object Pattern
 */
@SpringBootApplication
public class DAOPatternApplication {
    public static void main(String[] args) {
        SpringApplication.run(DAOPatternApplication.class, args);
    }

    /**
     * Ví dụ: áp dụng DAO Pattern trong việc cung cấp interface chung để thao tác với cơ sở dữ liệu (CRUD). Các thao tác này bao gồm: Create/Save, Read/Get, Update, Delete.
     */
}
