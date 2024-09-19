package com.spl.hm.redisson;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class FruitServiceImpl implements FruitService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FruitServiceImpl.class);
    private static final String FRUIT_CACHE_UPDATE_SCHEDULER = "FRUIT_CACHE_UPDATE_SCHEDULER";
    private final RedisFruitRepository redisFruitRepository;

    public FruitServiceImpl(RedisFruitRepository redisFruitRepository) {
        this.redisFruitRepository = redisFruitRepository;
    }

    @Override
    public List<FruitCacheEntry> getAllFruit() {
        FruitCacheEntry fruit1 = new FruitCacheEntry("1", "Apple", "Red");
        FruitCacheEntry fruit2 = new FruitCacheEntry("2", "Orange", "Orange");
        FruitCacheEntry fruit3 = new FruitCacheEntry("3", "Banana", "Green");

        List<FruitCacheEntry> fruitList = Arrays.asList(fruit1, fruit2, fruit3);

        // update to cache
        fruitList.stream().filter(Objects::nonNull).forEach(this::updateFruit);

        return fruitList;
    }

    @Override
    public void updateFruit(FruitCacheEntry fruitCacheEntry) {
        FruitCacheEntry cacheEntry = redisFruitRepository.get(fruitCacheEntry.getId());

        if (!ObjectUtils.isEmpty(cacheEntry)) {
            cacheEntry = new FruitCacheEntry(fruitCacheEntry.getId(), fruitCacheEntry.getName(), fruitCacheEntry.getColor());
        }

        redisFruitRepository.upsert(fruitCacheEntry.getId(), cacheEntry);
        LOGGER.info("Done update cache!");
    }

    @Override
    public void removeFruit(String id) {
        redisFruitRepository.delete(id);
    }

    @Scheduled(cron = "0 */30 * * * *")
    @SchedulerLock(name = FRUIT_CACHE_UPDATE_SCHEDULER, lockAtLeastFor = "PT30M", lockAtMostFor = "PT40M")
    public void scheduleUpdate() {
        LOGGER.info("Starting schedule update!");

        redisFruitRepository.getAll().stream()
                .filter(Objects::nonNull)
                .forEach(cacheEntry -> redisFruitRepository.upsert(cacheEntry.getId(), cacheEntry));

        LOGGER.info("Finish schedule update!");
    }
}
