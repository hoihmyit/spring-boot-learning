package com.spl.hm.redisson;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.util.ObjectUtils;

/**
 * @author Hôih My
 * Gitlab: https://gitlab.com/my.hoih
 * @since 29/07/2021
 */
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host:localhost}")
    private String redisHost;

    @Value("${spring.redis.port:6379}")
    private Integer redisPort;

    @Value("${spring.redis.password}")
    private String redisPass;

    @Bean
    public RedissonClient redissonClient() {
        final Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + redisHost + ":" + redisPort)
                .setPassword(ObjectUtils.isEmpty(redisPass) ? null : redisPass);

        return Redisson.create(config);
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);
        configuration.setPassword(redisPass);

        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public LockProvider lockProvider(Environment environment, RedisConnectionFactory redisConnectionFactory) {
        final String uniqueLockKey = String.format("%s-%s-%s", environment.getProperty("ENVIRONMENT", "local"), environment.getProperty("SERVICE", "local"), environment.getProperty("CLIENT", "local"));
        return new RedisLockProvider(redisConnectionFactory, uniqueLockKey);
    }
}
