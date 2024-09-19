package com.spl.hm.redisson;

import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RLocalCachedMap;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RedisFruitRepository implements FruitRepository {
    private static final String CACHE_FRUIT_REPOSITORY = "CACHE_FRUIT_REPOSITORY";
    private final RedissonClient redissonClient;
    private RLocalCachedMap<String, FruitCacheEntry> cacheFruitMap;

    public RedisFruitRepository(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @PostConstruct
    public void setup() {
        cacheFruitMap = redissonClient.getLocalCachedMap(CACHE_FRUIT_REPOSITORY, LocalCachedMapOptions.defaults());
    }

    @Override
    public List<FruitCacheEntry> getAll() {
        return new ArrayList<>(cacheFruitMap.readAllValues());
    }

    @Override
    public FruitCacheEntry get(String id) {
        return cacheFruitMap.get(id);
    }

    @Override
    public void delete(String id) {
        cacheFruitMap.remove(id);
    }

    @Override
    public void upsert(String id, FruitCacheEntry fruitCacheEntry) {
        cacheFruitMap.put(id, fruitCacheEntry);
    }
}
