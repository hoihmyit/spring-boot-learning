package com.spl.hm;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 09/04/2021
 */
@SpringBootApplication
@EnableSchedulerLock(defaultLockAtMostFor = "PT5M")
public class SpringRedisApplication {

    /**
     * Redis là 1 hệ thống lưu trữ key-value in-memory rất mạnh mẽ và phổ biến hiện nay.
     * <p>
     * Redis nổi bật bởi việc hỗ trợ nhiều cấu trúc dữ liệu khác nhau (hash, list, set, sorted set, string), giúp việc thao tác với dữ liệu cực kì nhanh và thuận tiện.
     * <p>
     * Các hệ thống ngày nay luôn tìm cách tối ưu performance và Redis gần như là một mảnh ghép không thể thiếu trong đó.
     */

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplication.class, args);
    }
}
