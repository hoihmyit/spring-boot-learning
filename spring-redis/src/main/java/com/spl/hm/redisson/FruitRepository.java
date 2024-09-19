package com.spl.hm.redisson;

import java.util.List;

public interface FruitRepository {
    List<FruitCacheEntry> getAll();

    FruitCacheEntry get(String id);

    void delete(String id);

    void upsert(String id, FruitCacheEntry fruitCacheEntry);
}
