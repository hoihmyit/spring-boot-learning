package com.spl.hm.repository;

import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RLocalCachedMap;
import org.redisson.api.RedissonClient;

import javax.annotation.PostConstruct;
import java.util.Map;

public class RedisAuthTokenRepository implements AuthTokenRepository {

    public static final String CACHE_PROVIDER_TOKEN = "CACHE_PROVIDER_TOKEN";

    private final RedissonClient redissonClient;

    private RLocalCachedMap<String, Map<String, String>> cacheProviderToken;

    public RedisAuthTokenRepository(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @PostConstruct
    public void setup() {
        cacheProviderToken = redissonClient.getLocalCachedMap(CACHE_PROVIDER_TOKEN, LocalCachedMapOptions.defaults());
    }

    @Override
    public Map<String, String> getAuthToken(String authId) {
        return cacheProviderToken.get(authId);
    }

    @Override
    public void upsertAuthToken(String authId, Map<String, String> authToken) {
        cacheProviderToken.put(authId, authToken);
    }

    @Override
    public void deleteAuthToken(String authId) {
        cacheProviderToken.remove(authId);
    }
}
