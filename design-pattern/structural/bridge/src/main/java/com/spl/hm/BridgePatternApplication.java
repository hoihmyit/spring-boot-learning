package com.spl.hm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 29/06/2021
 * <p>
 * Bridge: Separates an object’s interface from its implementation
 */
@SpringBootApplication
public class BridgePatternApplication {
    public static void main(String[] args) {
        SpringApplication.run(BridgePatternApplication.class, args);
    }

    /**
     * Ví dụ: Một hệ thống ngân hàng cung cấp các loại tài khoản khác nhau cho khách hàng, chẳng hạn: Checking account và Saving account.
     */
}
