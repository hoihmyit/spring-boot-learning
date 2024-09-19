package com.spl.hm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 09/04/2021
 */
@Component
public class RedisExample implements CommandLineRunner {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        valueExample();

        listExample();
    }

    public void valueExample() {
        // opsForValue(): Kiểu Key-Value thông thường. Với Value là 1 giá trị String tùy ý.
        // Set giá trị của key "whoami" là "Hello! I'm Hoih My"
        redisTemplate.opsForValue().set("whoami", "Hello! I'm Hoih My");

        // In ra màn hình giá trị của key "whoami" trong Redis
        System.out.println("Value of key whoami: " + redisTemplate.opsForValue().get("whoami"));
    }

    public void listExample() {
        // Tạo ra một list gồm 2 phần tử
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("redis");

        // opsForList(): Tương ứng với cấu trúc List trong Redis, value là một list.
        // Set giá trị có key redis_list
        redisTemplate.opsForList().rightPushAll("redis_list", list);

        System.out.println("Size of key redis_list: " + redisTemplate.opsForList().size("redis_list"));
    }
}
