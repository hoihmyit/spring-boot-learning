package com.spl.hm.redisson;

import java.util.List;

public interface FruitService {
    List<FruitCacheEntry> getAllFruit();

    void updateFruit(FruitCacheEntry fruitCacheEntry);

    void removeFruit(String id);
}
