package com.spl.hm.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class RedisCacheRepositoryImpl<T> implements RedisCacheRepository<T> {
    protected final Logger LOGGER = LoggerFactory.getLogger(RedisCacheRepositoryImpl.class);

    private final RedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;
    private HashOperations<String, String, Object> hashOperations;

    public RedisCacheRepositoryImpl(RedisTemplate redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    @SuppressWarnings("PMD")
    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public <T> void save(String cacheKey, String hashKey, T value) {
        hashOperations.put(cacheKey, hashKey, value);
    }

    public <T> void saveAll(String cacheKey, Map<String, T> mapHashKeyWithValue) {
        hashOperations.putAll(cacheKey, mapHashKeyWithValue);
    }

    @Override
    public T findByKey(String cacheKey, String hashKey) {
        return (T) hashOperations.get(cacheKey, hashKey);
    }

    @Override
    public void deleteByKey(String cacheKey, String key) {
        hashOperations.delete(cacheKey, key);
    }

    public Boolean deleteByCacheKey(String cacheKey) {
        return redisTemplate.delete(cacheKey);
    }

    @Override
    public Map<String, Object> findAllWithCacheName(String cacheName) {
        return hashOperations.entries(cacheName);
    }

    // Note: redis won't save object which is not Serializable
    protected String convertToStringData(Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException ex) {
            LOGGER.error("Error while convert data object to String: {}", ex.getMessage());
        }

        return null;
    }

    protected <T> T parseStringDataToObject(String data, TypeReference<T> typeReference) {
        if (ObjectUtils.isEmpty(data)) {
            return null;
        }

        try {
            return objectMapper.readValue(data, typeReference);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error while parseStringDataToObject : {}", e.getMessage());
        }

        return null;
    }

}
