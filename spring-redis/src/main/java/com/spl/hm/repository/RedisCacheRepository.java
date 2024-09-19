package com.spl.hm.repository;

import java.util.Map;

public interface RedisCacheRepository<T> {

    <T> void save(String cacheKey, String hashKey, T value);

    T findByKey(String cacheKey, String hashKey);

    void deleteByKey(String cacheKey, String hashKey);

    Map<String, Object> findAllWithCacheName(String cacheName);

}
